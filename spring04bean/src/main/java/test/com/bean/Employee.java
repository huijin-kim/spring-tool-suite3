package test.com.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {

	private static final Logger logger = LoggerFactory.getLogger(Employee.class);

	private Person p;

	public Employee(Person p) {
		logger.info("Employee()...{}", p);
		this.p = p;
	}

	@Override
	public String toString() {
		return "Employee [p=" + p + "]";
	}

}
