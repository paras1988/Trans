package com.Sample2.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestValidators {

	@Autowired(required = true)
	private ValidatorNoProxy validatorNoProxy;

	@Autowired(required = true)
	private ValidationWithProxy validationWithProxy;

	public String processNoProxy(final String request) {
		final List<String> errorMessages = validatorNoProxy.validate(request);
		// printList(errorMessages);
		if (!errorMessages.isEmpty()) {
			return null;
		}
		return null;
	}

	public String processWithProxy(final String request) {
		final List<String> errorMessages = validationWithProxy.validate(request);
		// printList(errorMessages);
		if (!errorMessages.isEmpty()) {
			return null;
		}
		return null;
	}

	private void printList(final List<String> errorMessages) {
		for (final String s : errorMessages) {
			System.out.print(s);
		}
		System.out.println("=====================================");
	}
}
