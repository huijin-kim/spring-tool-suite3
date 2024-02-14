package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//객체 생성 
public class TestBean2 {
	
	private static final Logger logger = LoggerFactory.getLogger(TestBean2.class);
	
	//전역변수 
	private Person p;
	
	//생성자 
	public TestBean2() {
		logger.info("TestBean2()... {}", p);
		this.p = p;
		
	}

	@Override
	public String toString() {
		return "TestBean2 [p=" + p + "]";
	}
	
	
	
	
	
	
}
