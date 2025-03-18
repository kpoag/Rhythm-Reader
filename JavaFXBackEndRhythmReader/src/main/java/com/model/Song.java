package com.model;

import java.util.ArrayList;

/**
 * 
 * @author Jaylen 
 */
public class Song {
    private String songID;
    private String songTitle;
    private String artist;
    private Genre genre;
    private DifficultyLevel difficulty;
    private String instrument;
    private double rating;
    private ArrayList<Measure> measures;

    public Song(String songID, String songTitle, String artist, Genre genre, DifficultyLevel difficulty, String instrument, double rating) {
        this.songID= songID;
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

    public String getSongID()
    {
        return songID;
    }
    public void setSongID(String songID)
    {
        this.songID= songID;
    }
    public double getRating() {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating= rating;
    }
    /* 
    public List<Song> filterMusic() {
        return SongList;
    } */
    public boolean playWithMetronome(){
        return true;
    }
    public String getSongTitle() {
        return songTitle;
    }
    public void setSongTitle(String songTitle)
    {
        this.songTitle= songTitle;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist)
    {
        this.artist= artist;
    }
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(DifficultyLevel difficulty)
    {
        this.difficulty= difficulty;
    }
    public String getInstrument() {
        return instrument;
    }
    public void setInstrument(String instrument)
    {
        this.instrument= instrument;
    }
    public ArrayList<Measure> getMeasures() {
        return measures;
    }
    public void setMeasures(ArrayList<Measure> measures)
    {
        this.measures= measures ;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre)
    {
        this.genre= genre;
    }


    public void createSheetMusic() {
        
    }
    public boolean play(){
        return true;
    }
}
