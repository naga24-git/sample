package com.pge.ei.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SampleAspect {

	@AfterThrowing("within(com.pge.ei.sample.service.SampleService)")
	public void logExceptions(JoinPoint joinPoint) {
		System.out.println("Exception thrown in Employee Method=" + joinPoint.toString());
	}

	@Around("execution(* com.pge.ei.sample.service.SampleService.sampleMethod())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before invoking sample method");
		long startTime = System.currentTimeMillis();
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("After invoking sample method. Time taken: " + timeTaken);
		return value;
	}
}