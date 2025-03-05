package com.model;
import java.util.ArrayList;
import java.util.List;

public class Chords {
    private List<String> notes;
    private String rootNote;
    private String chordType;
    private float duration;
    private boolean isArpeggiated;

    public Chords(List<String> notes, String rootNote, String chordType, float duration, boolean isArpeggiated) {
        this.notes = new ArrayList<>(notes);
        this.rootNote = rootNote;
        this.chordType = chordType;
        this.duration = duration;
        this.isArpeggiated = isArpeggiated;
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public void removeNote(String note) {
        notes.remove(note);
    }

    public List<String> getNotes() {
        return notes;
    }

    public String getRootNote() {
        return rootNote;
    }

    public String getChordType() {
        return chordType;
    }

    public float getDuration() {
        return duration;
    }

    public boolean isArpeggiated() {
        return isArpeggiated;
    }

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
