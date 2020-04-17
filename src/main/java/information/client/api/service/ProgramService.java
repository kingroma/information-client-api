package information.client.api.service;

import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.form.ProgramForm;

public interface ProgramService {

	public Integer countAll();
	
	public TotalDto<ProgramDto> listAll() ; 
	
	public TotalDto<ProgramDto> listAll( int offset , int limit ) ; 
	
	public ProgramDto findByIdWithProgramProduct(String programId) ;
	
	public ProgramDto save(ProgramForm form);
}
