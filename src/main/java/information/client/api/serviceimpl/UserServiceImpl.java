package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.TokenDao;
import information.client.api.dao.UserDao;
import information.client.api.domain.User;
import information.client.api.form.UserForm;
import information.client.api.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Resource
	private UserDao userDao ; 
	
	@Resource
	private TokenDao tokenDao ;
	
	public String login(UserForm form) {
		String token = null ;
		String userId = form.getUserId();
		String userPw = form.getUserPw();
		
		User user = null ; 
		List<User> users = userDao.find(
				Filter.equal("userId", userId) ,
				Filter.equal("userPw", userPw) 
				);
		
		if ( users != null && users.size() > 0 ) {
			user = users.get(0);
		}
		
		
		return token ; 
	}
}
