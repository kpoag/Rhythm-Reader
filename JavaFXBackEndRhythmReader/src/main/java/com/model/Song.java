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
    private int tempo;
    private String timeSignature;
    private ArrayList<Measure> measures;

    public Song(String songID, String songTitle, String artist, Genre genre, 
    DifficultyLevel difficulty, String instrument, double rating, int tempo, String timeSignature) {
        this.songID= songID;
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        this.difficulty = difficulty;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
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
    public boolean setSongID(String songID){
        if (songID == null ) return false;
        this.songID = songID ;
        return true;   
    }
    public double getRating() {
        return rating;
    }

    public boolean setRating(double rating) {
        if (rating < 0.0 || rating > 10.0) {
            return false;
        }
        this.rating = rating;
        return true;
    }
    public double getTempo(){
        return tempo;
    }
    public boolean setTempo(int tempo){
        if (tempo < 0) return false;
        this.tempo = tempo;
        return true;
    }
    public String getTimeSignature(){
        return timeSignature;
    }
    public boolean setTimeSignature(String timeSignature){
        if(timeSignature == null) return false;
        this.timeSignature = timeSignature;
        return true;
    }
     /**
     * Changes the tempo of the measure.
     *
     * @param newTempo the new tempo (beats per minute) to set
     * @return the updated tempo
     */
    public int changeTempo(int newTempo) {
        this.tempo = newTempo;
        return this.tempo;
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
    public boolean setSongTitle(String songTitle){
        if (songTitle == null) return false;
        this.songTitle = songTitle ;
        return true;    
    }
    public String getArtist() {
        return artist;
    }
    public boolean setArtist(String artist){
        if (artist == null) return false;
        this.artist = artist ;
        return true;
    }
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
    public boolean setDifficulty(DifficultyLevel difficulty){
        if (difficulty == null) return false;
        this.difficulty = difficulty ;
        return true;
    }
    public String getInstrument() {
        return instrument;
    }
    public boolean setInstrument(String instrument){
        if (instrument == null) return false;
        this.instrument = instrument ;
        return true;
    }
    public ArrayList<Measure> getMeasures() {
        return measures;
    }
    public boolean setMeasures(ArrayList<Measure> measures){
        if (measures == null) return false;
        this.measures= measures ;
        return true;
    }

    public Genre getGenre() {
        return genre;
    }
    public boolean setGenre(Genre genre){
        if (genre == null) return false;
        this.genre= genre;
        return true;
    }


    public boolean createSong() {
        
    }
    public boolean play(){
        return true;
    }
}
