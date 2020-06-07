package information.client.api.service;

import java.util.List;

import information.client.api.domain.User;
import information.client.api.domain.UserMatchHist;
import information.client.api.domain.UserRankHist;
import information.client.api.exception.LoginIdPwIncorrectException;
import information.client.api.form.UserForm;

public interface UserService{
	public List<User> listAll();
	
	public String login(UserForm form) throws Exception , LoginIdPwIncorrectException;
	
	public boolean authUserToken(String token) throws Exception;
	
	public boolean authUserToken(UserForm form) throws Exception ;
	
	public boolean saveUserRankHist(UserRankHist entity);
	
	public UserMatchHist getUserMatchHist(String userId , String matchId);
	
	public Long getMaxMatchTime(String userId); 
	
	public boolean saveUserMatchHist(UserMatchHist entity);
	
}
