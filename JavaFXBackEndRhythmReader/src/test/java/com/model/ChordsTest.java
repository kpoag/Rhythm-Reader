package com.model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 * Test for Note methods
 * 
 * @author Jaylen
 */

public class ChordsTest {
     private Note createNote(String noteStr) {
        return Note.fromString(noteStr);
    }

    
    @Test
    public void isChord_testEmptyChord() {
        List<Note> emptyNotes = new ArrayList<>();
        // Creating a chord with no notes.
        Chords chord = new Chords(emptyNotes, "", "", Notetype.QUARTER_NOTE, false);
        assertFalse("Empty chord should not be considered a chord", chord.isChord());
    }

    
    @Test
    public void isChord_testSingleNoteChord() {
        List<Note> singleNote = new ArrayList<>();
        singleNote.add(createNote("C4"));
        Chords chord = new Chords(singleNote, "C", "major", Notetype.QUARTER_NOTE, false);
        assertFalse("A single note should not be considered a chord", chord.isChord());
    }

    
    @Test
    public void isChord_testTwoNoteChord() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(createNote("E4"));
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        assertTrue("Two notes should be considered a chord", chord.isChord());
    }

    
    @Test
    public void isChord_testThreeNoteChord() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(createNote("E4"));
        notes.add(createNote("G4"));
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        assertTrue("Three notes should be considered a chord", chord.isChord());
    }

    
    @Test
    public void isChord_testChordWithNullNote() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(null);
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        assertTrue("Chord with a null note should still be considered a chord", chord.isChord());
    }

    @Test
    public void testToJFugueStringEmptyChord() {
        List<Note> emptyNotes = new ArrayList<>();
        Chords chord = new Chords(emptyNotes, "", "", Notetype.QUARTER_NOTE, false);
        String jfugueStr = chord.toJFugueString();
        assertEquals("Empty chord should return empty string", "", jfugueStr);
    }

    
    @Test
    public void testToJFugueStringSingleNote() {
        List<Note> notes = new ArrayList<>();
        Note note = createNote("C4");
        notes.add(note);
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        // Expecting the same output as the note's toJFugueString()
        assertEquals("Single note chord should return note's JFugue string", note.toJFugueString(), chord.toJFugueString());
    }

    @Test
    public void testToJFugueStringMultiNoteQuarterNote() {
        List<Note> notes = new ArrayList<>();
        Note note1 = createNote("C4");
        Note note2 = createNote("E4");
        notes.add(note1);
        notes.add(note2);
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        // Expected output: "C4+E4q"
        String expected = "C4+E4q";
        assertEquals("Multi-note chord with QUARTER_NOTE should return expected string", expected, chord.toJFugueString());
    }

   
    @Test
    public void testToJFugueStringWholeRest() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(createNote("E4"));
        Chords chord = new Chords(notes, "C", "major", Notetype.WHOLE_REST, false);
        assertEquals("Chord with WHOLE_REST should return 'Rw'", "Rw", chord.toJFugueString());
    }

    
    @Test
    public void testToJFugueStringHalfRest() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(createNote("E4"));
        Chords chord = new Chords(notes, "C", "major", Notetype.HALF_REST, false);
        assertEquals("Chord with HALF_REST should return 'Rh'", "Rh", chord.toJFugueString());
    }

    @Test
    public void testFromJSONArray_NullInput() {
        JSONArray jsonArray = null;
        Chords chord = Chords.fromJSONArray(jsonArray);
        assertNotNull("Chord should not be null", chord);
        assertEquals("Expected chord with zero notes", 0, chord.getNotes().size());
        assertEquals("Expected empty root note", "", chord.getRootNote());
        assertEquals("Expected empty chord type", "", chord.getChordType());
        assertEquals("Expected default note type to be QUARTER_NOTE", Notetype.QUARTER_NOTE, chord.getNotetype());
        assertFalse("Chord should not be arpeggiated", chord.isArpeggiated());
    }

    @Test
    public void testFromJSONArray_EmptyInput() {
        JSONArray jsonArray = new JSONArray();
        Chords chord = Chords.fromJSONArray(jsonArray);
        assertNotNull("Chord should not be null", chord);
        assertEquals("Expected chord with zero notes", 0, chord.getNotes().size());
        assertEquals("Expected empty root note", "", chord.getRootNote());
        assertEquals("Expected empty chord type", "", chord.getChordType());
        assertEquals("Expected default note type to be QUARTER_NOTE", Notetype.QUARTER_NOTE, chord.getNotetype());
        assertFalse("Chord should not be arpeggiated", chord.isArpeggiated());
    }

    @Test
    public void testFromJSONArray_SingleValidNote() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("C4");
        Chords chord = Chords.fromJSONArray(jsonArray);
        assertNotNull("Chord should not be null", chord);
        assertEquals("Expected one valid note", 1, chord.getNotes().size());
        assertEquals("Expected root note to be derived from first note", "C", chord.getRootNote());
        assertEquals("Expected chord type to be empty", "", chord.getChordType());
        assertEquals("Expected note type to be QUARTER_NOTE", Notetype.QUARTER_NOTE, chord.getNotetype());
        assertFalse("Chord should not be arpeggiated", chord.isArpeggiated());
    }

    @Test
    public void testFromJSONArray_MultipleValidNotes() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("C4");
        jsonArray.add("E4");
        jsonArray.add("G4");
        Chords chord = Chords.fromJSONArray(jsonArray);
        assertNotNull("Chord should not be null", chord);
        assertEquals("Expected three valid notes", 3, chord.getNotes().size());
        assertEquals("Expected root note to be 'C'", "C", chord.getRootNote());
        assertEquals("Expected chord type to be empty", "", chord.getChordType());
        assertEquals("Expected note type to be QUARTER_NOTE", Notetype.QUARTER_NOTE, chord.getNotetype());
        assertFalse("Chord should not be arpeggiated", chord.isArpeggiated());
    }

    @Test
    public void testFromJSONArray_MixedValidAndInvalidNotes() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("C4");      
        jsonArray.add("invalid"); 
        jsonArray.add("E4");      
        Chords chord = Chords.fromJSONArray(jsonArray);
        assertNotNull("Chord should not be null", chord);
        assertEquals("Expected chord to contain only valid notes", 2, chord.getNotes().size());
        assertEquals("Expected root note to be 'C'", "C", chord.getRootNote());
        assertEquals("Expected chord type to be empty", "", chord.getChordType());
        assertEquals("Expected note type to be QUARTER_NOTE", Notetype.QUARTER_NOTE, chord.getNotetype());
        assertFalse("Chord should not be arpeggiated", chord.isArpeggiated());
    }

    @Test
    public void testToJSONObjectEmptyNotes() {
        List<Note> emptyNotes = new ArrayList<>();
        Chords chord = new Chords(emptyNotes, "C", "major", Notetype.QUARTER_NOTE, false);
        JSONObject json = chord.toJSONObject();

        assertEquals("Root note should be 'C'", "C", json.get("rootNote"));
        assertEquals("Chord type should be 'major'", "major", json.get("chordType"));
        assertEquals("Note type should be QUARTER_NOTE", Notetype.QUARTER_NOTE.toString(), json.get("noteType"));
        assertEquals("isArpeggiated should be false", false, json.get("isArpeggiated"));

        JSONArray notesJson = (JSONArray) json.get("notes");
        assertNotNull("Notes array should not be null", notesJson);
        assertEquals("Expected empty notes array", 0, notesJson.size());
    }

    @Test
    public void testToJSONObjectSingleNote() {
        List<Note> notes = new ArrayList<>();
        Note note = createNote("C4");
        notes.add(note);
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, true);
        JSONObject json = chord.toJSONObject();

        assertEquals("Root note should be 'C'", "C", json.get("rootNote"));
        assertEquals("Chord type should be 'major'", "major", json.get("chordType"));
        assertEquals("Note type should be QUARTER_NOTE", Notetype.QUARTER_NOTE.toString(), json.get("noteType"));
        assertEquals("isArpeggiated should be true", true, json.get("isArpeggiated"));

        JSONArray notesJson = (JSONArray) json.get("notes");
        assertNotNull("Notes array should not be null", notesJson);
        assertEquals("Expected notes array size 1", 1, notesJson.size());

        JSONObject noteJson = (JSONObject) notesJson.get(0);
        assertNotNull("Note JSON should contain a pitch", noteJson.get("pitch"));
    }

    @Test
    public void testToJSONObjectMultipleNotes() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("C4"));
        notes.add(createNote("E4"));
        notes.add(createNote("G4"));
        Chords chord = new Chords(notes, "C", "major", Notetype.QUARTER_NOTE, false);
        JSONObject json = chord.toJSONObject();

        assertEquals("Root note should be 'C'", "C", json.get("rootNote"));
        assertEquals("Chord type should be 'major'", "major", json.get("chordType"));
        assertEquals("Note type should be QUARTER_NOTE", Notetype.QUARTER_NOTE.toString(), json.get("noteType"));
        assertEquals("isArpeggiated should be false", false, json.get("isArpeggiated"));

        JSONArray notesJson = (JSONArray) json.get("notes");
        assertNotNull("Notes array should not be null", notesJson);
        assertEquals("Expected notes array size 3", 3, notesJson.size());
    }

    @Test
    public void testToJSONObjectNoteType() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("D4"));
        Chords chord = new Chords(notes, "D", "minor", Notetype.HALF_NOTE, false);
        JSONObject json = chord.toJSONObject();

        assertEquals("Note type should be HALF_NOTE", Notetype.HALF_NOTE.toString(), json.get("noteType"));
    }
    @Test
    public void testToJSONObjectIsArpeggiated() {
        List<Note> notes = new ArrayList<>();
        notes.add(createNote("F4"));
        Chords chord = new Chords(notes, "F", "major", Notetype.QUARTER_NOTE, true);
        JSONObject json = chord.toJSONObject();

        assertEquals("isArpeggiated should be true", true, json.get("isArpeggiated"));
    }
}
