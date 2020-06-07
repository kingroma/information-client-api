package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.UserMusicBoxDao;
import information.client.api.domain.UserMusicBox;

@Lazy
@Repository
public class UserMusicBoxDaoImpl extends BaseDaoImpl<UserMusicBox,String> implements UserMusicBoxDao {
	
}
