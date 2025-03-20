package com.model;

/**
 * Enum representing different types of musical notes and rests. 
 * This enum includes standard note values (e.g., quarter note, half note)
 * and corresponding rest values (e.g., quarter rest, half rest).
 */
public enum Notetype { 
    
    /**
     * Represents a sixteenth note (1/16 of a whole note).
     */
    SIXTEENTH_NOTE,
    
    /**
     * Represents an eighth note (1/8 of a whole note).
     */
    EIGHTH_NOTE,

    DOTTED_EIGHTH_NOTE,
    
    /**
     * Represents a quarter note (1/4 of a whole note).
     */
    QUARTER_NOTE,
    
    /**
     * Represents a half note (1/2 of a whole note).
     */
    HALF_NOTE,
    
    /**
     * Represents a whole note (the full duration of a measure).
     */
    WHOLE_NOTE,
    
    /**
     * Represents a whole rest (a rest for the full duration of a measure).
     */
    WHOLE_REST,
    
    /**
     * Represents a half rest (a rest for half the duration of a measure).
     */
    HALF_REST,
    
    /**
     * Represents a quarter rest (a rest for one-quarter the duration of a measure).
     */
    QUARTER_REST;
}

