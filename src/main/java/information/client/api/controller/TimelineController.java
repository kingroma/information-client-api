package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.responsedto.TimelineDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.TimelineService;

@Controller 
@RequestMapping("/timeline")
public class TimelineController {

	private static final Logger logger = LoggerFactory.getLogger(TimelineController.class);
	
	@Resource
	private TimelineService timelineService;
	
	@RequestMapping(value = "/listAll" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<TimelineDto> listAll(
			HttpServletRequest request , HttpServletResponse response , 
			@RequestParam(value = "offset" , required = false) String offsetStr , 
			@RequestParam(value = "limit" , required = false) String limitStr
			
			){
		int offset = 0 ; 
		int limit = 10 ;
		
		if ( offsetStr != null && !offsetStr.isEmpty() ) {
			try {
				offset = Integer.parseInt(offsetStr);
			} catch (Exception e) {	}
		}
		
		if ( limitStr != null && !limitStr.isEmpty()) {
			try {
				limit = Integer.parseInt(limitStr);
			} catch (Exception e) {	}
		}
		
		TotalDto<TimelineDto> result = timelineService.listAll(offset, limit);
		result.settingTotalCount();
		return result ;
	} 
	
}
