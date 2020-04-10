package information.client.api.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// not use
@Controller
public class ExceptionController {
	// Convert a predefined exception to an HTTP Status code

	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation") // 409
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {
		// Nothing to do
	}
	// Specify the name of a specific view that will be used to display the error:
	
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED) // 409
	public ModelAndView unAuth(HttpServletRequest req, Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	} 

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError() {
		// Nothing to do. Returns the logical view name of an error page, passed to
		// the view-resolver(s) in usual way.
		// Note that the exception is _not_ available to this view (it is not added to
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below.
		 
		return "databaseError";
	}

	// Total control - setup a model and return the view name yourself. Or consider
	// subclassing ExceptionHandlerExceptionResolver (see below).

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

}
