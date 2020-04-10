package information.client.api;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.domain.Test;
import information.client.api.responsedto.TestDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private TestService testService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test" )
	@ResponseBody
	public TotalDto<TestDto> test(HttpServletRequest request , HttpServletResponse response){
		TotalDto<TestDto> result = new TotalDto<TestDto>();
		
		List<Test> list = testService.listAll();
		if ( list != null && list.size() > 0 ) {
			result.setTotalCount(list.size());
			for ( Test t : list ) {
				TestDto dto = new TestDto();
				dto.setUuid(t.getUuid());
				dto.setText(t.getText());
				
				result.add(dto);
			}
		}
		
		return result ;
	}
	
}
