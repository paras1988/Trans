package com.Sample2.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Sample2.validation.TestValidators;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestProcessorTest {

	@Autowired
	private TestValidators testValidators;

	@Test
	public void testProcessNO() {
		for (int i = 0; i < 10; i++) {
			final String response = testValidators.processNoProxy(new String("ANC"));
			assertNull(response);
		}
	}

	@Test
	public void testProcessYES() {
		for (int i = 0; i < 10; i++) {
			final String response = testValidators.processWithProxy(new String("ABC"));
			assertNull(response);
		}
	}
}
