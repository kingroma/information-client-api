package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import information.client.api.exception.LoginIdPwIncorrectException;
import information.client.api.form.UserForm;
import information.client.api.responsedto.ResponseDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.responsedto.UserWatchHistDto;
import information.client.api.service.TokenService;
import information.client.api.service.UserService;
import information.client.api.service.UserWatchHistService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService ; 
	
	@Resource
	private TokenService tokenService ; 
	
	@Resource
	private UserWatchHistService userWatchHistService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto<String> login(
			HttpServletRequest request , HttpServletResponse response , 
			@ModelAttribute UserForm form 
			){
		logger.info("Login " + form );
		ResponseDto<String> responseDto = new ResponseDto<String>(); 
		
		// parameter validation
		if ( form.getUserId() == null || form.getUserId().isEmpty() ) {
			responseDto.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			responseDto.setResultMessage("userId " + getMessage("base.controller.param.empty.message"));
			return responseDto ;
		}else { form.setUserId(form.getUserId().trim());}
		
		if ( form.getUserPw() == null || form.getUserPw().isEmpty() ) {
			responseDto.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			responseDto.setResultMessage("userPw " + getMessage("base.controller.param.empty.message"));
			return responseDto ;
		}else { form.setUserPw(form.getUserPw().trim());}
		

		try {
			String token = userService.login(form);
			if ( token != null && !token.isEmpty() ) {
				responseDto.setResult(token);
			}else { 
				responseDto.setResultCode(ResponseDto.ERROR_CODE);
				responseDto.setResultMessage(getMessage("base.controller.exception.message"));
			}
		} 
		// login ID PW Incorrect 
		catch(LoginIdPwIncorrectException e) {
			logger.error("Login ID PW Incorrect Message = {}" , e.getMessage());
			responseDto.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			responseDto.setResultMessage("user id / pw " + getMessage("base.controller.param.not.valid.message"));
			return responseDto ;
		} catch (Exception e) {
			logger.error("Login Fail Error Message = {}" , e.getMessage() , e);
			responseDto.setResultCode(ResponseDto.ERROR_CODE);
			responseDto.setResultMessage(getMessage("base.controller.exception.message"));
			return responseDto ;
		}
		
		return responseDto ; 
	}
	
	@RequestMapping(value = "/authToken", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto<Boolean> authToken(
			HttpServletRequest request , HttpServletResponse response , 
			@ModelAttribute UserForm form 
			){
		logger.info("authToken " + form );
		ResponseDto<Boolean> responseDto = new ResponseDto<Boolean>(); 
		boolean result = false ; 
		// parameter validation
		if ( form.getToken() == null || form.getToken().isEmpty() ) {
			responseDto.setResultCode(ResponseDto.PARAMETER_ERROR_CODE);
			responseDto.setResultMessage("token " + getMessage("base.controller.param.empty.message"));
			return responseDto ;
		}else { form.setToken(form.getToken().trim());}
		
		try {
			result = userService.authUserToken(form);
			responseDto.setResult(result);
		} 
		catch (Exception e) {
			logger.error("Auth Token Fail Error Message = {}" , e.getMessage() , e);
			responseDto.setResultCode(ResponseDto.ERROR_CODE);
			responseDto.setResultMessage(getMessage("base.controller.exception.message"));
			return responseDto ;
		}
		
		return responseDto ; 
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
}
