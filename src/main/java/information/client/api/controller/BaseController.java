package information.client.api.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;


public class BaseController {
	@Resource(name = "messageSource")
	protected MessageSource messageSource;
	
	protected String getMessage(String key) {
		String message = null ; 
		if ( key != null && !key.isEmpty() ) {
			message = messageSource.getMessage(key, null, Locale.getDefault());
		}
		return message ; 
	}
}
