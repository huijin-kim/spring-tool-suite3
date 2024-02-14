package test.com.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean5 {

	private static final Logger logger = LoggerFactory.getLogger(TestBean5.class);

	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;

	public TestBean5() {
		logger.info("TestBean5()..");
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TestBean5 [list=" + list + ", set=" + set + ", map=" + map + "]";
	}

}
