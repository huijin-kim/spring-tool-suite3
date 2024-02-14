package test.com.beanconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean3 {

	private static final Logger logger = LoggerFactory.getLogger(TestBean3.class);

	private String name;
	private int age;

	public TestBean3() {
		logger.info("TestBean3()...name:{}, age:{}", name, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestBean3 [name=" + name + ", age=" + age + "]";
	}

}
