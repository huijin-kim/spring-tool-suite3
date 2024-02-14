package test.com.component.multi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	private String name;
	
	@Autowired
	TestDAO dao;

	public TestService() {
		logger.info("TestService()....");
	}
	
	public int insert(String name) {
		logger.info("insert()....{}",name);
		return dao.insert(name);
	}

}
