package com.spring_arch.common.lib.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Aspect
public class PermissionAspect {

	@Resource(name = "internalResourceViewResolver")
	InternalResourceViewResolver viewResolver;
	
	@Pointcut("execution(public * com.spring_arch.board.controller.BoardController.load*(..))")
	private void beforeMvcPermission() {};

	@Before("beforeMvcPermission()")
	public void beforeAopTest(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before Intercepted!!!!!!!!!");
	}

	@After("beforeMvcPermission()")
	public void afterAopTest() throws Throwable {
		System.out.println("After Intercepted!!!!!!!!!");
	}
}
