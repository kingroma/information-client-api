package information.client.api.daoimpl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.ProgramDao;
import information.client.api.domain.Program;

@Lazy
@Repository
public class ProgramDaoImpl extends BaseDaoImpl<Program,String> implements ProgramDao{
	public Program findById(String programId) {
		List<Program> programs = find(Filter.equal("programId", programId));
		
		return programs.isEmpty() ? null : programs.get(0);
	}
	
}
