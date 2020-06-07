package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.responsedto.MusicMetaDto;
import information.client.api.responsedto.ResponseDto;
import information.client.api.service.MusicMetaService;

@Controller
@RequestMapping("/music")
public class MusicController {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicController.class);
	
	@Resource
	private MusicMetaService musicMetaService;
	
	@RequestMapping(value = "/information/{MUSIC_ID}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto<MusicMetaDto> getInformation(
			HttpServletRequest request , HttpServletResponse response ,
			@PathVariable("MUSIC_ID") String musicId 
			){
		logger.info("musicId = {}" , musicId);
		
		ResponseDto<MusicMetaDto> result = new ResponseDto<MusicMetaDto>();
		MusicMetaDto dto = null ; 
		
		if ( musicId != null && !musicId.isEmpty()){
			dto = musicMetaService.getInformation(musicId);
			
			if ( dto == null ){
				result.setResultCode(ResponseDto.NOT_FOUND);
				result.setResultMessage("Not Found");
			}else {
				result.setResult(dto);
			}
		} else {
			result.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			result.setResultMessage("musicId is null");
		}
		
		return result; 
	}
	
}
