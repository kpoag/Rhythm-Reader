

package com.model;

import java.util.Scanner;

public class RRFacade {
    private static RRFacade facade;
    private User currUser;
    private Song currSong;
    private SongList library;

    public User login(String email, String password) {
         return UserList.getInstance().getUser(email, password);
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

    public SongList getLibrary() {
        return library;
    }

    public User createAccount(String userName, String firstName, String lastName, String email,String password, Scanner scanner) {
        User newUser = User.createAccountByType(userName, firstName, lastName, email, password, scanner);
        if (newUser != null) {
            this.currUser = newUser;
        } 
        return newUser;
        
    }
    
}
