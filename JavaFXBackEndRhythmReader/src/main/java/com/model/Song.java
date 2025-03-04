package com.model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class Song {
    private String songTitle;
    private String artist;
    private Genre genre;
    private DifficultyLevel difficulty;
    private Instrument instrument;
    private double rating;
    private ArrayList<Measure> measures;

    public Song(String songTitle, String artist, Genre genre, DifficultyLevel difficulty, Instrument instrument) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        this.difficulty = difficulty;
        this.instrument = instrument;
        this.measures = new ArrayList<>();
    }

    public boolean addMeasure(Measure measure) {
        return true;
    }
    /* 
    public boolean addNoteToMeasure(int measureIndex, Note note) {
        return true;
    }
    
    public boolean removeNoteFromMeasire(int measureIndex, Note note) {
        return true;
    } */

    public double getRating() {
        return rating;
    }
    /* 
    public List<Song> filterMusic() {
        return SongList;
    } */
    public boolean playWithMetronome(){
        return true;
    }

    public void createSheetMusic() {
        
    }
    public boolean play(){
        return true;
    }
=======
public class Song {
    
>>>>>>> origin/Jaylen-Branch
}
