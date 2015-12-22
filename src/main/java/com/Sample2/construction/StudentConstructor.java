package com.Sample2.construction;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StudentConstructor extends AbstractConstructor {

	@Override
	protected Map<String, Map<String, ?>> constructAdditionalResources(
			final Map<String, Object> args) {
		return null;
	}

}
