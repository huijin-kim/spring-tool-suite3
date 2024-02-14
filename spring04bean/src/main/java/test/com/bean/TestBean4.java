package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean4 {

	private static final Logger logger = LoggerFactory.getLogger(TestBean4.class);

	private Person person;
	
	public TestBean4() {
		logger.info("TestBean4()..");
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "TestBean4 [person=" + person + "]";
	}

	

	

	
	
}
