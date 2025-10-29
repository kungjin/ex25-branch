package com.ex25_branch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(*com.ex25_branch.service.*.*(..))")
			public void logBefore(JoinPoint jp) {
				log.info("##### 메서드 실행전: {} #####Before#####", jp.getSignature());
				
				
			}
	
	@AfterReturning(pointcut = "execution(*com.ex25_branch.service.*.*(..))")
		public void logAfter(JoinPoint jp, Object result) {
		log.info("#### 메서드\n 예외: {}, \n결과: {} #####AfterReturning#####", jp.getSignature());
	}
	
}
