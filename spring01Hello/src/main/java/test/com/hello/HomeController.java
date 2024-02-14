package test.com.hello;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
	
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String test(Model model) {
		logger.info("Welcome test!");
		
		model.addAttribute("name", "kim");
		
		return "test";
	}
	
	@RequestMapping(value = "m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("Welcome m_insert...");
		
		
		return "member/insert";
	}
	
	@RequestMapping(value = "m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(String name,int age) {
		logger.info("Welcome m_insertOK...");
		
		logger.info(name);
		logger.info(String.valueOf(age));
		
		
		return "redirect:m_selectAll.do";
	}
	
	//1.m_selectAll.do
	@RequestMapping(value = "m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll() {
		logger.info("Welcome m_selectAll...");
		
		
		return "member/selectAll";
	}
	
	//2.m_selecOne.do
	@RequestMapping(value = "m_selectOne.do", method = RequestMethod.GET)
	public String m_selecOne(int num,String name) {
		logger.info("Welcome m_selecOne...");
		
		logger.info(""+num);
		logger.info(name);
		
		return "member/selectOne";
	}
	
	//3.m_update.do
	@RequestMapping(value = "m_update.do", method = RequestMethod.GET)
	public String m_update() {
		logger.info("Welcome m_update...");
		
		
		return "member/update";
	}
	
	//4.m_updateOK.do >> m_selectOne.do 리다이렉트
	@RequestMapping(value = "m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(int num,String name,int age) throws UnsupportedEncodingException {
		logger.info("Welcome m_updateOK...");
		
		logger.info(""+num);
		logger.info(name);
		logger.info(String.valueOf(age));
		
		//파라메터로 한글 전달하고자 할때는 인코딩 필수
		return "redirect:m_selectOne.do?num="+num +"&name="+URLEncoder.encode(name,"UTF-8");
	}
	
}
