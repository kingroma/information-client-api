package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		TotalDto<ContentDto> result = contentService.findAll();
		result.settingTotalCount();
		return result ;
	}
}
