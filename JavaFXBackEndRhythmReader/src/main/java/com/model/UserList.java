package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList users;

    private ArrayList<User> userList;
    private UUID userID;

    private UserList() {
        userList = Database.getAllUsers();
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
