package com.datastreams.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class LogAop {
	
	//@Pointcut("execution(* com.datastreams.project.dao.BoardDAOImpl.*(..))")
	/*private void pointcutMethod(){
		
	}*/
	//@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureStr= joinPoint.getSignature().toShortString();
		System.out.println( signatureStr + "is start. AOP공통기능 시작");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr +"is finished.");
			System.out.println(signatureStr + "경과시간 : " + (et - st) +"AOP공통기능 종료");
		}
	}
	//@Before("execution(* com.datastreams.project.dao.BoardDAOImpl.*(..))")
	public void beforAdvice(){
		System.out.println("beforAdvice()");
	}
}
