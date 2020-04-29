package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserMatchHistDao;
import information.client.api.domain.UserMatchHist;
import information.client.api.domain.UserMatchHistPK;

@Lazy
@Repository
public class UserMatchHistDaoImpl extends BaseDaoImpl<UserMatchHist,UserMatchHistPK> implements UserMatchHistDao{

}
