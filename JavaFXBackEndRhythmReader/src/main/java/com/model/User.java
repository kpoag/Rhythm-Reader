package com.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * Represents a user in the system.
 * This class provides common attributes and behaviors for all types of users,
 * including username, name, email, password, points, badges, and friends. It also
 * includes static factory methods for creating default accounts and accounts by type.
 */

public class User {
	private UUID id;
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
    protected int points;
    protected ArrayList<String> badges;
    protected ArrayList<String> friends;

	/**
     * Constructs a new User with a randomly generated UUID and the specified parameters.
     *
     * @param userName the username of the user.
     * @param firstName the first name of the user.
     * @param lastName the last name of the user.
     * @param email the email address of the user.
     * @param password the user's password.
     * @param points the initial points of the user.
     * @param badges an  ArrayList of badges earned by the user.
     * @param friends an ArrayList of friend IDs associated with the user.
     */
	public User(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
		this.id = UUID.randomUUID();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
        this.email= email;
        this.password= password;
        this.points= points;
        this.badges= badges;
        this.friends= friends;
	}

	/**
     * Constructs a new User with the specified UUID and parameters.
     *
     * @param id the UUID of the user.
     * @param userName the username of the user.
     * @param firstName the first name of the user.
     * @param lastName the last name of the user.
     * @param email the email address of the user.
     * @param password the user's password.
     * @param points the initial points of the user.
     * @param badges an  ArrayList of badges earned by the user.
     * @param friends an  ArrayList of friend IDs associated with the user.
     */
	public User(UUID id, String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
        this.email= email;
        this.password= password;
        this.points= points;
        this.badges= badges;
        this.friends= friends;
	}

	/**
     * Creates a default user account after validating that the username and email are unique
     * and that the email format is valid.
     *
     * @param firstName the first name of the user.
     * @param lastName the last name of the user.
     * @param userName the desired username.
     * @param email the email address of the user.
     * @param password the user's password.
     * @return a new  User instance if successful; null otherwise.
     */
	public static User createDefaultAccount(String firstName, String lastName, String userName, String email, String password) {

		if (UserList.getInstance().haveUser(userName)) {
			return null;
		}
		if (User.isEmailTaken(email)) {
			System.out.println("Email is already registered. Please use a different email.");
			return null;  
		}
		if (!User.isValidEmail(email)) {
			System.out.println("Invalid email format. Please enter a valid email address.");
			return null;  
		}
		int points = 0;
        ArrayList<String> badges = new ArrayList<>();
        badges.add("Beginner");
        ArrayList<String> friends = new ArrayList<>();

		User newUser = new User(userName, firstName, lastName, email, password, points, badges, friends);
		boolean success = UserList.getInstance().addUser(newUser);

		if (success) {
			return newUser;
		}
		return null;

	}

	/**
     * Creates an account of a specified type by prompting the user for input.
     *
     * @param userName the desired username.
     * @param firstName the first name of the user.
     * @param lastName the last name of the user.
     * @param email the email address of the user.
     * @param password the user's password.
     * @param scanner a scanner instance to read user input.
     * @return a new User instance of the selected type if successful; null otherwise.
     */
	public static User createAccountByType(String userName, String firstName, String lastName, String email, String password, Scanner scanner) {
        System.out.println("What type of account would you like to create?");
        System.out.println("1. Regular");
        System.out.println("2. Student");
        System.out.println("3. Teacher");
        System.out.print("Enter your choice (1-3): ");

		String input = scanner.nextLine().trim();
		int accountType;

		try {
            accountType = Integer.parseInt(input);
            
            if (accountType < 1 || accountType > 3) {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                return null;
            }

			User newUser = null;

        	if (accountType == 1) {
				newUser = User.createDefaultAccount(userName, firstName, lastName, email, password);
			} else if (accountType == 2) {
				newUser = StudentUser.createStudentUser(userName, firstName, lastName, email, password);
			} else if (accountType == 3) {
				newUser = TeacherUser.createTeacherAccount(userName, firstName, lastName, email, password);
			}

			if (newUser != null) {
				System.out.println("Account created successfully!");
			} else {
				System.out.println("Failed to create account. User may already exist.");
			}
			return newUser;
		} catch (NumberFormatException  e) {
			System.out.println("Invalid input. Please enter a number between 1 and 3.");
            return null;
		}
	}
	
	/**
     * Returns the unique identifier of the user.
     *
     * @return the UUID of the user.
     */
	public UUID getId() {
		return id;
	}
	
	 /**
     * Returns the username of the user.
     *
     * @return the username.
     */
	public String getUserName() {
		return userName;
	}

	/**
     * Sets the username of the user.
     *
     * @param userName the new username.
     * @return true if the username was successfully set; false if the provided username is null.
     */
    public boolean setUserName(String userName)
    {
        if (userName == null ) return false;
        this.userName = userName;
        return true; 
    }
	
	/**
     * Returns the first name of the user.
     *
     * @return the first name.
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Sets the first name of the user.
     *
     * @param firstName the new first name.
     * @return true if the first name was successfully set; false if the provided first name is null.
     */
	public boolean setFirstName(String firstName) {
		if (firstName == null ) return false;
        this.firstName = firstName;
        return true; 
	}
	
	/**
     * Returns the last name of the user.
     *
     * @return the last name.
     */
	public String getLastName() {
		return lastName;
	}
	
	/**
     * Sets the last name of the user.
     *
     * @param lastName the new last name.
     * @return true if the last name was successfully set; false if the provided last name is null
     */
	public boolean setLastName(String lastName) {
		if (lastName == null ) return false;
        this.lastName = lastName;
        return true; 
	}

	/**
     * Returns the email address of the user.
     *
     * @return the email address.
     */
    public String getEmail() {
		return email;
	}
	
	/**
     * Sets the email address of the user.
     *
     * @param email the new email address.
     * @return true if the email was successfully set; false if the provided email is null.
     */
	public boolean setEmail(String email) {
		if (email == null ) return false;
        this.email = email;
        return true;  
	}

	/**
     * Returns the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
		return password;
	}
	
	/**
     * Sets the password of the user.
     *
     * @param password the new password.
     * @return true if the password was successfully set; false if the provided password is null.
     */
	public boolean setPassword(String password) {
		if (password == null ) return false;
        this.password = password;
        return true;  
	}

	/**
     * Returns the points of the user.
     *
     * @return the points.
     */
    public int getPoints() {
		return points;
	}
	
	/**
     * Sets the points of the user.
     *
     * @param points the new points value.
     * @return true if the points were successfully set; false if the provided points value is negative.
     */
	public boolean setPoints(int points) {
		if (points < 0 ) return false;
        this.points = points;
        return true;  
	}
    
	/**
     * Returns the list of badges earned by the user.
     *
     * @return an ArrayList of badges.
     */
    public ArrayList<String> getBadges() {
		return badges;
	}
	
	/**
     * Sets the list of badges for the user.
     *
     * @param badges an  ArrayList of badges.
     * @return true if the badges were successfully set; false if the provided list is null
     */
	public boolean setBadges(ArrayList<String> badges) {
		if (badges == null ) return false;
        this.badges = badges;
        return true;  
	}

	/**
     * Returns a list of friend usernames based on the provided user map.
     *
     * @param userMap a Map of user IDs to User objects.
     * @return an  ArrayList of friend usernames.
     */
    public ArrayList<String> getFriendNames(Map<String, User> userMap) {
		ArrayList<String> friendNames = new ArrayList<>();
		for (String friendId : friends) {
			User friend = userMap.get(friendId);
		if (friend != null) {
            friendNames.add(friend.getUserName()); 
        } else {
            friendNames.add("Unknown (" + friendId + ")");
        }
    }
    return friendNames;
	}

	 /**
     * Checks if the provided email is already taken by any user.
     *
     * @param email the email address to check.
     * @return  true if the email is taken; false otherwise.
     */
	public static boolean isEmailTaken(String email) {
		for (User user : UserList.getInstance().getUsers()) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Validates the provided email address using a regular expression.
     *
     * @param email the email address to validate.
     * @return true if the email address is valid; false otherwise.
     */
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    	return email.matches(emailRegex);
	}
	
    /**
     * Sets the list of friend IDs for the user.
     *
     * @param friends an ArrayList of friend IDs.
     * @return  true if the friends list was successfully set; false if the provided list is null.
     */
	public boolean setFriends(ArrayList<String> friends) {
		if (friends == null ) return false;
        this.friends = friends;
        return true;  
	}

	/**
	 * Returns a string representation of the user, which is the username.
	 * TO:DO: Add more details to the string representation if needed.
	 * 
	 * @return the username.
	 */
	public String toString() {
		return userName;
	}

	/**
	 * Determines whether current user is a Teacher
	 * @return boolean of User being a Teacher
	 */
	public boolean isTeacher() {
		return false;
	}

	/**
	 * Determines whether current user is a Student
	 * @return boolean of User being a student
	 */
	public boolean isStudent() {
		return false;
	}

	
}