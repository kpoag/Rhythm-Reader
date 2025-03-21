package com.model;

/**
 * The class represents a musical instrument used for practicing songs.
 * It contains details such as the instrument's name, the song being played, the tempo, 
 * and an accuracy score for evaluating performance.
 */
public class Instrument { 
    private String instrumentName;
    private String songName;
    private int tempo;
    private double accuracyScore;

    /**
     * Constructs an Instrument with the specified details.
     * 
     * @param instrumentName the name of the instrument
     * @param songName the name of the song being played
     * @param tempo the tempo of the song in beats per minute (BPM)
     * @param accuracyScore the accuracy score of the performance
     */
    public Instrument(String instrumentName, String songName, int tempo, double accuracyScore) {
        this.instrumentName = instrumentName;
        this.songName = songName;
        this.tempo = tempo;
        this.accuracyScore = accuracyScore;
    }

    /**
     * Gets the name of the instrument.
     * 
     * @return the instrument name
     */
    public String getInstrumentName() {
        return instrumentName;
    }

    /**
     * Sets the name of the instrument.
     * 
     * @param instrumentName the new instrument name
     */
    public boolean setInstrumentName(String instrumentName) {
        if (instrumentName == null ) return false;
        this.instrumentName= instrumentName;
        return true; 
    }

    /**
     * Gets the name of the song being played.
     * 
     * @return the song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Sets the name of the song being played.
     * 
     * @param songName the new song name
     */
    public boolean setSongName(String songName) {
        if (songName == null ) return false;
        this.songName= songName;
        return true; 
    }

    /**
     * Gets the tempo of the song in beats per minute (BPM).
     * 
     * @return the tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Sets the tempo of the song.
     * 
     * @param tempo the new tempo in BPM
     */
    public boolean setTempo(int tempo) {
        if (tempo < 0 ) return false;
        this.tempo= tempo;
        return true; 
    }

    /**
     * Gets the accuracy score of the performance.
     * 
     * @return the accuracy score
     */
    public double getAccuracyScore() {
        return accuracyScore;
    }

    /**
     * Sets the accuracy score of the performance.
     * 
     * @param accuracyScore the new accuracy score
     */
    public boolean setAccuracyScore(double accuracyScore) {
        if (accuracyScore < 0.0 ) return false;
        this.accuracyScore= accuracyScore;
        return true; 
    }

    /**
     * Simulates playing the exercise by displaying the instrument name, song name, and tempo.
     */
    public String playExercise() {
        return instrumentName + " is playing " + songName + " at " + tempo + " BPM.";
    }

    /**
     * Evaluates the performance by updating the accuracy score.
     * 
     * @param newScore the new accuracy score
     */
    public String evaluatePerformance(double newScore) {
        this.accuracyScore = newScore;
         return "Performance evaluated. New accuracy score: " + accuracyScore;
    }
}
