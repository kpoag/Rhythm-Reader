package com.model;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;

/**
 * needs to finish song class
 * @author Jaylen 
 */
public class Song {
    private String songTitle;
    private String artist;
    private Genre genre;
    private DifficultyLevel difficulty;
    private String instrument;
    private double rating;
    private ArrayList<Measure> measures;

    public Song(String songTitle, String artist, Genre genre, DifficultyLevel difficulty, String instrument, double rating) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        this.difficulty = difficulty;
        this.instrument = instrument;
        this.rating = rating;
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
    public String getsongTitle() {
        return songTitle;
    }
    public String getArtist() {
        return artist;
    }
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
    public String getInstrument() {
        return instrument;
    }
    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    public Genre getGenre() {
        return genre;
    }


    public void createSheetMusic() {
        
    }
    public boolean play(){
        return true;
    }
}
