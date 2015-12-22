package com.Sample2.validation;

import org.springframework.stereotype.Component;

@Component
public class InstituteValidator extends AbstractValidator {

	@Override
	public boolean validateAddAttribute() {
		System.out.println("InstituteValidator: Validating ITEMS");
		return false;
	}

}
