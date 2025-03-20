/**
 * Represents a musical instrument used for practicing songs, including details like
 * the instrument's name, the song being played, tempo, and accuracy score.
 */
package com.model;

public class Instrument { 
    private String instrumentName;
    private String songName;
    private int tempo;
    private double accuracyScore;

    /**
     * Constructs an Instrument with the specified details.
     */
    public Instrument(String instrumentName, String songName, int tempo, double accuracyScore) {
        this.instrumentName = instrumentName;
        this.songName = songName;
        this.tempo = tempo;
        this.accuracyScore = accuracyScore;
    }

    /**
     * Gets the instrument's name.
     */
    public String getInstrumentName() {
        return instrumentName;
    }

    /**
     * Sets the instrument's name.
     */
    public boolean setInstrumentName(String instrumentName) {
        if (instrumentName == null ) return false;
        this.instrumentName= instrumentName;
        return true; 
    }

    /**
     * Gets the song being played.
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Sets the song being played.
     */
    public boolean setSongName(String songName) {
        if (songName == null ) return false;
        this.songName= songName;
        return true; 
    }

    /**
     * Gets the tempo in beats per minute (BPM).
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Sets the tempo in BPM.
     */
    public boolean setTempo(int tempo) {
        if (tempo < 0 ) return false;
        this.tempo= tempo;
        return true; 
    }

    /**
     * Gets the accuracy score.
     */
    public double getAccuracyScore() {
        return accuracyScore;
    }

    /**
     * Sets the accuracy score.
     */
    public boolean setAccuracyScore(double accuracyScore) {
        if (accuracyScore < 0.0 ) return false;
        this.accuracyScore= accuracyScore;
        return true; 
    }

    /**
     * Simulates playing the exercise by displaying the instrument, song, and tempo.
     */
    public String playExercise() {
        return instrumentName + " is playing " + songName + " at " + tempo + " BPM.";
    }

    /**
     * Adjusts the tempo of the song.
     */
    public String adjustTempo(int newTempo) {
        this.tempo = newTempo;
        return "Tempo adjusted to " + tempo + " BPM.";
    }

    /**
     * Evaluates the performance by updating the accuracy score.
     */
    public String evaluatePerformance(double newScore) {
        this.accuracyScore = newScore;
         return "Performance evaluated. New accuracy score: " + accuracyScore;
    }
}
