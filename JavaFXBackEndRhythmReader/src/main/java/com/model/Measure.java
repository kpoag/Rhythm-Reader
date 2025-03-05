package com.model;

import java.util.ArrayList;
import java.util.List;

public class Measure {
    private List<String> measures;
    private List<Chords> notes;
    private String timeSignature;
    private int tempo;
    private String beats;
    private String dynamics;

    public Measure(List<Chords> notes, String timeSignature, int tempo, String beats, String dynamics) {
        this.measures = new ArrayList<>();
        this.notes = new ArrayList<>(notes);
        this.timeSignature = timeSignature;
        this.tempo = tempo;
        this.beats = beats;
        this.dynamics = dynamics;
    }

    public void addNote(Chords note) {
        notes.add(note);
    }

    public void removeNote(Chords note) {
        notes.remove(note);
    }

    public int changeTempo(int newTempo) {
        this.tempo = newTempo;
        return this.tempo;
    }

    public List<Chords> getNotes() {
        return notes;
    }

    public String getTimeSignature() {
        return timeSignature;
    }

    public int getTempo() {
        return tempo;
    }

    public String getBeats() {
        return beats;
    }

    public String getDynamics() {
        return dynamics;
    }

    public String toString() {
        return "Measure{" +
                "measures=" + measures +
                ", notes=" + notes +
                ", timeSignature='" + timeSignature + '\'' +
                ", tempo=" + tempo +
                ", beats='" + beats + '\'' +
                ", dynamics='" + dynamics + '\'' +
                '}';
    }
}
