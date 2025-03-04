package com.model;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.UUID;

public class UserList {
    private static UserList users;

    private ArrayList<User> userList;
    private UUID userID;

    private UserList() {
        userList = Database.getUsers();
    }
    public static UserList getInstance() {
        if (users == null) {
            users = new UserList();
        }
        return users;
    }

    public boolean haveUser(String username) {
        return true;
    }

    public User getUser(String username) {
        if(!haveUser(username)) return null;

        return new User("Jane", "Doe", username,"jdoe@email.com", "xyz34");
    }
    public boolean deleteUser(String username, String password) {
        return true;
    }
    public boolean addUser(User user){
        return true;
    }

    public boolean save(){
        return true;

    }

}
=======

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
>>>>>>> origin/Jaylen-Branch
