package org.benlin.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.benlin.moneytransfer.database.Database;
import org.benlin.moneytransfer.model.User;

public class UserService {
	
private Map<String, User> users =  Database.getUsers();
	
	public UserService() {
	}

	public List<User> getAllUsers(){
		return new ArrayList<User>(users.values());

	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	public User addUser(User user) {
		user.setUserId(users.size()+1);
		users.put(user.getUsername(), user);
		return user;
	}
	
	public User updateUser(User user) {
		if(user.getUsername().isEmpty()) {
			return null;
		}
		
		users.put(user.getUsername(), user);
		return user;
	}
	
	public User removeUser(String username) {
		return users.remove(username);
	}

}
