package information.client.api.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.TokenDao;
import information.client.api.dao.UserDao;
import information.client.api.form.UserForm;
import information.client.api.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Resource
	private UserDao userDao ; 
	
	@Resource
	private TokenDao tokenDao ;
	
	public String login(UserForm form) {
		return null ; 
	}
}
