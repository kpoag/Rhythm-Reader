package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a musical note with details such as name, pitch, duration, accidental,
 * tie, and articulation. It also allows adding chords and checking if the note is a rest.
 */
public class Notes {
    private List<Chords> notes;
    private String noteName;
    private String pitch;
    private float duration;
    private boolean accidental;
    private boolean tie;
    private String articulation;

    /**
     * Constructs a Note with the specified properties.
     */
    public Notes(String noteName, String pitch, float duration, boolean accidental, boolean tie, String articulation) {
        this.notes = new ArrayList<>();
        this.noteName = noteName;
        this.pitch = pitch;
        this.duration = duration;
        this.accidental = accidental;
        this.tie = tie;
        this.articulation = articulation;
    }

    /**
     * Checks if the note is a rest.
     */
    public boolean isRest() {
        return noteName.equals("rest");
    }

    /**
     * Adds a chord to the list of notes.
     */
    public boolean addChords(Chords chord) {
        return notes.add(chord);
    }

    /**
     * Returns the list of chords associated with the note.
     */
    public List<Chords> getNotes() {
        return notes;
    }

    /**
     * Returns the note's name.
     */
    public String getNoteName() {
        return noteName;
    }

    /**
     * Returns the note's pitch.
     */
    public String getPitch() {
        return pitch;
    }

    /**
     * Returns the note's duration.
     */
    public float getDuration() {
        return duration;
    }

    /**
     * Returns whether the note is accidental.
     */
    public boolean isAccidental() {
        return accidental;
    }

    /**
     * Returns whether the note is tied.
     */
    public boolean isTie() {
        return tie;
    }

    /**
     * Returns the articulation of the note.
     */
    public String getArticulation() {
        return articulation;
    }

    /**
     * Returns a string representation of the Note.
     */
    public String toString() {
        return "Note{" +
                "noteName='" + noteName + '\'' +
                ", pitch='" + pitch + '\'' +
                ", duration=" + duration +
                ", accidental=" + accidental +
                ", tie=" + tie +
                ", articulation='" + articulation + '\'' +
                '}';
    }
}
