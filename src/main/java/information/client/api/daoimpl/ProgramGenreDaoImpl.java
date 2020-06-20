package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.ProgramGenreDao;
import information.client.api.domain.ProgramGenre;
import information.client.api.domain.ProgramGenrePK;

@Lazy
@Repository
public class ProgramGenreDaoImpl extends BaseDaoImpl<ProgramGenre,ProgramGenrePK> implements ProgramGenreDao{
	
}
