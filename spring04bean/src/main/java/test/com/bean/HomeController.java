package test.com.bean;

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestBean tb01;//xml bean id와 매칭
	
	@Autowired
	private TestBean tb02;//xml bean id와 매칭
	
	@Autowired
	private Person p01;
	
	@Autowired
	private Person p02;
	
	@Autowired
	private Employee emp01;
	
	@Autowired
	private TestBean3 tb03;
	
	@Autowired
	private TestBean4 tb04;

	@Autowired
	private TestBean5 tb05;
	
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.info(tb01.toString());
		tb01.test();
		
		logger.info(tb02.toString());
		tb02.test();
		
		
		logger.info(p01.toString());//[address=null, tel=null]
		logger.info(p02.toString());//[address=seoul, tel=02]
		logger.info(emp01.toString());//[p=Person [address=seoul, tel=02]]
		logger.info(tb03.toString());//TestBean3 [name=yangssem, age=44]
		logger.info(tb04.toString());//TestBean4 [person=Person [address=busan, tel=051]]
		logger.info(tb05.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
