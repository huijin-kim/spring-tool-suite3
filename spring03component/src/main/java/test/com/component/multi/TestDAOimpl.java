package test.com.component.multi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOimpl implements TestDAO {

	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);
	
	public TestDAOimpl() {
		logger.info("TestDAOimpl()....");
	}
	
	@Override
	public int insert(String name) {
		logger.info("insert()....{}",name);
		return 0;
	}

}
