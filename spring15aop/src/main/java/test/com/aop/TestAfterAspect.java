package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAfterAspect {
	
	@After("execution(public * test..*DAO*.selectAll(..))")
	public void selectAfterAdvice(JoinPoint jp) {
		log.info("selectAftereAdvice");
	}

}
