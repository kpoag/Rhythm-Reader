package com.model;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private List<Chords> notes;
    private String noteName;
    private String pitch;
    private float duration;
    private boolean accidental;
    private boolean tie;
    private String articulation;

    public Notes(String noteName, String pitch, float duration, boolean accidental, boolean tie, String articulation) {
        this.notes = new ArrayList<>();
        this.noteName = noteName;
        this.pitch = pitch;
        this.duration = duration;
        this.accidental = accidental;
        this.tie = tie;
        this.articulation = articulation;
    }

    public boolean isRest() {
        return noteName.equals("rest");
    }

    public boolean addChords(Chords chord) {
        return notes.add(chord);
    }

    public List<Chords> getNotes() {
        return notes;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getPitch() {
        return pitch;
    }

    public float getDuration() {
        return duration;
    }

    public boolean isAccidental() {
        return accidental;
    }

    public boolean isTie() {
        return tie;
    }

    public String getArticulation() {
        return articulation;
    }

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