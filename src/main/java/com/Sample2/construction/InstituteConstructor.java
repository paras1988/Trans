package com.Sample2.construction;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class InstituteConstructor extends AbstractConstructor {

	@Override
	protected Map<String, Map<String, ?>> constructAdditionalResources(
			final Map<String, Object> args) {
		System.out.println("InstituteConstructor: Inside additional InstituteConstructor");
		return null;
	}

}
