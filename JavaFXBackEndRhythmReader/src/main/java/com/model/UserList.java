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

    /**
     * took some stuff out this method just so it could compile. code in Portias code
     * @param userName
     * @return
     */
	public boolean haveUser(String userName) {
		
		return false;
	}
	/**
     * took some stuff out this method just so it could compile. code in Portias code
     * @param userName
     * @return
     */
	public User getUser(String userName) {
		
		return null;
	}
	
	public ArrayList<User> getUsers() {
		return userList;
	}
	/**
     * took some stuff out this method just so it could compile. code in Portias code
     * @param userName
     * @param firstName
     * @param lastName
     * @param age
     * @param phoneNumber
     * @return
     */
	public boolean addUser(String userName, String firstName, String lastName, int age, String phoneNumber) {
		if(haveUser(userName))return false;

		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}