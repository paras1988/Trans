package com.Test.Annotation;

import java.lang.reflect.Method;

public class RunTest {
	public static void main(final String[] args) {
		final Class obj = TestExample.class;

		if (obj.isAnnotationPresent(TestAuthor.class)) {

			final TestAuthor tsA = (TestAuthor) obj.getAnnotation(TestAuthor.class);
			System.out.println("Name: " + tsA.authorName() + " Date: " + tsA.createDate());
			for (final Method method : obj.getDeclaredMethods()) {
				if (method.isAnnotationPresent(CustomTest.class)) {
					final CustomTest cst = method.getAnnotation(CustomTest.class);
					if (cst.enabled()) {
						try {
							method.invoke(obj.newInstance());
							System.out.println("Test Passed:: " + method.getName());

						} catch (final Throwable e) {
							System.out.println("Test Failed:: " + method.getName());
							e.printStackTrace();
						}
					} else {
						System.out.println("Test Ignored:: " + method.getName());
					}
				}
			}
		}
	}
}
