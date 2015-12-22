package com.Sample2.model;

import org.springframework.stereotype.Component;

@Component
public class Address {

	String addressId;
	String addressLine1;
	String addressLine2;
	String addressLine3;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(final String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(final String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(final String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(final String addressLine3) {
		this.addressLine3 = addressLine3;
	}

}
