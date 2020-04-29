package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.CodeDao;
import information.client.api.domain.Code;

@Lazy
@Repository
public class CodeDaoImpl extends BaseDaoImpl<Code,String> implements CodeDao{

}
