package information.client.api.ui;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import information.client.api.form.ProgramUiForm;
import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.GenreService;
import information.client.api.service.ProgramService;
import information.client.api.service.ProgramUiService;

@Controller
@RequestMapping("/ui/program")
public class ProgramUIController {
	private static final Logger logger = LoggerFactory.getLogger(ProgramUIController.class);
	
	private static int LIMIT = 1000;
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Resource
	private ProgramService programService ;
	
	@Resource
	private GenreService genreService ; 
	
	@Resource
	private ProgramUiService programUiService ; 
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		int offset = 1 ;
		
		String offsetStr = (String)model.get("offset");
		if ( offsetStr == null ) {
			offsetStr = "1" ; 
		}
		
		try {
			offset = Integer.parseInt(offsetStr);
		} catch (Exception e) { offset = 1 ;}
		
		offset--;
		
		TotalDto<ProgramDto> list = programService.listAll(offset, LIMIT);
		list.settingTotalCount();
		
		String json = "{}" ;
		Map<String,Object> map = null ; 
		try {
			json = om.writeValueAsString(list);
			map = om.readValue(json, Map.class);
		} catch (Exception e) {	e.printStackTrace(); }
		
		
		model.addAttribute("list",map);
		model.addAttribute("count",list.getTotalCount());
		
		return "program/programList";
	} 
	
	@RequestMapping("/save")
	public String save(
			HttpServletRequest request ,
			@ModelAttribute ProgramUiForm form 
			) {
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024*1024*15;
		try {
//			MultipartRequest multi = new MultipartRequest(request, "/image/", sizeLimit, "utf-8", new DefaultFileRenamePolicy());
//			multi.get
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println(form);
		programUiService.save(form);
		
		return "redirect:/ui/program/list";
	} 
	
	
}
