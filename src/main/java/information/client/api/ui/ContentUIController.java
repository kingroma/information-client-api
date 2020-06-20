package information.client.api.ui;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import information.client.api.form.ContentUiForm;
import information.client.api.responsedto.ContentDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ContentService;
import information.client.api.service.ContentUiService;

@Controller
@RequestMapping("/ui/content")
public class ContentUIController {
	private static int LIMIT = 1000 ; 
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Resource
	private ContentService contentService;
	
	@Resource 
	private ContentUiService contentUiService ; 
	
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
		
		List<ContentDto> list = contentService.listAll(offset, LIMIT);
		TotalDto<ContentDto> result = new TotalDto<ContentDto>();
		result.setResult(list);
		result.settingTotalCount();
		
		String json = "{}" ;
		Map<String,Object> map = null ; 
		try {
			json = om.writeValueAsString(result);
			map = om.readValue(json, Map.class);
			System.out.println(json);
		} catch (Exception e) {	e.printStackTrace(); }
		
		
		model.addAttribute("list",map);
		model.addAttribute("count",result.getTotalCount());
		
		return "content/contentList";
	}
	
	@RequestMapping("/save")
	public String save(
			HttpServletRequest request ,
			@ModelAttribute ContentUiForm form 
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
		contentUiService.save(form);
		
		return "redirect:/ui/content/list";
	} 
}
