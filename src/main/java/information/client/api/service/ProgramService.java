package information.client.api.service;

import java.util.List;

import information.client.api.form.ProgramForm;
import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;

public interface ProgramService {

	public Integer countAll();
	
	public TotalDto<ProgramDto> listAll() ; 
	
	public TotalDto<ProgramDto> listAll( int offset , int limit ) ;
	
	public List<ProgramDto> search(String search); 
	
	public ProgramDto getByIdWithProgramProduct(String programId) ;
	
	public ProgramDto save(ProgramForm form);
}
