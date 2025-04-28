package com.model;

import java.util.ArrayList;

/**
 * Maintains a list of all users in the system.
 * This class is implemented as a singleton, ensuring that only one instance of the user list exists.
 * It provides methods to check for existing users, add new users, retrieve users, and persist the user list.
 */
public class UserList {
	private static UserList users;
	private ArrayList<User> userList;
	
	/**
     * Private constructor that initializes the user list by loading users from the data source.
     */
	private UserList() {
		userList = DataLoader.loadUsers();
	}
	
	/**
     *
     * @return the singleton UserList instance.
     */
	public static UserList getInstance() {
		if(users == null) {
			users = new UserList();
		}
		
		return users;
	}

    /**
     * Checks if a user with the specified username exists in the list.
     *
     * @param userName the username to search for.
     * @return true if a user with the given username exists; false otherwise.
     */
	public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}	
		return false;
	}
	
	/**
     * Retrieves a user from the list based on the provided email and password.
     *
     * @param email the email address of the user.
     * @param password the password of the user.
     * @return the corresponding User if found; null otherwise.
     */
	public User getUser(String email, String password) {
		for(User user : userList) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
     private User findUserByUsername(String username) {
          if (username == null || username.isEmpty()) {
              return null;
          }
          
          ArrayList<User> allUsers = UserList.getInstance().getUsers();
          for (User user : allUsers) {
              if (user.getUserName().equals(username)) {
                  return user;
              }
          }
          return null;
      }
	
	/**
     * Returns the list of all users.
     *
     * @return an ArrayList of User objects.
     */
	public ArrayList<User> getUsers() {
		return userList;
	}

	/**
     * Adds a new user to the list.
     * This method checks if a user with the same username already exists before adding the new user.
     *
     * @param user the User to be added.
     * @return true if the user was successfully added; false if the user already exists.
     */
	public boolean addUser(User user) {
        if(haveUser(user.getUserName())) return false;
        userList.add(user);
        return true;
    }

	/**
     * Creates and adds a new user to the list with the provided parameters.
     * This method checks if a user with the given username already exists before creating a new user.
     *
     * @param userName the username of the new user.
     * @param firstName the first name of the new user.
     * @param lastName the last name of the new user.
     * @param email the email address of the new user.
     * @param password the password for the new user.
     * @param points the initial points for the new user.
     * @param badges an ArrayList of badges for the new user.
     * @param friends an  ArrayList of friend IDs for the new user.
     * @return true if the new user was successfully created and added; false if the username already exists.
     */
	public boolean addUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
		if(haveUser(userName))return false;
		userList.add(new User(userName, firstName, lastName, email, password, points, badges, friends));
		return true;
	}
	
	/**
     * Persists the current list of users to the data store.
     *
     * @return true if the users were successfully saved; false otherwise.
     */
	public boolean saveUsers() {
		return DataWriter.saveUsers();
	}
}