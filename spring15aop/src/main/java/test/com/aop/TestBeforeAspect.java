package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestBeforeAspect {
	
	@Before("execution(public * test..*DAO*.selectAll(..))")
	public void selectBeforeAdvice(JoinPoint jp) {
		log.info("selectBeforeAdvice");
	}

}
