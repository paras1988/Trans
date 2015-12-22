package com.Sample2.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class ValidatorNoProxy {

	private final List<String> errorMessages = new ArrayList<String>();

	public ValidatorNoProxy() {
		System.out.println("New Instance");
	}

	public List<String> validate(final String request) {
		errorMessages.add("Validation Failed");
		return errorMessages;
	}
}
