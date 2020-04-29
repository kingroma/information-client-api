package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserRankHistDao;
import information.client.api.domain.UserRankHist;
import information.client.api.domain.UserRankHistPK;

@Lazy
@Repository
public class UserRankHistDaoImpl extends BaseDaoImpl<UserRankHist,UserRankHistPK> implements UserRankHistDao{

}
