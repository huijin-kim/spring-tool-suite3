package test.com.beanconfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration2 {
	
	@Bean
	public TestBean3 tb03() {
//		return new TestBean3();
		
		TestBean3 tb = new TestBean3();
		tb.setName("lee");
		tb.setAge(22);
		
		return tb;
	}
	
	//TestBean4 빈으로 등록하고 컨트롤러에서 DI 및 출력
	@Bean
	public TestBean4 tb04() {
//		return new TestBean4();
		TestBean4 tb = new TestBean4();
		tb.setPerson(new Person("jeju", "064"));
		
		return tb;
	}
	
	
	@Bean
	public TestBean5 tb05() {
//		return new TestBean4();
		TestBean5 tb = new TestBean5();
		List<String> list = new ArrayList<String>();
		list.add("kim1");
		list.add("kim2");
		list.add("kim3");
		list.add("kim4");
		tb.setList(list);
		
		Set<String> set = new HashSet<String>();
		set.add("kim1");
		set.add("kim2");
		set.add("kim3");
		tb.setSet(set);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", "11");
		map.put("num", "lee");
		map.put("num", "2");
		
		tb.setMap(map);
		
		return tb;
	}

}
