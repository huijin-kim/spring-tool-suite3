package test.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class TestAroundAspect {

	@Around("execution(public * test..*DAO*.insert(..))")
	public Object insertAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("insertAroundAdvice()....start");
		
		Object obj = null;
		
		try {
			log.info("insert before...");
			obj = pjp.proceed();//call insert()
			log.info("insert after...");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("insertAroundAdvice()....end");
		return obj;
	}
	
	@Around("execution(public * test..*DAO*.update(..))")
	public Object updateAroundAdvice(ProceedingJoinPoint pjp) {
		log.info("updatetAroundAdvice()....start");
		
		Object obj = null;
		
		try {
			log.info("update before...");
			obj = pjp.proceed();//call update()
			log.info("update after...");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("updateAroundAdvice()....end");
		return obj;
	}
	
}