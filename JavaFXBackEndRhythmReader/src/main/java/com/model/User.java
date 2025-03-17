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

    public void setUserName(String userName)
    {
        this.userName= userName;
    }
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
    public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
    public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
    
    public ArrayList<String> getBadges() {
		return badges;
	}
	
	public void setBadges(ArrayList<String> badges) {
		this.badges = badges;
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
	
	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	public String toString() {
		return userName;
	}
	
}