package information.client.api.serviceimpl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.UserDao;
import information.client.api.dao.UserTokenDao;
import information.client.api.domain.User;
import information.client.api.domain.UserToken;
import information.client.api.exception.LoginIdPwIncorrectException;
import information.client.api.form.UserForm;
import information.client.api.service.UserService;
import information.client.api.util.DomainUtil;

@Service
public class UserServiceImpl  implements UserService{

	@Resource
	private UserDao userDao ; 
	
	@Resource
	private UserTokenDao userTokenDao ;

	@Override
	@Transactional
	public String login(UserForm form) throws Exception , LoginIdPwIncorrectException{
		String token = null ;

		String userId = form.getUserId();
		String userPw = form.getUserPw();
		
		List<User> users = userDao.find(
				Filter.equal("userId", userId) ,
				Filter.equal("userPw", userPw) 
				);
		
		if ( users != null && users.size() > 0 ) {
			List<UserToken> userTokens = userTokenDao.find(Filter.equal("userId", userId));
			UserToken userToken = null ; 
			
			if ( userTokens != null && userTokens.size() > 0 ) {
				userToken = userTokens.get(0);
				token = userToken.getToken();
			} else { 
				token = DomainUtil.getUUID(20);
				
				userToken = new UserToken();
				Timestamp now = DomainUtil.nowTimestamp();
				userToken.setUserId(userId);
				userToken.setToken(token);
				userToken.setRegistDate(now);
				userToken.setUpdateDate(now);
				userTokenDao.save(userToken);
			}
		} else { 
			throw new LoginIdPwIncorrectException("Login Fail userId = " + userId + " userPw = " + userPw );
		}
		
		return token ; 
	}
	
	public boolean authUserToken(String token) throws Exception{
		boolean result = false ; 
		
		UserToken userToken = userTokenDao.find(token);
			
		if ( userToken != null ) {
			result = true ;
		}
		
		return result ; 
	}
	
	public boolean authUserToken(UserForm form) throws Exception{
		boolean result = false ; 
		
		String token = form.getToken() ;
		
		UserToken userToken = userTokenDao.find(token);
			
		if ( userToken != null ) {
			result = true ;
		}
		
		return result ; 
	}
}
