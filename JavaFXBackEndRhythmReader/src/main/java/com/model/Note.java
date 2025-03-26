package com.model;

import org.json.simple.JSONObject;

/**
 * @author Kennedy Poag
 * Represents a musical note with properties such as pitch, modifier,
 * note type (duration), octave, time signature, articulation, and tie.
 */
public class Note {
    private String modifier;
    private String pitch;
    private Notetype noteType;
    private String timeSignature;
    private String articulation;
    private boolean tie;
    private int octave;

    /**
     * Constructs a Note with the specified properties.
     *
     * @param modifier      the note modifier (e.g., "#" or "b"); if null, an empty string is used
     * @param pitch         the pitch of the note (e.g., "C", "D")
     * @param noteType      the type/duration of the note (e.g., quarter note, eighth note)
     * @param tie           whether the note is tied to the next note
     * @param articulation  the articulation of the note (e.g., staccato); if null, an empty string is used
     * @param octave        the octave number; if not positive, defaults to 4
     * @param timeSignature the time signature for the note (e.g., "4/4")
     */
    public Note(String modifier, String pitch, Notetype noteType,
    boolean tie, String articulation, int octave, String timeSignature) {
        this.modifier = (modifier != null) ? modifier : "";
        this.octave = (octave > 0) ? octave : 4;
        this.pitch = pitch;
        this.noteType = noteType;
        this.tie = tie;
        this.articulation = (articulation != null) ? articulation: "";
        this.timeSignature = timeSignature;
    }

     /**
     * Returns the pitch of the note.
     *
     * @return pitch as a String
     */
    public String getPitch() {
        return pitch;
    }
    
    /**
     * Returns the modifier of the note.
     *
     * @return modifier as a String
     */
    public String getModifier(){
        return modifier;
    }
    
    /**
     * Returns the note type (duration) of the note.
     *
     * @return note type as a Notetype
     */
    public Notetype getNoteType() {
        return noteType;
    }
    
    /**
     * Returns the time signature associated with the note.
     *
     * @return time signature as a String
     */
    public String getTimeSignature(){
        return timeSignature;
    }
    
    /**
     * Indicates whether the note is tied to the next note.
     *
     * @return true if the note is tied, false otherwise
     */
    public boolean isTie() {
        return tie;
    }
    
    /**
     * Returns the articulation of the note.
     *
     * @return articulation as a String
     */
    public String getArticulation() {
        return articulation;
    }
    
    /**
     * Returns the octave of the note.
     *
     * @return octave number
     */
    public int getOctave() {
        return octave;
    }
    
    /**
     * Sets the pitch of the note.
     *
     * @param pitch  new pitch
     * @return true if set successfully, false if pitch is null or empty
     */
    public boolean setPitch(String pitch) {
        if (pitch != null && !pitch.isEmpty()) {
            this.pitch = pitch;
            return true;
        }
        return false;
    }
    
    /**
     * Sets the modifier of the note.
     *
     * @param modifier new modifier
     * @return true if set successfully, false if modifier is null
     */
    public boolean setModifier(String modifier) {
        if (modifier != null ) {
            this.modifier = modifier;
            return true;
        }
        return false;
    }
    
    /**
     * Sets the note type (duration) of the note.
     *
     * @param noteType the new note type
     * @return true if set successfully, false if noteType is null
     */
    public boolean setNoteType(Notetype noteType) {
        if (noteType != null ) {
            this.noteType = noteType;
            return true;
        }
        return false;
    }
    
    /**
     * Sets whether the note is tied.
     *
     * @param tie true to tie the note, false otherwise
     * @return true after setting the value
     */
    public boolean setTie(boolean tie) {
        this.tie = tie;
        return true;
    }
    
    /**
     * Sets the articulation of the note.
     *
     * @param articulation the new articulation
     * @return true if set successfully, false if articulation is null
     */
    public boolean setArticulation(String articulation) {
        if (articulation != null) {
            this.articulation = articulation;
            return true;
        }
        return false;
    }
    
    /**
     * Sets the octave of the note.
     *
     * @param octave the new octave; must be positive
     * @return true if set successfully, false otherwise
     */
    public boolean setOctave(int octave) {
        if (octave > 0) {
            this.octave = octave;
            return true;
        }
        return false;
    }

     /**
     * Converts the note to a JFugue-compatible string representation.
     * This method formats the note based on its pitch, modifier, octave, note type,
     * articulation, and tie.
     *
     * @return the JFugue string representation of the note
     */
    public String toJFugueString(){
        StringBuilder builder = new StringBuilder();

        // Handle rests by returning the rest symbol immediately
        if (noteType == Notetype.WHOLE_REST) return "Rw";
        if (noteType == Notetype.HALF_REST) return "Rh";
        if (noteType == Notetype.QUARTER_REST) return "Rq";

        builder.append(pitch);
        
        if(!modifier.isEmpty()) {
            builder.append(modifier);
        }
        
        builder.append(octave);
        
        // Append the note type symbol (lowercase for JFugue)
        String noteTypeSymbol = getNoteTypeSymbol(noteType);
        builder.append(noteTypeSymbol);
        
        // Append articulation if exists
        if (articulation != null && !articulation.isEmpty()) {
            builder.append(articulation);
        }
        
        // Append tie symbol if the note is tied to the next note
        if (tie) {
            builder.append("_");
        }
        
        return builder.toString();
    }

    /**
     * Returns the note's basic representation without duration or articulation.
     *
     * @return a string containing pitch, modifier, and octave
     */
    public String getNoteWithoutDuration() {
        StringBuilder builder = new StringBuilder();
        builder.append(pitch);
        
        if(!modifier.isEmpty()) {
            builder.append(modifier);
        }
        
        builder.append(octave);
        return builder.toString();
    }

    /**
     * Returns the JFugue symbol corresponding to the given note type.
     *
     * @param noteType the note type to convert
     * @return the JFugue duration symbol as a String
     */
    private String getNoteTypeSymbol(Notetype noteType){
        if (noteType == null) return "q"; // Default to quarter note if null
        
        if (noteType == Notetype.WHOLE_NOTE) return "w";
        if (noteType == Notetype.HALF_NOTE) return "h";
        if (noteType == Notetype.QUARTER_NOTE) return "q";
        if (noteType == Notetype.EIGHTH_NOTE) return "i";
        if (noteType == Notetype.SIXTEENTH_NOTE) return "s";
        if (noteType == Notetype.DOTTED_EIGHTH_NOTE) return "i.";
        if (noteType == Notetype.WHOLE_REST) return "Rw";
        if (noteType == Notetype.HALF_REST) return "Rh";
        if (noteType == Notetype.QUARTER_REST) return "Rq";
        return "q"; 
    }

    /**
     * Creates a Note from its string representation.
     *
     * @param noteString the string representation of the note
     * @return a new Note object, or null if the input is invalid
     */
    public static Note fromString(String noteString){
        if (noteString == null || noteString.isEmpty()) return null;
    
        // Handle rests
        if (noteString.startsWith("R")) {
            Notetype restType = Notetype.QUARTER_REST;
            if (noteString.equals("Rw")) restType = Notetype.WHOLE_REST;
            else if (noteString.equals("Rh")) restType = Notetype.HALF_REST;
            else if (noteString.equals("Rq")) restType = Notetype.QUARTER_REST;
                
            return new Note("", "R", restType, false, "", 4, "4/4");
        }

        // Extract pitch (first character)
        String pitch = noteString.substring(0, 1);
        String modifier = "";
        int i = 1;
            
        // Check for a modifier (# or b)
        if (noteString.length() > i && (noteString.charAt(i) == '#' || noteString.charAt(i) == 'b')) {
            modifier = String.valueOf(noteString.charAt(i));
            i++;
        }
            
        // Extract octave digits
        StringBuilder oct = new StringBuilder();
        while (i < noteString.length() && Character.isDigit(noteString.charAt(i))) {
            oct.append(noteString.charAt(i));
            i++;
        }
            
        int octave = 4;
        if (oct.length() > 0) {
            try {
                octave = Integer.parseInt(oct.toString());
            } catch (NumberFormatException e) {
                octave = 4;
            }
        }
            
        // Default note type is quarter note; parse remaining characters for duration
        Notetype noteType = Notetype.QUARTER_NOTE;
        String duration = "";
        if (i < noteString.length()) {
            duration = noteString.substring(i).toLowerCase(); // Convert to lowercase
            if (duration.equals("w")) {
                noteType = Notetype.WHOLE_NOTE;
            } else if (duration.equals("h")) {
                noteType = Notetype.HALF_NOTE;
            } else if (duration.equals("q")) {
                noteType = Notetype.QUARTER_NOTE;
            } else if (duration.equals("i")) {
                noteType = Notetype.EIGHTH_NOTE;
            } else if (duration.equals("i.")) {
                noteType = Notetype.DOTTED_EIGHTH_NOTE;
            } else if (duration.equals("s")) {
                noteType = Notetype.SIXTEENTH_NOTE;
            }
        }
        // Returnsa new Note object with the parsed properties
        return new Note(modifier, pitch, noteType, false, "", octave, "4/4");
    }

    /**
     * Converts the Note object to a JSON object.
     *
     * @return a JSONObject representing the note
     */
    public JSONObject toJSONObject() {
        JSONObject noteJson = new JSONObject();
        noteJson.put("pitch", this.pitch);
        noteJson.put("modifier", this.modifier);
        noteJson.put("octave", this.octave);
        noteJson.put("noteType", this.noteType.toString()); 

        return noteJson;
    }

    /**
     * Returns a string representation of the Note.
     *
     * @return a string containing the note's properties
     */
    @Override
    public String toString() {
        return "Note{" +
                "pitch='" + pitch + '\'' +
                ", modifier='" + modifier + '\'' +
                ", Note Type=" + noteType +
                ", tie=" + tie +
                ", articulation='" + articulation + '\'' +
                ", octave=" + octave +
                ", timeSignature='" + timeSignature + '\'' +
                '}';
    }
}
