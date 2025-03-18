/**
 * Package containing model classes.
 */
package com.model;

/**
 * The {@code Instrument} class represents a musical instrument used for practicing songs.
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
    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
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
    public void setSongName(String songName) {
        this.songName = songName;
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
    public void setTempo(int tempo) {
        this.tempo = tempo;
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
    public void setAccuracyScore(double accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    /**
     * Simulates playing the exercise by displaying the instrument name, song name, and tempo.
     */
    public void playExercise() {
        System.out.println(instrumentName + " is playing " + songName + " at " + tempo + " BPM.");
    }

    /**
     * Adjusts the tempo of the song.
     * 
     * @param newTempo the new tempo in BPM
     */
    public void adjustTempo(int newTempo) {
        this.tempo = newTempo;
        System.out.println("Tempo adjusted to " + tempo + " BPM.");
    }

    /**
     * Evaluates the performance by updating the accuracy score.
     * 
     * @param newScore the new accuracy score
     */
    public void evaluatePerformance(double newScore) {
        this.accuracyScore = newScore;
        System.out.println("Performance evaluated. New accuracy score: " + accuracyScore);
    }
}
