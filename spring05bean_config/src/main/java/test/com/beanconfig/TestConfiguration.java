package test.com.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
	
	@Bean
	public TestBean tb01(){
//		return new TestBean();
		return new TestBean("홍길동", 33);
	}
	
	@Bean
	public Person p01(){
//		return new Person();
		return new Person("서울", "02");
	}
	
	@Bean
	public Employee emp(){
//		return new Employee();
//		return new Employee("서울", 02);
		return new Employee(p01());
	}
	
	
	

}
