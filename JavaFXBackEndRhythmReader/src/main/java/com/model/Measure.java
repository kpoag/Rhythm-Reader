package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a musical measure containing a set of notes, tempo, time signature,
 * beats, and dynamics. This class allows adding and removing notes, changing the tempo,
 * and retrieving various details about the measure.
 */
public class Measure {
    
    private List<String> measures;
    private List<Chords> notes;
    private String timeSignature;
    private int tempo;
    private String beats;
    private String dynamics;

    /**
     * Constructs a new Measure object.
     *
     * @param notes a list of Chords representing the notes in the measure
     * @param timeSignature a string representing the time signature of the measure
     * @param tempo the tempo (beats per minute) of the measure
     * @param beats a string representing the beats per measure (e.g., "4/4")
     * @param dynamics a string representing the dynamic markings (e.g., "f" for forte)
     */
    public Measure(List<Chords> notes, String timeSignature, int tempo, String beats, String dynamics) {
        this.measures = new ArrayList<>();
        this.notes = new ArrayList<>(notes);
        this.timeSignature = timeSignature;
        this.tempo = tempo;
        this.beats = beats;
        this.dynamics = dynamics;
    }

    /**
     * Adds a note to the measure.
     *
     * @param note the Chords object to be added to the measure
     */
    public void addNote(Chords note) {
        notes.add(note);
    }

    /**
     * Removes a note from the measure.
     *
     * @param note the Chords object to be removed from the measure
     */
    public void removeNote(Chords note) {
        notes.remove(note);
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

    /**
     * Returns a list of notes (Chords) in the measure.
     *
     * @return a list of Chords objects
     */
    public List<Chords> getNotes() {
        return notes;
    }

    /**
     * Returns the time signature of the measure.
     *
     * @return the time signature as a string (e.g., "4/4")
     */
    public String getTimeSignature() {
        return timeSignature;
    }

    /**
     * Returns the tempo of the measure.
     *
     * @return the tempo (beats per minute) as an integer
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Returns the beats per measure as a string (e.g., "4/4").
     *
     * @return a string representing the beats per measure
     */
    public String getBeats() {
        return beats;
    }

    /**
     * Returns the dynamic markings for the measure.
     *
     * @return a string representing the dynamics (e.g., "f", "mf", etc.)
     */
    public String getDynamics() {
        return dynamics;
    }

    /**
     * Returns a string representation of the Measure object, including its notes,
     * time signature, tempo, beats, and dynamics.
     *
     * @return a string representation of the Measure object
     */
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
