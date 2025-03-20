package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a musical chord with notes, root note, chord type, duration, and arpeggiation status.
 */
public class Chords {
    
    private List<String> notes;
    private String rootNote;
    private String chordType;
    private float duration;
    private boolean isArpeggiated;

    /**
     * Constructs a {@code Chords} object.
     */
    public Chords(List<String> notes, String rootNote, String chordType, float duration, boolean isArpeggiated) {
        this.notes = new ArrayList<>(notes);
        this.rootNote = rootNote;
        this.chordType = chordType;
        this.duration = duration;
        this.isArpeggiated = isArpeggiated;
    }

    /**
     * Adds a note to the chord.
     */
    public void addNote(String note) {
        notes.add(note);
    }

    /**
     * Removes a note from the chord.
     */
    public void removeNote(String note) {
        notes.remove(note);
    }

    /**
     * Returns the list of notes in the chord.
     */
    public List<String> getNotes() {
        return notes;
    }

    /**
     * Returns the root note of the chord.
     */
    public String getRootNote() {
        return rootNote;
    }

    /**
     * Returns the chord type.
     */
    public String getChordType() {
        return chordType;
    }

    /**
     * Returns the duration of the chord.
     */
    public float getDuration() {
        return duration;
    }

    /**
     * Returns whether the chord is arpeggiated.
     */
    public boolean isArpeggiated() {
        return isArpeggiated;
    }

    /**
     * Returns a string representation of the chord.
     */
    public String toString() {
        return "Chords{" +
                "notes=" + notes +
                ", rootNote='" + rootNote + '\'' +
                ", chordType='" + chordType + '\'' +
                ", duration=" + duration +
                ", isArpeggiated=" + isArpeggiated +
                '}';
    }
}
