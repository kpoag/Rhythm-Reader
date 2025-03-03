package com.model;

public class Instrument { 
    private String instrumentName;
    private String songName;
    private int tempo;
    private double accuracyScore;

    public Instrument(String instrumentName, String songName, int tempo, double accuracyScore) {
        this.instrumentName = instrumentName;
        this.songName = songName;
        this.tempo = tempo;
        this.accuracyScore = accuracyScore;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getAccuracyScore() {
        return accuracyScore;
    }

    public void setAccuracyScore(double accuracyScore) {
        this.accuracyScore = accuracyScore;
    }

    public void playExercise() {
        System.out.println(instrumentName + " is playing " + songName + " at " + tempo + " BPM.");
    }

    public void adjustTempo(int newTempo) {
        this.tempo = newTempo;
        System.out.println("Tempo adjusted to " + tempo + " BPM.");
    }

    public void evaluatePerformance(double newScore) {
        this.accuracyScore = newScore;
        System.out.println("Performance evaluated. New accuracy score: " + accuracyScore);
    }
}

    

