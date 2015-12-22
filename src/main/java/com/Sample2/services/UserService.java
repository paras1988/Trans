package com.Sample2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Sample2.model.User;

@Component
public class UserService {

	final static List<User> list = new ArrayList<User>();

	static {
		initUsers();
	}

	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	public User createNewUser(final User user) {
		list.add(user);
		return user;
	}

	public User getById(final int id) {
		User u = null;
		for (final User user : list) {
			if (user.getId() == id) {
				u = user;
				break;
			}
		}
		if (u == null) {
			System.out.println("User Not Found");
		}
		return u;
	}

	public User update(final User user) {
		for (final User u : list) {
			if (user.getId() == u.getId()) {
				u.setAge(user.getAge());
				u.setName(user.getName());
				System.out.println("User Updated");
				break;
			}
		}
		return user;
	}

	public void remove(final int id) {
		list.remove(id - 1);
		System.out.println("User Removed");
	}

	private static void initUsers() {
		final User user1 = new User(1, "asd1", 21);
		final User user2 = new User(2, "asd2", 22);
		final User user3 = new User(3, "asd3", 23);
		final User user4 = new User(4, "asd4", 24);
		final User user5 = new User(5, "asd5", 25);

		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
	}

}
