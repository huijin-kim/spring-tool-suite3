package test.com.component.multi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestComponent {

	private static final Logger logger = LoggerFactory.getLogger(TestComponent.class);
	
	private String name;

	public TestComponent() {
		logger.info("TestComponent()....");
	}
	
	public int insert(String name) {
		logger.info("insert()....{}",name);
		return 99;
	}

}
