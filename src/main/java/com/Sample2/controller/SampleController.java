package com.Sample2.controller;

import static org.junit.Assert.assertNull;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Sample2.construction.InstituteConstructor;
import com.Sample2.enumEx.TestCompile;
import com.Sample2.model.Address;
import com.Sample2.services.CustomerService;
import com.Sample2.services.TestServiceImpl;
import com.Sample2.services.TestServiceImpl2;
import com.Sample2.validation.InstituteValidator;
import com.Sample2.validation.TestValidators;

@Controller
@RequestMapping("/sample")
public class SampleController implements ApplicationContextAware {

	@Autowired
	ApplicationContext context;

	@Autowired
	TestServiceImpl testServiceImpl;

	@Autowired
	TestServiceImpl2 testServiceImpl2;

	@Autowired
	private TestValidators testValidators;

	@Autowired
	private InstituteConstructor instituteConstructor;

	@Autowired
	private InstituteValidator validator;

	@Autowired
	private CustomerService cust;

	@Autowired
	private Address address;

	@RequestMapping(value = "/test/aop", method = RequestMethod.GET)
	void fun() {
		System.out.println("model initial");
		// final CustomerService cust = (CustomerService) context.getBean("customerService");

		// cust.printName();
		cust.printURL();

		try {
			cust.printThrowException();
		} catch (final Exception e) {
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	void fun2(@PathVariable final String id) {
		System.out.println(id);
		testServiceImpl.fun();
		testServiceImpl2.fun();
	}

	@RequestMapping(value = "/{id}/test/{id2}", method = RequestMethod.GET)
	void fun3(@PathVariable final String id, @PathVariable final String id2) {
		System.out.println(id + "::" + id2);
	}

	@Override
	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@RequestMapping(value = "/testValidator", method = RequestMethod.GET)
	void testValidator() {
		for (int i = 0; i < 10; i++) {
			final String response = testValidators.processNoProxy(new String("ANC"));
			assertNull(response);
		}
		System.out.println("===============================");
		for (int i = 0; i < 10; i++) {
			final String response = testValidators.processWithProxy(new String("ABC"));
			assertNull(response);
		}
	}

	private Map<?, ?> loadAndValidateModelElements(final Map<String, Object> args,
			final String... modelSection) {

		// retrieve resources
		Map<String, Map<String, ?>> resources = null;
		if (validator.validateAttribute()) { // This runs on submit where we validate...

		}
		try {
			resources = instituteConstructor.constructResources(args);
		} catch (final Exception e) {
			System.out.println(e);
		}
		return resources;
	}

	@RequestMapping(value = "/main_model", method = RequestMethod.POST)
	public Map<?, ?> getMainModel(final Map<String, Object> arguments) {
		return loadAndValidateModelElements(arguments, "Main");

	}

	@RequestMapping(value = "/enum/compile", method = RequestMethod.GET)
	void enumCompile() {
		System.out.println(TestCompile.values());
	}

	@RequestMapping(value = "/checkResponse", method = RequestMethod.GET)
	ResponseEntity<Address> checkResponse() {

		address = new Address();
		address.setAddressId("dfdf");
		address.setAddressLine1("adf");
		address.setAddressLine2("adf");
		address.setAddressLine3("adf");

		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@RequestMapping(value = { "/angular/angularIndex2" }, method = RequestMethod.GET)
	public ModelAndView angularIndex() {

		final ModelAndView model = new ModelAndView();
		model.setViewName("angularIndex");
		return model;

	}

}
