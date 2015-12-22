package com.Sample2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.Sample2.construction.AbstractConstructor;
import com.Sample2.construction.DefaultConstructor;
import com.Sample2.validation.AbstractValidator;
import com.Sample2.validation.DefaultValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModAnnotation {

	boolean isRequired() default false;

	Class<? extends AbstractValidator> validator() default DefaultValidator.class;

	Class<? extends AbstractConstructor> constructor() default DefaultConstructor.class;
}
