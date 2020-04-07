package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserDao;
import information.client.api.domain.User;

@Lazy
@Repository
public class UserDaoImpl extends BaseDaoImpl<User,String> implements UserDao {

}
