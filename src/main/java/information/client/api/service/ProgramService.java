package information.client.api.service;

import java.util.List;

import information.client.api.domain.Program;
import information.client.api.dto.ProgramDto;
import information.client.api.form.ProgramForm;

public interface ProgramService {

	public List<Program> findAll();
	
	public ProgramDto findById(String programId) ;
	
	public Program save(ProgramForm form);
}
