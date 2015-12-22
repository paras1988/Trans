package com.Sample2.construction;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.Sample2.annotation.AttriAnnotation;
import com.Sample2.annotation.ModAnnotation;
import com.Sample2.model.Address;
import com.Sample2.model.Institute;

@Component
public abstract class AbstractConstructor implements ApplicationContextAware {

	private ApplicationContext context = null;

	public Map<String, Map<String, ?>> constructResources(final Map<String, Object> args) {
		constructResources("Temp", args);
		constructAdditionalResources(args);
		return null;
	}

	private void constructResources(final String string, final Map<String, Object> args) {
		System.out.println("Constructing resources....");

		final Class<?> clazz = Institute.class;
		Assert.isTrue(clazz.isAnnotationPresent(ModAnnotation.class));

		// Process @Attributes
		for (final Field field : clazz.getDeclaredFields()) {

			final String attributeId = field.getName();

			// if method is annotated with @Attribute
			if (field.isAnnotationPresent(AttriAnnotation.class)) {
				final AttriAnnotation attribute = field.getAnnotation(AttriAnnotation.class);
				context.getBean(attribute.constructor()).constructAdditionalResources(args);
			}
		}
	}

	private Institute setAndgetInstitute() {
		final Institute institute = new Institute();
		final Address add = new Address();

		add.setAddressId("23");
		add.setAddressLine1("3434");
		add.setAddressLine2("3434");
		add.setAddressLine3("3434");

		institute.setAddress(add);
		institute.setName("KBC");
		institute.setInstId("343");

		return institute;
	}

	protected abstract Map<String, Map<String, ?>> constructAdditionalResources(
			final Map<String, Object> args);

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
