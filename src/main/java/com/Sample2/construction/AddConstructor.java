package com.Sample2.construction;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.Sample2.cache.ParryCache;

@Component
public class AddConstructor extends AbstractConstructor {

	@Override
	@ParryCache
	protected Map<String, Map<String, ?>> constructAdditionalResources(
			final Map<String, Object> args) {
		System.out.println("AddConstructor: Inside additional AddConstructor");
		return null;
	}

}
