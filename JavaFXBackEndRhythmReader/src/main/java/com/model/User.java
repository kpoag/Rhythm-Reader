package com.model;

import java.util.ArrayList;
import java.util.Map;
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
	
	public boolean setFriends(ArrayList<String> friends) {
		if (friends == null ) return false;
        this.friends = friends;
        return true;  
	}

	public String toString() {
		return userName;
	}

	
}