package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
	protected UUID id;
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
    public int points;
    public String badges;
    private ArrayList<User> friends;
    

	public User(String userName, String firstName, String lastName, String email,
    String password, int points, String badges, ArrayList<User> friends) {
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
    String password, int points, String badges, ArrayList<User> friends) {
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
    
    public String getBadges() {
		return badges;
	}
	
	public void setBadges(String badges) {
		this.badges = badges;
	}
    public ArrayList<User> getFriends() {
		return friends;
	}
	
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public String toString() {
		return userName;
	}
	
}