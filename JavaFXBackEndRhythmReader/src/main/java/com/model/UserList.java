package com.model;

import java.util.ArrayList;

public class UserList {
	private static UserList users;
	private ArrayList<User> userList;
	
	private UserList() {
		userList = DataLoader.getUsers();
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
	
	public User getUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<User> getUsers() {
		return userList;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, int age, String phoneNumber) {
		if(haveUser(userName))return false;
		userList.add(new User(userName, firstName, lastName, age, phoneNumber));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}
