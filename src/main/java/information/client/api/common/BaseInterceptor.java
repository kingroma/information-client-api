package information.client.api.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import information.client.api.controller.ProgramController;
import information.client.api.service.UserService;

public class BaseInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);
	
	private final String TOKEN_PARAMETER = "token";

	private final String[] PASS_URL = {
		"/user"	,
		"/ui"
	};
	
	@Autowired
	private UserService userService;
	
	private boolean passPreHandleUrl(String url) {
		boolean result = false ;
		
		for ( String u : PASS_URL ) {
			if ( url.startsWith(u) ) {
				result = true ;
				break;
			}
		}
		
		return result ; 
	}
	
	// controller�� ������ ���� ó���ϴ� ���ͼ���
	// ��ȯ�� false��� controller�� ��û�� ����
	// �Ű����� Object�� �ڵ鷯 ������ �ǹ��Ѵ�. ( RequestMapping , DefaultServletHandler )
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = true  ; 
		
		String servletPath = request.getServletPath();
		if ( passPreHandleUrl(servletPath) ) {
			return true ; 
		}
		
		String token = request.getParameter(TOKEN_PARAMETER);
		
		boolean authCheck = false ; 
		if ( token != null && !token.isEmpty() ) {
			authCheck = userService.authUserToken(token);
		}else {
			logger.info("Token is empty");
		}
		
		if ( authCheck == false ) {
			result = false ; 
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
//			ModelAndView mav = new ModelAndView("user/login");
//            mav.addObject("message", "�߰� ��Ʈ����Ʈ");
//
//            throw new ModelAndViewDefiningException(mav);
		}
		
		return result ;
	}
	
	// view���� ó���� ���� �Ŀ� ó����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	// controller�� handler�� ������ ó����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
}

