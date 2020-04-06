package information.client.api.dao;

import information.client.api.domain.Program;

public interface ProgramDao extends BaseDao<Program, String>{
	public Program findById(String programId) ;
}
