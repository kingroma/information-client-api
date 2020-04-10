package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserTokenDao;
import information.client.api.domain.UserToken;

@Lazy
@Repository
public class UserTokenDaoImpl extends BaseDaoImpl<UserToken,String> implements UserTokenDao{

}
