package com.model;

import java.util.ArrayList;

public class UserList {
	private static UserList users;
	private ArrayList<User> userList;
	
	private UserList() {
		userList = DataLoader.loadUsers();
	}
	
	public static UserList getInstance() {
		if(users == null) {
			users = new UserList();
		}
		
		return users;
	}

    
	public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}	
		return false;
	}
	
	public User getUser(String email, String password) {
		for(User user : userList) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<User> getUsers() {
		return userList;
	}

	
	public boolean addUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
		if(haveUser(userName))return false;
		userList.add(new User(userName, firstName, lastName, email, password, points, badges, friends));
		return true;
	}
	
	public boolean saveUsers() {
		return DataWriter.saveUsers();
	}
}