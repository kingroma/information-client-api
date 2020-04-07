package information.client.api.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.TokenDao;
import information.client.api.form.UserForm;
import information.client.api.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService{
	
	@Resource 
	TokenDao tokenDao ; 
}
