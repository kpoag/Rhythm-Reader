package com.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

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


	
	public UUID getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

    public boolean setUserName(String userName)
    {
        if (userName == null ) return false;
        this.userName = userName;
        return true; 
    }
	
	public String getFirstName() {
		return firstName;
	}
	
	public boolean setFirstName(String firstName) {
		if (firstName == null ) return false;
        this.firstName = firstName;
        return true; 
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean setLastName(String lastName) {
		if (lastName == null ) return false;
        this.lastName = lastName;
        return true; 
	}
    public String getEmail() {
		return email;
	}
	
	public boolean setEmail(String email) {
		if (email == null ) return false;
        this.email = email;
        return true;  
	}
    public String getPassword() {
		return password;
	}
	
	public boolean setPassword(String password) {
		if (password == null ) return false;
        this.password = password;
        return true;  
	}
    public int getPoints() {
		return points;
	}
	
	public boolean setPoints(int points) {
		if (points < 0 ) return false;
        this.points = points;
        return true;  
	}
    
    public ArrayList<String> getBadges() {
		return badges;
	}
	
	public boolean setBadges(ArrayList<String> badges) {
		if (badges == null ) return false;
        this.badges = badges;
        return true;  
	}
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
	public static boolean isEmailTaken(String email) {
		for (User user : UserList.getInstance().getUsers()) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    	return email.matches(emailRegex);
	}
	
	public boolean setFriends(ArrayList<String> friends) {
		if (friends == null ) return false;
        this.friends = friends;
        return true;  
	}

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

	public boolean isStudent() {
		return false;
	}

	
}