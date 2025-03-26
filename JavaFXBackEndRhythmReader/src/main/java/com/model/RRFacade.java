

package com.model;

import java.util.ArrayList;
import java.util.Scanner;

public class RRFacade {
    private static RRFacade facade;
    private User currUser;
    private Song currSong;
    private SongList songList;
    private UserList userList;
    private Scanner scanner = new Scanner(System.in);  

    public RRFacade() {
        this.userList = UserList.getInstance();
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
            System.out.println("Account created successfully");
            return true;
        } 
        System.out.println("Failed to create account");
        return false;
    }

    public boolean isUserLoggedIn() {
        return currUser != null;
    }

    
    public boolean playASong() {
        try {
        Song freeFallin = new Song("e6cd1fd6-024e-45e5-a3f6-a781a019f1ec", "Free Fallin", "Tom Petty", Genre.POP, DifficultyLevel.INTERMEDIATE, "Guitar", 9.5, 84, "4/4");
        Song maryJane = new Song("b7cd1fd6-034e-45e5-a3f6-a781a019f1ec", "Mary Jane's Last Dance", "Tom Petty", Genre.POP, DifficultyLevel.ADVANCED, "Guitar", 9.0, 96, "4/4");
        Song wontBackDown = new Song("c8cd1fd6-044e-45e5-a3f6-a781a019f1ec", "I Won't Back Down", "Tom Petty", Genre.POP, DifficultyLevel.INTERMEDIATE, "Guitar", 8.5, 80, "4/4");
    
        
        songList = songList.getInstance();
        songList.addSong(freeFallin);
        songList.addSong(maryJane);
        songList.addSong(wontBackDown);

        System.out.println("How would you like to Filter Songs? Options : Genre (1) - Artist (2)");
        int option = scanner.nextInt();

        System.out.println("What artist would you like to play?");
        scanner.nextLine();
        String artist = scanner.nextLine();

        System.out.println("Which song would you like to play by " + artist + " ? Enter (1-3)");
        System.out.println("Songs by " + artist + ":");
        for (int i = 0; i < songList.getSongs().size(); i++) {
            System.out.println((i + 1) + ". " + songList.getSongs().get(i).getSongTitle());
        }

        System.out.println("Playing Free Fallin by Tom Petty");
        freeFallin.playSongWithTempo(84);

        System.out.println("Would you like to print the sheet music? (y/n)");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("y")) {
            freeFallin.playSongWithTempo(option, freeFallin.getSongTitle()+".txt");
        }
          return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }


        
    }
    

    
    
}
