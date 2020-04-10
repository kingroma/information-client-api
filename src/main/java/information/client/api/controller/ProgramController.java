package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.ResponseDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.form.ProgramForm;
import information.client.api.service.ProgramService;

@Controller
@RequestMapping("/program")
public class ProgramController {

	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	@Resource
	private ProgramService programService ; 
	
	@RequestMapping(value = "/information/listAll" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ProgramDto> listAll(HttpServletRequest request , HttpServletResponse response){
		TotalDto<ProgramDto> result = programService.findAll();
		result.settingTotalCount();
		return result ;
	} 
	
	@RequestMapping(value = "/information/{PROGRAM_ID}" , method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto<ProgramDto> getInformation(
			HttpServletRequest request , HttpServletResponse response ,
			 @PathVariable("PROGRAM_ID") String programId 
			){
		logger.info("programId = {}",programId);
		
		ResponseDto<ProgramDto> result = new ResponseDto<ProgramDto>();
		ProgramDto dto = null ; 
		
		if ( programId != null && !programId.isEmpty() ) {
			dto = programService.findById(programId);
			result.setResult(dto);
		}
		
		return result ;
	} 
	
	
	@RequestMapping(value = "/information", method = RequestMethod.POST)
	@ResponseBody
	public ProgramDto saveInformation(
			HttpServletRequest request , HttpServletResponse response ,
			@ModelAttribute ProgramForm form 
			) {
		
		ProgramDto dto = programService.save(form);
		
		return dto ; 
	}
	
	
}
