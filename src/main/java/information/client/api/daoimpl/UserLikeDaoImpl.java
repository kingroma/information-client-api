package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserLikeDao;
import information.client.api.domain.UserLike;

@Lazy
@Repository
public class UserLikeDaoImpl extends BaseDaoImpl<UserLike,String> implements UserLikeDao{

}
