package information.client.api.service;

import information.client.api.dto.ProgramDto;
import information.client.api.dto.TotalDto;
import information.client.api.form.ProgramForm;

public interface ProgramService {

	public TotalDto<ProgramDto> findAll() ;
	
	public ProgramDto findById(String programId) ;
	
	public ProgramDto save(ProgramForm form);
}
