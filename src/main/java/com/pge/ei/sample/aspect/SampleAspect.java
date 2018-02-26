package com.pge.ei.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

/*	@AfterThrowing("within(com.pge.ei.sample.service.SampleService)")
	public void logExceptions(JoinPoint joinPoint) {
		System.out.println("Exception thrown in Method=" + joinPoint.toString());
	}*/
	
	@AfterThrowing(
		    pointcut="execution(* com.pge.ei.sample.service.SampleService.sampleException(..))", 
		    throwing="excep")
		    public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
		        System.out.println("Inside CatchThrowException.afterThrowing() method...");
		        System.out.println("Running after throwing exception...");
		        System.out.println("Exception : " + excep);
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
