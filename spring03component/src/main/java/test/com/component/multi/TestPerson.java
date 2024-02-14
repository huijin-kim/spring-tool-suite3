package test.com.component.multi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestPerson {

	private static final Logger logger = LoggerFactory.getLogger(TestPerson.class);
	
	private String name;

	public TestPerson() {
		logger.info("TestPerson()....");
	}
	
	public int sleep(String name) {
		logger.info("sleep()....{}",name);
		return 99;
	}

}
