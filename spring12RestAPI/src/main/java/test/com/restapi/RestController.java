package test.com.restapi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class RestController {
	
	
	//html : "text/html; charset=UTF-8"
	//text : "text/plain; charset=UTF-8"
	//json : "text/json; charset=UTF-8"
	//xml :"text/xml; charset=UTF-8"
	@ResponseBody
	@RequestMapping(value = "/json_test.do", 
		method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String json_test(Locale locale, Model model) {
		log.info("Welcome json_test! ");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// {"today" : "+formattedDate+"}
		return "{\"today\" : \""+formattedDate+"\"} ";
//		return formattedDate;
	}
	
	//리턴 타입이 객체일 경우 produces = "text/html; charset=UTF-8" 처리시 오류가 난다. 
	@ResponseBody
	@RequestMapping(value = "/json_test2.do", 
		method = RequestMethod.GET)
	public Map<String, String> json_test2(Locale locale) {
		log.info("Welcome json_test! ");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("today", formattedDate);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_test3.do", method = RequestMethod.GET)
	public Map<String, TestVO> json_test3() {
		log.info("Welcome json_test3! ");
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		
		Map<String, TestVO> map = new HashMap<String, TestVO>();
		map.put("vo",vo);
		
		return map;
	}
	
	//selectOne
	@ResponseBody
	@RequestMapping(value = "/json_vo.do", method = RequestMethod.GET)
	public TestVO json_vo() {
		log.info("Welcome json_vo! ");
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		
		
		return vo;
	}
	
	//selectAll
	@ResponseBody
	@RequestMapping(value = "/json_list.do", method = RequestMethod.GET)
	public List<TestVO> json_list() {
		log.info("Welcome json_list! ");
		
		List<TestVO> vos = new ArrayList<TestVO>();
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);

		vos.add(vo);
		vos.add(vo);
		vos.add(vo);
		
		
		return vos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_test4.do", method = RequestMethod.GET)
	public Map<String, List<TestVO>> json_test4() {
		log.info("Welcome json_test4! ");
		List<TestVO> vos = new ArrayList<TestVO>();
		
		TestVO vo = new TestVO();
		vo.setName("kim");
		vo.setAge(33);
		vos.add(vo);
		vos.add(vo);
		
		Map<String, List<TestVO>> map = new HashMap<String, List<TestVO>>();
		map.put("vos",vos);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_idCheck.do", 
		method = RequestMethod.GET)
	public Map<String, String> json_idCheck(String id) {
		log.info("Welcome json_idCheck! ");
		
		log.info(id);
		
		
		Map<String, String> map = new HashMap<String, String>();
		if(id.equals("damin")) {
			map.put("result", "Not OK");
		}
		map.put("result", "OK");
				
		return map;
	}
}
