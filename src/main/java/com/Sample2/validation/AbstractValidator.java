package com.Sample2.validation;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import com.Sample2.annotation.AttriAnnotation;
import com.Sample2.annotation.ModAnnotation;
import com.Sample2.model.Institute;

public abstract class AbstractValidator implements ApplicationContextAware {

	private ApplicationContext context = null;

	public boolean validateAttribute() {
		System.out.println("Constructing resources....");

		final Class<?> clazz = Institute.class;
		Assert.isTrue(clazz.isAnnotationPresent(ModAnnotation.class));

		// Process @Attributes
		for (final Field field : clazz.getDeclaredFields()) {

			final String attributeId = field.getName();

			// if method is annotated with @Attribute
			if (field.isAnnotationPresent(AttriAnnotation.class)) {
				final AttriAnnotation attribute = field.getAnnotation(AttriAnnotation.class);
				context.getBean(attribute.validator()).validateAddAttribute();
			}
		}
		return false;
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}

	public abstract boolean validateAddAttribute();

}
