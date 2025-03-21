package com.model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

/**
 * @author Kennedy Poag
 * Represents a musical chord composed of a list of Note objects.
 * It includes a root note, chord type, note duration type, and an arpeggiation flag.
 */
public class Chords {
    private List<Note> notes;
    private String rootNote;
    private String chordType;
    private Notetype noteType;
    private boolean isArpeggiated;

    /**
     * Constructs a chord with the given notes, root note, chord type, note type, and arpeggiation flag.
     *
     * @param notes         notes for the chord 
     * @param rootNote      root note of the chord
     * @param chordType     chord type
     * @param noteType      note duration type
     * @param isArpeggiated if the chord is arpeggiated
     */
    public Chords(List<Note> notes, String rootNote, String chordType, Notetype noteType, boolean isArpeggiated) {
        this.notes = notes != null ? new ArrayList<>(notes) : new ArrayList<>();
        this.rootNote = rootNote;
        this.chordType = chordType;
        this.noteType = noteType;
        this.isArpeggiated = isArpeggiated;
    }

    /**
     * Returns the list of notes that make up the chord.
     *
     * @return the list of objects
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * Returns the root note of the chord.
     *
     * @return rootNote
     */
    public String getRootNote() {
        return rootNote;
    }

    /**
     * Returns the chord type.
     *
     * @return chord type
     */
    public String getChordType() {
        return chordType;
    }

    /**
     * Returns the note duration type from Notetype enum.
     *
     * @return note type
     */
    public Notetype getNotetype() {
        return noteType;
    }

    /**
     * Returns whether the chord is arpeggiated.
     *
     * @return true or false
     */
    public boolean isArpeggiated() {
        return isArpeggiated;
    }

    /**
     * Sets the notes for the chord.
     *
     * @param notes new list of notes
     * @return true or false if notes were set
     */
    public boolean setNotes(List<Note> notes) {
        if (notes != null) {
            this.notes = new ArrayList<>(notes);
            return true;
        }
        return false;
    }

    /**
     * Sets the root note.
     *
     * @param rootNote the new root note (must not be null or empty)
     * @return true or false if root note was set
     */
    public boolean setRootNotes(String rootNote) {
        if(rootNote != null && !rootNote.isEmpty()) {
            this.rootNote = rootNote;
            return true;
        }
        return false;
    }

    /**
     * Sets the chord type.
     *
     * @param chordType new chord type
     * @return true or false if chord type was set
     */
    public boolean setChordType(String chordType) {
        if (chordType != null) {
            this.chordType = chordType;
            return true;
        }
        return false;
    }

    /**
     * Sets the note duration type.
     *
     * @param notetype new note type
     * @return true or false if note type was set
     */
    public boolean setValue(Notetype notetype) {
        if (notetype != null) {
            this.noteType = notetype;
            return true;
        }
        return false;
    }

    /**
     * Sets whether the chord is arpeggiated.
     *
     * @param arpeggiated 
     * @return true
     */
    public boolean setArpeggiated(boolean arpeggiated) {
        this.isArpeggiated = arpeggiated;
        return true;
    }

    /**
     * Converts the chord to a JFugue string in order to play the chord
     *
     * @return the JFugue string representation of the chord
     */
    public String toJFugueString() {
        if (notes == null || notes.isEmpty()) {
            return "";
        }
        
        // Single note does not need to be a chord
        if (notes.size() == 1) {
            Note note = notes.get(0);
            return note != null ? note.toJFugueString() : "";
        }
        
        // Return rests when needed
        if (noteType == Notetype.WHOLE_REST) return "Rw";
        if (noteType == Notetype.HALF_REST) return "Rh";
        if (noteType == Notetype.QUARTER_REST) return "Rq";

        String noteTypeSymbol = getNoteTypeSymbol(noteType);
        StringBuilder builder = new StringBuilder();
        
        // Loops through each note in the chord
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note != null) {
                if (i > 0) {
                    // Add a '+' to separate notes in the chord
                    builder.append("+");
                }
                // Append the note's pitch, modifier, and octave
                builder.append(note.getPitch());
                if (!note.getModifier().isEmpty()) {
                    builder.append(note.getModifier());
                }
                builder.append(note.getOctave());
            }
        }
        
        // Append the note duration (like "q" for qurater note) after chord notes
        builder.append(noteTypeSymbol);
        
        // Return completed JFugue-formatted chord string
        return builder.toString();
    }

    /**
     * Gets the JFugue symbol for the given note type.
     *
     * @param noteType note type
     * @return the corresponding JFugue duration symbol
     */
    private String getNoteTypeSymbol(Notetype noteType) {
        if (noteType == null) return "q"; // Default to quarter note if null
    
        if (noteType == Notetype.WHOLE_NOTE) return "w";
        if (noteType == Notetype.HALF_NOTE) return "h";
        if (noteType == Notetype.QUARTER_NOTE) return "q";
        if (noteType == Notetype.EIGHTH_NOTE) return "i";
        if (noteType == Notetype.SIXTEENTH_NOTE) return "s";
        if (noteType == Notetype.DOTTED_EIGHTH_NOTE) return "i.";
        if (noteType == Notetype.WHOLE_REST) return "w";
        if (noteType == Notetype.HALF_REST) return "h";
        if (noteType == Notetype.QUARTER_REST) return "q";
        return "q"; 
    }
        
    /**
     * Creates a Chords object from a JSON array of note strings.
     *
     * @param jsonArray the measure array's containing note strings in songs.json
     * @return a new Chords instance built from the array, or a default chord if the array is empty
     */
    public static Chords fromJSONArray(JSONArray jsonArray) {
        // If the JSON array is null or empty, return a default chord
        if (jsonArray == null || jsonArray.isEmpty()) {
            return new Chords(new ArrayList<>(), "", "", Notetype.QUARTER_NOTE, false);
        }
        
        // Initialize a list to hold Note objects and a variable to hold the chord type
        List<Note> noteList = new ArrayList<>();
        Notetype noteType = null;
        
        // Iterate over each element in JSON array.
        for (Object obj : jsonArray) {
            // Check if element is a String
            if (obj instanceof String) {
                String noteString = (String) obj;
                // Convert the string to a Note object
                Note note = Note.fromString(noteString);
                // If the conversion is successful, add it to the note list
                if (note != null) {
                    noteList.add(note);
                    if (noteType == null) {
                        noteType = note.getNoteType();
                    }
                }
            }
        }
        
        // return a default chord if no valid notes were found
        if (noteList.isEmpty()) {
            return new Chords(noteList, "", "", Notetype.QUARTER_NOTE, false);
        }
        
        // Determine root note and chord type based on the first note in the list
        String root = noteList.get(0).getPitch() + (noteList.get(0).getModifier().isEmpty() ? "" : noteList.get(0).getModifier());
        if (noteType == null) {
            noteType = noteList.get(0).getNoteType();
        }
        
        //Create and return a new Chords instance
        return new Chords(noteList, root, "", noteType, false);
    }

    /**
     * Returns a simple string representation of the chord.
     *
     * @return a string with chord details
     */
    @Override
    public String toString() {
        return "Chords{" +
                "notes=" + notes +
                ", rootNote='" + rootNote + '\'' +
                ", chordType='" + chordType + '\'' +
                ", Note Type =" + noteType +
                ", isArpeggiated=" + isArpeggiated +
                '}';
    }
}
