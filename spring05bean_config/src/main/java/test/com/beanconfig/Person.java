package test.com.beanconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {

	private static final Logger logger = LoggerFactory.getLogger(Person.class);

	private String address;
	private String tel;

	public Person() {
		logger.info("Person()....address:{} , tel:{}",address,tel);
	}

	public Person(String address, String tel) {
		logger.info("Person()....address:{} , tel:{}",address,tel);
		this.address = address;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", tel=" + tel + "]";
	}

}
