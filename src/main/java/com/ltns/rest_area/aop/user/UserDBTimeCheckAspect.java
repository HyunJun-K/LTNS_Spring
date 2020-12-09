package com.ltns.rest_area.aop.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserDBTimeCheckAspect {

	public Object aroundTimeCheckAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		long start = System.currentTimeMillis();
		Object proceed = null;
	
		try {
			proceed = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(proceedingJoinPoint.getSignature().getName() + " DB동작시간 체크 : " + (end - start) + "ms");
		return proceed;
	}
}
