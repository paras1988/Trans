package com.Sample2.controller;

import org.springframework.util.Assert;

public class TestSpringUtilities {
	int t = 23;

	public static void main(final String[] args) {
		final TestSpringUtilities t = new TestSpringUtilities();
		final TestSpringUtilities t2 = new TestSpringUtilities();
		if (t == t2) {

		}

		Assert.notNull(t);
	}

	@Override
	public boolean equals(final Object o) {
		System.out.println("in equal");
		return super.equals(o);
	}
}
