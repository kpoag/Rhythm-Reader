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
	
	public boolean addUser(String userName, String firstName, String lastName, String email,
    String password, int points, String classroom, Module assignedModules, Module completedModules,
    Module currentModule, Module recommendedModules, String deadlines, String grades, String badges,
    String progress, DifficultyLevel skillLevel, UserList friends, String teachingClasses) {
		if(haveUser(userName))return false;
		userList.add(new User(userName, firstName, lastName, email, password, points, 
		classroom, assignedModules, completedModules, currentModule, recommendedModules, deadlines,
		grades, badges, progress, skillLevel, friends, teachingClasses));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}