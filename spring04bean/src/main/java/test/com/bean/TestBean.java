package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {

	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);

	
	private String name;
	private int age;
	
	public TestBean() {
		logger.info("TestBean()...name:{}, age:{}",name,age);
	}
	
	public TestBean(String name, int age) {
		logger.info("TestBean()...name:{}, age:{}",name,age);
		this.name = name;
		this.age = age;
	}




	public void test() {
		logger.info("test()....");
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
