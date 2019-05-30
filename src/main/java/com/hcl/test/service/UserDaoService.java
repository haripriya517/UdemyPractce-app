package com.hcl.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.test.dao.User;

@Component
public class UserDaoService {

	private static List<User> usersLists = new ArrayList<User>();
	private static int userscount = 3;

	static {
		usersLists.add(new User(1, "priya", new Date()));
		usersLists.add(new User(2, "priyahari", new Date()));
		usersLists.add(new User(3, "kumar", new Date()));
	}

	public List<User> findAll() {
		return usersLists;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userscount);
		}

		usersLists.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : usersLists) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = usersLists.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
