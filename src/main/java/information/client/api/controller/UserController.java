package information.client.api.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.dto.ResponseDto;
import information.client.api.form.UserForm;
import information.client.api.service.TokenService;
import information.client.api.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService ; 
	
	@Resource
	private TokenService tokenService ; 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto<String> login(
			HttpServletRequest request , HttpServletResponse response , 
			@ModelAttribute UserForm form 
			){
		ResponseDto<String> responseDto = new ResponseDto<String>(); 
		
		String token = userService.login(form);
		if ( token != null && !token.isEmpty() ) {
			responseDto.setData(token);
		}else { 
			responseDto.setResultCode(ResponseDto.ERROR_CODE);
			responseDto.setResultMessage(getMessage("base.controller.exception.message"));
		}
		
		
		return responseDto ; 
	}
}
