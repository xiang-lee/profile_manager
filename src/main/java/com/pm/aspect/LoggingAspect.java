package com.pm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect{
	
	@Before("execution(* com.pm.core.service.UserService.findByName(String)) && args(name)")
	public void logBefore(JoinPoint joinPoint,String name) {
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("hijacked Name : " + name );
		System.out.println("******");
	}
	
	//Comment from Xiang, this logaround cause the user is null after execution, need to fix
//	@Around("execution(* com.pm.core.service.UserService.findByName(*))")
//	public void logaround(ProceedingJoinPoint joinpoint){
//		try{
//			System.out.println("logAround() before is running!");
//			joinpoint.proceed();
//			System.out.println("logAround() after is running!");
//		}
//		catch(Throwable t){
//			System.out.println("logAround() exception!" + t);
//		}
//	}
	
}