

package com.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RRFacade {
    private static RRFacade facade;
    private User currUser;
    private Song currSong;
    private UserList userList;
    private DataLoader dataLoader;  
    private SongList songList;
    private Scanner scanner = new Scanner(System.in);  

    private RRFacade() {
        DataLoader.loadUsers(); 
    }

    public static RRFacade getInstance() {
        if (facade == null) {
            facade = new RRFacade();
        }
        return facade;
    }
    

    public boolean login(String email, String password) {
        User user = UserList.getInstance().getUser(email, password);
        if(user != null) {
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
        userList.saveUsers();
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


    public boolean createAccount(String userName, String firstName, String lastName, String email,String password, boolean type) {
        User newUser = User.createAccountByType(userName, firstName, lastName, email, password, type );
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

            

    public boolean playASong() {
        try {
        Song freeFallin = new Song("e6cd1fd6-024e-45e5-a3f6-a781a019f1ec", "Free Fallin", "Tom Petty", Genre.POP, DifficultyLevel.INTERMEDIATE, "Guitar", 9.5, 84, "4/4");
        Song maryJane = new Song("b7cd1fd6-034e-45e5-a3f6-a781a019f1ec", "Mary Jane's Last Dance", "Tom Petty", Genre.POP, DifficultyLevel.ADVANCED, "Guitar", 9.0, 96, "4/4");
        Song wontBackDown = new Song("c8cd1fd6-044e-45e5-a3f6-a781a019f1ec", "I Won't Back Down", "Tom Petty", Genre.POP, DifficultyLevel.INTERMEDIATE, "Guitar", 8.5, 80, "4/4");
    
        
        songList = songList.getInstance();
        DataLoader.loadSongs();
        
        

        songList.addSong(maryJane);
        songList.addSong(wontBackDown);

        System.out.println("How would you like to Filter Songs? Options : Genre (1) - Artist (2)");
        int option = scanner.nextInt();

        System.out.println("What artist would you like to play?");
        scanner.nextLine();
        String artist = scanner.nextLine();

        System.out.println("Which song would you like to play by " + artist + " ? Enter (1-3)");
        System.out.println("Songs by " + artist + ":");
        songList.filterByArtist(artist);
        for (int i = 5; i < songList.getSongs().size(); i++) {
            System.out.println((i - 4) + ". " + songList.getSongs().get(i).getSongTitle());
        }
        scanner.nextInt();
        scanner.nextLine();
        
        ArrayList<Song> searchResults = Song.searchSongs("Free Fallin'");
        System.out.println("Playing Free Fallin by Tom Petty");
        searchResults.get(0).playSong();

        System.out.println("Would you like to print the sheet music? (y/n)");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("y")) {
            writeSheetMusicToFile("freeFallin.txt");
        }
          return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }


        
    }

    public String writeSheetMusic() {
        
        ArrayList<Song> searchResults = Song.searchSongs("Free Fallin'");
        Song ff = searchResults.get(0);

        StringBuilder sheetMusic = new StringBuilder();
        sheetMusic.append("Title: ").append(ff.getSongTitle()).append("\n");
        sheetMusic.append("Artist: ").append(ff.getArtist()).append("\n\n");


        for (int i = 0; i < ff.getMeasures().size(); i++) {
            sheetMusic.append("Measure ").append(i + 1).append(": ").append(ff.getMeasures().get(i).toString()).append("\n");
        }
        return sheetMusic.toString();
    }

    public boolean writeSheetMusicToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            String sheetMusic = writeSheetMusic();
            writer.write(sheetMusic);
            System.out.println("Sheet music has successfully been writter to " + fileName);
            return true;
        } catch (Exception e) {
            System.err.println("Error writing sheet music to file: " + e.getMessage());
            return false;
        }
    }

    

    

    
}
