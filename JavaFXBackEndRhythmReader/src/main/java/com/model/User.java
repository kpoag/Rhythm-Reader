package com.model;

import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    int points;
    ArrayList<User> friends;


    public User(String firstName, String lastName, String username, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.points = 0;
        this.friends = new ArrayList<>();

    }

    public boolean logout() {
        return false;
    }
    public boolean resetPassword(String oldPassword, String newPassword) {
        return true;
    }
    public boolean addReview(String songName) {
        return true;
    }
    public ArrayList<User> displayLeaderboard(){
        return friends;
    }

    public boolean saveUser() {
        return true;
    }
    public boolean collectPoints() {
        return true;
    }
    public boolean isMatch(String username, String password) {
        return true;
    }

    public String getUsername() {
        return username;

    }
    public String getFirstname() {
        return firstName;
        
    }
    public String getLastname() {
        return lastName;
        
    }
    public String getPassword() {
        return password;
        
    }
    public String getEmail() {
        return email;
        
    }
    public int getPoints() {
        return points;

    }
    public ArrayList<User> getFriends() {
        return friends;

    }
    
}
