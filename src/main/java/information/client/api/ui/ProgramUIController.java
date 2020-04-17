package information.client.api.ui;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ProgramService;

@Controller
public class ProgramUIController {
	private static final Logger logger = LoggerFactory.getLogger(ProgramUIController.class);
	
	private static int LIMIT = 100;
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Resource
	private ProgramService programService ; 
	
	@RequestMapping("/ui/program/list")
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
		model.addAttribute("count",programService.countAll());
		
		return "program/list";
	} 
}