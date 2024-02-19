package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestPointCutAspect {

	@Pointcut("execution(public * test..*DAO*.delete(..))")
	public void deletePointCut() {  //설정만을 위한 메소드. 
		log.info("deletePointCut()...."); //실행문이 수행되지 않는다. 
	}
	
	@Before("deletePointCut()")
	public void testBeforeAdvice(JoinPoint jp) {
		log.info("testBeforeAdvice()...");
	}
	
	@After("deletePointCut()")
	public void testAfterAdvice(JoinPoint jp) {
		log.info("testAfterAdvice()...");
	}
	
	//execution이외의 포인트 컷 설정방법(bean(빈id), within(타켓클래스))
//	@Pointcut("execution(public * test..*DAO*.*(..))")
//	@Pointcut("bean(dao)")
	@Pointcut("within(TestDAOimpl)")
	public void daoPointCut() {}
	
	@After("daoPointCut()")
	public void adoAfterAdvice(JoinPoint jp) {
		log.info("****************adoAfterAdvice()...");
	}
	
}