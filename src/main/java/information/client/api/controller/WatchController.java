package information.client.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.responsedto.ResponseDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.responsedto.UserWatchHistDto;
import information.client.api.service.UserWatchHistService;

@Controller
@RequestMapping("/watch")
public class WatchController {
	private static final Logger logger = LoggerFactory.getLogger(WatchController.class);
	
	@Resource
	UserWatchHistService userWatchHistService;
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto<Boolean> watchStart(
			HttpServletRequest request , HttpServletResponse response , 
			@RequestParam(value = "userId") String userId , 
			@RequestParam(value = "programId") String programId ,
			@RequestParam(value = "productId") String productId
			){
		ResponseDto<Boolean> dto = new ResponseDto<Boolean>();
		
		Boolean result = false ;
		
		try {
			userWatchHistService.save(userId, programId, productId);
			
			result = true ; 
		} catch (Exception e) {
			logger.error("Watch Start ERROR message = {} " , e.getMessage() , e);
		}
		
		dto.setResult(result);
		return dto; 
	}
	
	@RequestMapping(value = "/hist/recent/program", method = RequestMethod.GET)
	@ResponseBody
	public TotalDto<UserWatchHistDto> watchHist(
			HttpServletRequest request , HttpServletResponse response , 
			@RequestParam(value = "userId" , required = false ) String userId 
			){
		TotalDto<UserWatchHistDto> result = new TotalDto<UserWatchHistDto>() ;
		
		if ( userId == null || userId.isEmpty() ) { 
			result.setResultCode(TotalDto.PARAM_ERROR);
			result.setErrorMessage("userId is empty");
			result.setTotalCount(null);
			return result ; 
		}else { userId = userId.trim(); }
		
		try {
			result = userWatchHistService.getUserWatchHistRecentProgram(userId);
		} catch (Exception e) {
			logger.error("UserWatch ERROR message = {} " , e.getMessage() , e );
		}
		
		return result ; 
	}
}
