

package com.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfugue.player.Player;

import javafx.scene.layout.VBox;

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

    public boolean playCurrentSong() {
        if (currSong == null) {
            System.out.println("No song selected to play.");
            return false;
        }
        currSong.playSong();
        return true;
    }
    public void setCurrentSong(Song song) {
        this.currSong = song;
    }

    public boolean saveCurrentSong() {
        if (currSong != null && currUser != null) {
            ArrayList<Song> songs = DataLoader.loadSongs();
            songs.add(currSong);
            DataWriter.saveSongs();
            return true;
        }
        return false;
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

     public boolean renderSheetMusic(String songTitle, VBox container) {
        if (songTitle == null || container == null) {
            return false;
        }
        
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            return false;
        }
        
        song.renderSheetMusic(container);
        return true;
    }

    private Song findSongByTitle(String title) {
        ArrayList<Song> songs = DataLoader.loadSongs();
        for (Song song : songs) {
            if (song.getSongTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean playPianoNote(String note) {
        try {
            Player player = new Player();
            player.play("I[Piano] " + note);
            return true;
        } catch (Exception e) {
            System.err.println("Error playing note: " + e.getMessage());
            return false;
        }
    }

    public boolean playSong(String songTitle, int tempo, boolean useMetronome) {
        if (songTitle == null) {
            return false;
        }
        
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            return false;
        }
        
        song.setTempo(tempo);
        
        if (useMetronome) {
            song.playSongWithMetronome(() -> {
                System.out.println("Song finished playing");
            });
        } else {
            song.playSongAsync(() -> {
                System.out.println("Song finished playing");
            });
        }
        
        return true;
    }


    

    

    
}
