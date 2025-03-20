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
    private String beats;
    private String dynamics;

    /**
     * Constructs a new Measure object.
     *
     * @param notes a list of Chords representing the notes in the measure
     * @param timeSignature a string representing the time signature of the measure
     * @param beats a string representing the beats per measure (e.g., "4/4")
     * @param dynamics a string representing the dynamic markings (e.g., "f" for forte)
     */
    public Measure(List<Chords> notes, String beats, String dynamics) {
        this.measures = new ArrayList<>();
        this.notes = new ArrayList<>(notes);
        this.beats = beats;
        this.dynamics = dynamics;
    }

    /**
     * Adds a note to the measure.
     *
     * @param note the Chords object to be added to the measure
     */
    public boolean addNote(Chords note) {
        return notes.add(note);
    }

    /**
     * Removes a note from the measure.
     *
     * @param note the Chords object to be removed from the measure
     */
    public boolean removeNote(Chords note) {
        return notes.remove(note);
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
                ", beats='" + beats + '\'' +
                ", dynamics='" + dynamics + '\'' +
                '}';
    }
}
