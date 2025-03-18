/*
    TO DO: 
    *create needed getters for methods below as well*
    create add, remove, friends Method
    play, create, edit sheet music methods
    search for songs method
    join/leave class method?
     */ 

package com.model;

public class RRFacade {
    private User currUser;
    private Song currSong;

    public User login(String email, String password) {
        User user = UserList.getInstance().getUser(email, password);
        this.currUser = user;
        return user;
        
    }

    public boolean logout() {
        if(this.currUser == null) {
            return false;
        }
        this.currUser = null;
        return true;
    }

    public User getCurrentUser() {
        return currUser;
    }

    public Song getCurrentSong() {
        return currSong;
    }

    
    
}
