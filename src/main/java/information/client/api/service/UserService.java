package information.client.api.service;

import information.client.api.exception.LoginIdPwIncorrectException;
import information.client.api.form.UserForm;

public interface UserService{
	public String login(UserForm form) throws Exception , LoginIdPwIncorrectException;
	
	public boolean authUserToken(String token) throws Exception;
	
	public boolean authUserToken(UserForm form) throws Exception ; 
}
