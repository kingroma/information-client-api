package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserWatchHistDao;
import information.client.api.domain.UserWatchHist;
import information.client.api.domain.UserWatchHistPK;

@Lazy
@Repository
public class UserWatchHistDaoImpl extends BaseDaoImpl<UserWatchHist,UserWatchHistPK> implements UserWatchHistDao{

}
