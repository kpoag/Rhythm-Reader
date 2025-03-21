package com.model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

/**
 * @author Kennedy Poag
 * Represents a musical measure containing chords, beats, and dynamics.
 */
public class Measure {
    
    private List<Chords> chords;
    private String beats;
    private String dynamics;

    /**
     * Constructs a new Measure object.
     *
     * @param chords the list of chords in the measure
     * @param beats beats per measure (e.g., "4/4")
     * @param dynamics  dynamic markings (e.g., "f" for forte)
     */
    public Measure(List<Chords> chords, String beats, String dynamics) {
        this.chords = chords != null ? new ArrayList<>(chords) : new ArrayList<>();
        this.beats = beats;
        this.dynamics = dynamics;
    }

    /**
     * Returns the list of chords in the measure.
     *
     * @return chords list
     */
    public List<Chords> getChords() {
        return chords;
    }

    /**
     * Returns the beats per measure as a string (e.g., "4/4").
     *
     * @return beats
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
     * Sets the chords for the measure.
     *
     * @param chords new list of chords
     * @return true or false if chords were set
     */
    public boolean setChords(List<Chords> chords) {
        if (chords != null) {
            this.chords = new ArrayList<>(chords);
            return true;
        }
        return false;
    }

    /**
     * Sets the beats per measure.
     *
     * @param beats the beats string (e.g., "4/4")
     * @return true or false if beats were set
     */
    public boolean setBeats(String beats) {
        if (beats != null && !beats.isEmpty()) {
            this.beats = beats;
            return true;
        }
        return false;
    }

    /**
     * Sets the dynamic markings.
     *
     * @param dynamics the dynamics string (e.g., "f")
     * @return true or false if value was set
     */
    public boolean setDynamics(String dynamics) {
        if (dynamics != null) {
            this.dynamics = dynamics;
            return true;
        }
        return false;
    }

    /**
     * Creates a Measure from JSON data.
     *
     * @param jsonData JSON data for the measure
     * @param beats    beats per measure
     * @param dynamics dynamic markings
     * @return a new Measure object
     */
    public static Measure fromJSON(Object jsonData, String beats, String dynamics) {
        List<Chords> chordList = new ArrayList<>();
        
        // If JSOn data is null, return a new measure with empty chord list
        if (jsonData == null) {
            return new Measure(chordList, beats, dynamics);
        }
        
        // Verification to ensure jsonData is a JSONArray
        JSONArray jsonMeasure;
        if (jsonData instanceof JSONArray) {
            jsonMeasure = (JSONArray) jsonData;
        } else {
            System.err.println("Error: Unexpected data type: " + jsonData.getClass().getName());
            return new Measure(chordList, beats, dynamics);
        }
        
        // Loop through each element in the JSONArray to create Chords
        for (Object obj : jsonMeasure) {
            if (obj instanceof String) {
                Note note = Note.fromString((String) obj);
                if (note != null) {
                    List<Note> noteList = new ArrayList<>();
                    noteList.add(note);
                    Chords chord = new Chords(noteList, note.getPitch() + note.getModifier(), "", note.getNoteType(), false);
                    chordList.add(chord);
                }
            } 
            // Else, if object is a JSONArray, it is an array of notes representing a chord.
            else if (obj instanceof JSONArray) {
                JSONArray noteArray = (JSONArray) obj;
                List<Note> noteList = new ArrayList<>();
                Notetype commonNoteType = null;
                boolean hasDottedEighth = false;

                // Check for dotted eighth note symbol
                for (Object noteObj : noteArray) {
                    if (noteObj instanceof String) {
                        String noteStr = (String) noteObj;
                        if (noteStr.contains("i.")) {
                            hasDottedEighth = true;
                            break;
                        }
                    }
                }
                
                // Process each note in the chord array
                for (Object noteObj : noteArray) {
                    if (noteObj instanceof String) {
                        Note note = Note.fromString((String) noteObj);
                        if (note != null) {
                            if (hasDottedEighth) {
                                note.setNoteType(Notetype.DOTTED_EIGHTH_NOTE);
                            }
                            noteList.add(note);
                            // Use the first note's type for all notes in the chord
                            if (commonNoteType == null) {
                                commonNoteType = note.getNoteType();
                            }
                        }
                    }
                }
                
                //Finalize chord if note list for the chord isn't empty
                if (!noteList.isEmpty()) {
                    // Verify all notes in the chord have the same note type
                    for (Note note : noteList) {
                        note.setNoteType(commonNoteType);
                    }
                    Chords chord = new Chords(noteList, "chord", "", commonNoteType, false);
                    chordList.add(chord);  
                }
            }
        }
        // Create and return a new Measure object
        return new Measure(chordList, beats, dynamics);
    }

    /**
     * Calculates the expected number of beats per measure.
     *
     * @return the expected beats based on the beats string or first chord note's time signature
     */
    public double getExpectedBeats() {
        String bpm = this.beats;

        // If beats is null or empty, use the first chord's note's time signature
        if (bpm == null || bpm.isEmpty()) {
            if (chords != null && !chords.isEmpty() && chords.get(0) != null && 
                chords.get(0).getNotes() != null && !chords.get(0).getNotes().isEmpty()) {
                bpm = chords.get(0).getNotes().get(0).getTimeSignature();
            }
        }
        
        if (bpm == null || !bpm.contains("/")) {
            return 0;
        }
        
        // Split the beats string and scale the numerator to 4 divided by the denominator
        String[] parts = bpm.split("/");
        try {
            double num = Double.parseDouble(parts[0]);
            double den = Double.parseDouble(parts[1]);
            return num * (4.0 / den);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
    * Calculates the total beats contained in all chords of the measure.
    * Each chord's note type is converted to its beat value and the sum is returned.
    *
    * @return the total beats 
    */
    public double getTotalBeats() {
        double sum = 0;
        if (chords == null) return sum;
        
        for (Chords chord : chords) {
            if (chord != null && chord.getNotetype() != null) {
                sum += noteTypeToBeats(chord.getNotetype());
            }
        }
        return sum;
    }
    
    /**
    * Converts a given note type to its corresponding beat value.
    *
    * @param type note type to convert
    * @return number of beats relating to the note type or 1.0 if unknown
    */
    private double noteTypeToBeats(Notetype type) {
        if (type == null) return 1.0;
        
        if (type == Notetype.WHOLE_NOTE)          return 4.0;
        if (type == Notetype.HALF_NOTE)           return 2.0;
        if (type == Notetype.QUARTER_NOTE)        return 1.0;
        if (type == Notetype.EIGHTH_NOTE)         return 0.5;
        if (type == Notetype.DOTTED_EIGHTH_NOTE)  return 0.75; 
        if (type == Notetype.SIXTEENTH_NOTE)      return 0.25;
        if (type == Notetype.WHOLE_REST)          return 4.0;
        if (type == Notetype.HALF_REST)           return 2.0;
        if (type == Notetype.QUARTER_REST)        return 1.0;
        return 1.0;
    }
    
    /**
    * Builds and returns the JFugue pattern string for the measure.    *
    * @return complete JFugue pattern as a String
    */
    public String getJFuguePattern() {
        StringBuilder pattern = new StringBuilder();
    
    // Append time signature if available
    if (beats != null && !beats.isEmpty()) {
        pattern.append("TIME:").append(beats).append(" ");
    }
    
    // Append dynamics if available
    if (dynamics != null && !dynamics.isEmpty()) {
        pattern.append(dynamics).append(" ");
    }
    
    // Append each chord's JFugue string
    for (Chords chord : chords) {
        if (chord != null) {
            String chordString = chord.toJFugueString();
            if (chordString != null && !chordString.isEmpty()) {
                pattern.append(chordString).append(" ");
            }
        }
    }
    
    return pattern.toString().trim();
    }

    /**
     * Returns a string representation of the Measure object
     *
     * @return a string with chords, beats, and dynamics
     */
    @Override
    public String toString() {
        return "Measure{" +
                "chords=" + chords +
                ", beats='" + beats + '\'' +
                ", dynamics='" + dynamics + '\'' +
                '}';
    }
}
