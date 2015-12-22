package com.Sample2.services;

import java.util.ArrayList;
import java.util.List;

import com.Sample2.cache.ParryCache;

public class CustomerService {
	private String name;
	private String url;

	public void setName(final String name) {
		this.name = name;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	@ParryCache
	public List<String> printName() {
		System.out.println("Customer name : " + name);
		final List<String> abc = new ArrayList<String>();
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		return abc;

	}

	@ParryCache
	public List<String> printURL() {
		System.out.println("Customer website : " + url);

		final List<String> abc = new ArrayList<String>();
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		abc.add("a");
		return abc;

	}

	public void printThrowException() {
		throw new IllegalArgumentException();
	}

}