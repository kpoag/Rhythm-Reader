

package com.model;

public class RRFacade {
    private static RRFacade facade;
    private User currUser;
    private Song currSong;

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

    
    
}
