package information.client.api.service;

import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.form.ProgramForm;

public interface ProgramService {

	public TotalDto<ProgramDto> findAll() ;
	
	public ProgramDto findByIdWithProgramProduct(String programId) ;
	
	public ProgramDto save(ProgramForm form);
}
