package information.client.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import information.client.api.domain.Genre;
import information.client.api.domain.Program;
import information.client.api.domain.ProgramGenre;
import information.client.api.domain.ProgramProduct;
import information.client.api.dto.ProgramDto;
import information.client.api.dto.ProgramProductDto;
import information.client.api.dto.TotalDto;
import information.client.api.form.ProgramForm;
import information.client.api.service.ProgramService;

@Controller
@RequestMapping("/program/")
public class ProgramController {

	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	
	@Resource
	private ProgramService programService ; 
	
	@RequestMapping(value = "/listAll" , method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<ProgramDto> listAll(HttpServletRequest request , HttpServletResponse response){
		TotalDto<ProgramDto> result = new TotalDto<ProgramDto>();
		
		List<Program> list = programService.findAll();
		
		if ( list != null ) {
			for ( Program p : list ) { 
				result.add(domainToDto(p));
			}
		}
		
		return result ;
	} 
	
	@RequestMapping(value = "/information/{PROGRAM_ID}" , method = RequestMethod.GET)
	@ResponseBody
	public ProgramDto getInformation(
			HttpServletRequest request , HttpServletResponse response ,
			 @PathVariable("PROGRAM_ID") String programId 
			){
		ProgramDto result = new ProgramDto();
		
		if ( programId != null && !programId.isEmpty() ) {
			result = programService.findById(programId);
		}
		
		return result ;
	} 
	
	
	@RequestMapping(value = "/information", method = RequestMethod.POST)
	@ResponseBody
	public Program saveInformation(
			HttpServletRequest request , HttpServletResponse response ,
			@ModelAttribute ProgramForm form 
			) {
		
		Program p = programService.save(form);
		
		return p ; 
	}
	
	private ProgramDto domainToDto(Program p) {
		List<String> genres = new ArrayList<String>();
		List<ProgramProductDto> programProducts = new ArrayList<ProgramProductDto>();
		
		List<ProgramGenre> pgList = p.getProgramGenre();
		List<ProgramProduct> ppList = p.getProgramProduct();
		
		if ( pgList != null ) { 
			for ( ProgramGenre pg : pgList ) {
				Genre g = pg.getGenre();
				if ( g != null && g.getGenreName() != null ) {
					genres.add(g.getGenreName());
				}
			}
		}
		
		if ( ppList != null ) {
			for ( ProgramProduct pp : ppList) { 
				ProgramProductDto ppDto = new ProgramProductDto();
				ppDto.setProgramId(pp.getId().getProgramId());
				ppDto.setProductId(pp.getId().getProductId());
				ppDto.setTitle(pp.getTitle());
				programProducts.add(ppDto);
			}
		}
		
		ProgramDto dto = new ProgramDto();
		dto.setProgramId(p.getProgramId());
		dto.setTitle(p.getTitle());
		dto.setSynopsis(p.getSynopsis());
		dto.setGenres(genres);
		dto.setProducts(programProducts);
		
		return dto;
	}
	
}
