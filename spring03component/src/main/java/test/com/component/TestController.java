package test.com.component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.component.multi.TestPerson;
import test.com.component.multi.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	//DI
	@Autowired
	TestService service;
	
	@Autowired
	TestPerson person;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		
		logger.info("service:{}", service);
		
		int result = service.insert("kim");
		logger.info("result:{}", result);

		
		logger.info("result:{}", person.sleep("yang"));
		
		return "home";
	}

}
