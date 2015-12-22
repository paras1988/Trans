package com.Sample2.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParryCacheAspect {

	@Autowired
	private ParryCacheMap parryCacheMap;

	@Around("@annotation(com.Sample2.cache.ParryCache)")
	private void doCache(final ProceedingJoinPoint joinPoint) {
		System.out.println("logAround() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
}
