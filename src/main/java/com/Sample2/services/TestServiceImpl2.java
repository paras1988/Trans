package com.Sample2.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl2 implements TestService, ApplicationContextAware {

	private static ApplicationContext context = null;

	@Override
	public void fun() {
		System.out.println("inside fun");
		final TestServiceImpl2 test = context.getBean(TestServiceImpl2.class);
		test.fun2();
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;

	}

	@Override
	public void fun2() {
		System.out.println("fun2");

	}

}
