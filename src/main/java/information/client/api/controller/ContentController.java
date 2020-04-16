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

import information.client.api.responsedto.ContentDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@Resource
	private ContentService contentService;
	
	@RequestMapping(value = "/listAll" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ContentDto> listAll(HttpServletRequest request , HttpServletResponse response){
		TotalDto<ContentDto> result = new TotalDto<ContentDto>();
		
		try {
			result.setResult(contentService.listAll());
		} catch (Exception e) {
			logger.error("listAll ERROR message = {} " , e.getMessage() , e );
		}
		
		result.settingTotalCount();
		return result ;
	}
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ContentDto> listContentType(
			HttpServletRequest request , HttpServletResponse response ,
			@RequestParam(value = "contentType" , required = false ) String contentType 
			){
		TotalDto<ContentDto> result = new TotalDto<ContentDto>();
		
		if ( contentType == null || contentType.isEmpty() ) {
			result.setResultCode(TotalDto.PARAM_ERROR);
			result.setErrorMessage("contentType is empty");
			result.setTotalCount(null);
			return result ; 
		}else { contentType = contentType.trim(); } 		
		
		try {
			result.setResult(contentService.list(contentType));
		} catch (Exception e) {
			logger.error("listContentType ERROR message = {} " , e.getMessage() , e );
		}
		
		result.settingTotalCount();
		return result ;
	}
}
