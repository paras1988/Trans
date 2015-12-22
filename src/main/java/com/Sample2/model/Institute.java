package com.Sample2.model;

import com.Sample2.annotation.AttriAnnotation;
import com.Sample2.annotation.ModAnnotation;
import com.Sample2.construction.AddConstructor;
import com.Sample2.construction.InstituteConstructor;
import com.Sample2.validation.AddreValidator;
import com.Sample2.validation.InstituteValidator;

@ModAnnotation(validator = InstituteValidator.class, constructor = InstituteConstructor.class)
public class Institute {

	String instId;

	@AttriAnnotation(validator = AddreValidator.class, constructor = AddConstructor.class)
	Address address;

	String name;

	public String getInstId() {
		return instId;
	}

	public void setInstId(final String instId) {
		this.instId = instId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
