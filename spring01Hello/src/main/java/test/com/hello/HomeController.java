package test.com.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String test( Model model) {
		logger.info("Welcome test!");
		
		
		model.addAttribute("name", "kim" );
		
		return "test";
	}
	
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("Welcome m_insert!");
		
		
		return "member/insert";
	}
	
	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.GET)
	public String m_insertOK(String name, int age) {
		logger.info("Welcome m_insertOK!");
		
//		System.out.println(request.getParameter("name"));
		logger.info(name);
		logger.info(String.valueOf(age));
		
		return "redirect:test.do";
	}
	
}
