package com.Sample2.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class HijackBeforeMethod implements MethodBeforeAdvice {
	@Override
	public void before(final Method method, final Object[] args, final Object target)
			throws Throwable {
		System.out.println("HijackBeforeMethod : Before method hijacked!");
	}
}