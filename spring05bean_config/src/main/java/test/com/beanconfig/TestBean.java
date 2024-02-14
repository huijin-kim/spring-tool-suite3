package test.com.beanconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//객체 생성 
public class TestBean {
	
	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);
	
	//전역변수 
	private String name;
	private int age;
	
	//생성자 
	public TestBean() {
		logger.info("TestBean() .. name:{}, age:{}", name, age);
		
	}
	
	public void test() {
		logger.info("test()...");
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", age=" + age + "]";
	}

	public TestBean(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	
}
