package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a musical measure with notes, beats, and dynamics. 
 * Allows adding/removing notes, retrieving measure details, and modifying the measure.
 */
public class Measure {
    
    private List<String> measures;
    private List<Chords> notes;
    private String beats;
    private String dynamics;

    /**
     * Constructs a Measure with the specified notes, beats, and dynamics.
     */
    public Measure(List<Chords> notes, String beats, String dynamics) {
        this.measures = new ArrayList<>();
        this.notes = new ArrayList<>(notes);
        this.beats = beats;
        this.dynamics = dynamics;
    }

    /**
     * Adds a note to the measure.
     */
    public boolean addNote(Chords note) {
        return notes.add(note);
    }

    /**
     * Removes a note from the measure.
     */
    public boolean removeNote(Chords note) {
        return notes.remove(note);
    }

    /**
     * Returns the list of notes in the measure.
     */
    public List<Chords> getNotes() {
        return notes;
    }

    /**
     * Returns the beats per measure.
     */
    public String getBeats() {
        return beats;
    }

    /**
     * Returns the dynamic markings for the measure.
     */
    public String getDynamics() {
        return dynamics;
    }

    /**
     * Returns a string representation of the Measure.
     */
    public String toString() {
        return "Measure{" +
                "measures=" + measures +
                ", notes=" + notes +
                ", beats='" + beats + '\'' +
                ", dynamics='" + dynamics + '\'' +
                '}';
    }
}
