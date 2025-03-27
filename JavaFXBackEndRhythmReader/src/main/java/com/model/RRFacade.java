

package com.model;

import java.util.ArrayList;
import java.util.Scanner;

public class RRFacade {
    private static RRFacade facade;
    private User currUser;
    private Song currSong;
    private UserList userList;
    private DataLoader dataLoader;  

    public RRFacade() {
        this.userList = UserList.getInstance();
        this.dataLoader = new DataLoader();
    }
    

    public boolean login(String email, String password) {
        User user = UserList.getInstance().getUser(email, password);
        if(user != null && user.getPassword().equals(password)) {
            this.currUser = user;   
            System.out.println("Login successful! Welcome, "+ user.getUserName());
            return true;
        }
        System.out.println("Login failed: Invalid credentials. Try again or Create an account. ");
        return false;
    }

    public boolean logout() {
        if (currUser == null) {
            System.out.println("No user is currently logged in.");
            return false;
        }
        System.out.println("Logout successful. Goodbye, " + currUser.getUserName() + "!");
        this.currUser = null;
        return true;
    }

    public User getCurrentUser() {
        return currUser;
    }

    public Song getCurrentSong() {
        return currSong;
    }

    public ArrayList<Song> searchSongs(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Search query cannot be empty.");
            return new ArrayList<>();
        }


        ArrayList<Song> results = Song.searchSongs(query);
        
        // Print search results
        if (results.isEmpty()) {
            System.out.println("No songs found matching: " + query);
        } else {
            System.out.println("Found " + results.size() + " song(s) matching: " + query);
            for (Song song : results) {
                System.out.println("- " + song.getSongTitle() + " by " + song.getArtist() + 
                                 " (Genre: " + song.getGenre() + ", Difficulty: " + song.getDifficulty() + ")");
            }
        }

        return results;
    }


    public boolean createAccount(String userName, String firstName, String lastName, String email,String password, Scanner scanner) {
        User newUser = User.createAccountByType(userName, firstName, lastName, email, password, scanner);
        if (newUser != null) {
            this.currUser = newUser;
            DataWriter.saveUsers();
            return true;
        } 
        return false;
    }

    public boolean isUserLoggedIn() {
        return currUser != null;
    }

    public Song createNewSong(User user,Scanner scanner)
    {
        if (currUser == null) {
            System.out.println("You must be logged in to create a song.");
            return null;
        } 

        Song newSong = Song.createUserSong(currUser, scanner);
        this.currSong = newSong; // Store the current song
        return newSong;
    }

    public void playCurrentSong() {
        if (currSong == null) {
            System.out.println("No song selected to play.");
            return;
        }
        currSong.playSong();
    }

    public void saveCurrentSong() {
        if (currUser == null) {
            System.out.println("You must be logged in to save a song.");
            return;
        }
        if (currSong == null) {
            System.out.println("No song created to save.");
            return;
        }
        currSong.saveToJson(DataLoader.SONG_FILE_NAME, currUser);
    }

            
    

    
    
}
