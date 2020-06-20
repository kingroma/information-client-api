package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.ContentProgramDao;
import information.client.api.domain.ContentProgram;
import information.client.api.domain.ContentProgramPK;

@Lazy
@Repository
public class ContentProgramDaoImpl extends BaseDaoImpl<ContentProgram,ContentProgramPK> implements ContentProgramDao {

}
