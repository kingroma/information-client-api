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

import information.client.api.form.ProgramForm;
import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.ProgramProductDto;
import information.client.api.responsedto.ResponseDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ProgramProductService;
import information.client.api.service.ProgramService;

@Controller
@RequestMapping("/program")
public class ProgramController {

	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	@Resource
	private ProgramService programService ;
	
	@Resource
	private ProgramProductService programProductService ;
	
	@RequestMapping(value = "/information/listAll" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ProgramDto> listAll(HttpServletRequest request , HttpServletResponse response){
		TotalDto<ProgramDto> result = programService.listAll();
		result.settingTotalCount();
		return result ;
	} 
	
	@RequestMapping(value = "/search/{SEARCH}" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ProgramDto> getSearch(
			HttpServletRequest request , HttpServletResponse response ,
			 @PathVariable("SEARCH") String search ){
		TotalDto<ProgramDto> result = new TotalDto<ProgramDto>();
		
		if ( search != null && !search.isEmpty() ) {
			result.setResult(programService.search(search));
		} else {
			result.setResultCode(TotalDto.ERROR_CODE);
		}
		
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
			dto = programService.getByIdWithProgramProduct(programId);
			if ( dto == null ) {
				result.setResultCode(ResponseDto.NOT_FOUND);
				result.setResultMessage("Not Found");
			}else {
				result.setResult(dto);
			}
		} else {
			result.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			result.setResultMessage("programId is null");
		}
		
		return result ;
	} 
	
	@RequestMapping(value = "/product/information/{PRODUCT_ID}", method = RequestMethod.GET )
	@ResponseBody
	public ResponseDto<ProgramProductDto> getProductInformation(
			HttpServletRequest request , HttpServletResponse response ,
			 @PathVariable("PRODUCT_ID") String productId
			) {
		logger.info("productId = {}",productId);
		
		ResponseDto<ProgramProductDto> result = new ResponseDto<ProgramProductDto>();
		ProgramProductDto dto = null ; 
		
		if ( productId != null && !productId.isEmpty() ) {
			dto = programProductService.getById(productId);
			
			if ( dto == null ) {
				result.setResultCode(ResponseDto.NOT_FOUND);
				result.setResultMessage("Not Found");
			}else {
				result.setResult(dto);
			}
		} else {
			result.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			result.setResultMessage("productId is null");
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
