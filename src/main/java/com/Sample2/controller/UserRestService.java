package com.Sample2.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Sample2.model.User;
import com.Sample2.services.UserService;

@Controller
@RequestMapping("/users")
public class UserRestService {

	private final UserService userService;

	@Autowired
	public UserRestService(final UserService userService) {
		this.userService = userService;
	}

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsersInJSON() {
		return userService.getAllUsers();
	}

	/*
	 * @GET
	 * 
	 * @Path("{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable final int id) {
		return new ResponseEntity<User>(userService.getById(id), HttpStatus.OK);

	}

	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(final User user) {
		return new ResponseEntity<User>(userService.createNewUser(user), HttpStatus.OK);
	}

	/*
	 * @PUT
	 * 
	 * @Path("{id}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(final User user) {
		return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
	}

	/*
	 * @DELETE
	 * 
	 * @Path("{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable final int id) {
		userService.remove(id);
	}
}
