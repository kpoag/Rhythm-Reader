package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class MeasureTest {

    private List<Chords> chords;
    private Measure measure;

    @Before
    public void setUp() {
        // Create a list of chords for testing
        chords = new ArrayList<>();
        
        // Create a chord with a quarter note C
        List<Note> notes1 = new ArrayList<>();
        notes1.add(new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4"));
        chords.add(new Chords(notes1, "C", "", Notetype.QUARTER_NOTE, false));
        
         
        // Create a chord with a quarter note E
        List<Note> notes2 = new ArrayList<>();
        notes2.add(new Note("", "E", Notetype.QUARTER_NOTE, false, "", 4, "4/4"));
        chords.add(new Chords(notes2, "E", "", Notetype.QUARTER_NOTE, false));
        
        // Create a chord with a half note G
        List<Note> notes3 = new ArrayList<>();
        notes3.add(new Note("", "G", Notetype.HALF_NOTE, false, "", 4, "4/4"));
        chords.add(new Chords(notes3, "G", "", Notetype.HALF_NOTE, false));
        
        // Create a measure with the chords
        measure = new Measure(chords, "4/4", "mf");
    }

    @Test
    public void testGetExpectedBeats() {
        assertEquals(4.0, measure.getExpectedBeats(), 0.001);

        Measure measure3 = new Measure(chords, "3/4", "mf");
        assertEquals(3.0, measure3.getExpectedBeats(), 0.001);
        
        Measure measure4 = new Measure(chords, "6/8", "mf");
        assertEquals(3.0, measure4.getExpectedBeats(), 0.001);

    }

    @Test
    public void testGetExpectedBeatsInvalidBeats() {
        Measure emptyBeats = new Measure(chords, "", "mf");
        assertEquals(4.0, emptyBeats.getExpectedBeats(), 0.001);

    }

    @Test
    public void testGetExpectedBeatsInvalidTimeSignature() {
        Measure invalidTime = new Measure(chords, "inv/lid", "mf");
        assertEquals(0.0, invalidTime.getExpectedBeats(), 0.001);

    }

    @Test
    public void testGetTotalBeats() {

        assertEquals(4.0, measure.getTotalBeats(), 0.001);

        List<Chords> mixChords = new ArrayList<>();

        List<Note> wholeNote = new  ArrayList<>();
        wholeNote.add(new Note("", "C", Notetype.WHOLE_NOTE, false, "", 4, "4/4"));
        mixChords.add(new Chords(wholeNote, "C", "", Notetype.WHOLE_NOTE, false));

        List<Note> halfNote = new ArrayList<>();
        halfNote.add(new Note("", "D", Notetype.HALF_NOTE, false, "", 4, "4/4"));
        mixChords.add(new Chords(halfNote, "D", "", Notetype.HALF_NOTE, false));

        List<Note> quarterNote = new ArrayList<>();
        quarterNote.add(new Note("", "E", Notetype.QUARTER_NOTE, false, "", 4, "4/4"));
        mixChords.add(new Chords(quarterNote, "E", "", Notetype.QUARTER_NOTE, false));

        List<Note> eighthNote = new ArrayList<>();
        eighthNote.add(new Note("", "F", Notetype.EIGHTH_NOTE, false, "", 4, "4/4"));
        mixChords.add(new Chords(eighthNote, "F", "", Notetype.EIGHTH_NOTE, false));

        List<Note> dottedEighthNote = new ArrayList<>();
        dottedEighthNote.add(new Note("", "E", Notetype.EIGHTH_NOTE, false, "", 4, "4/4"));
        mixChords.add(new Chords(dottedEighthNote, "E", "", Notetype.DOTTED_EIGHTH_NOTE, false));

        Measure mixedMeasure = new Measure(mixChords, "4/4", "mf");
        assertEquals(8.25, mixedMeasure.getTotalBeats(), 0.001); 

    }

    @Test
    public void testGetTotalBeatsWithNullChords() {
        Measure nullChords = new Measure(null, "4/4", "mf");
        assertEquals(0.0, nullChords.getTotalBeats(), 0.001);
    }

    @Test
    public void testGetJFuguePattern() {
        String pattern = measure.getJFuguePattern();

        assertTrue(pattern.contains("TIME:4/4"));
        assertTrue(pattern.contains("mf"));

        List<Chords> chords = new ArrayList<>();

        List<Note> cNote = new ArrayList<>();
        cNote.add(new Note("", "C", Notetype.EIGHTH_NOTE, false, "", 4, "3/4"));
        chords.add(new Chords(cNote, "C", "", Notetype.EIGHTH_NOTE, false));
        
        Measure specificMeasure = new Measure(chords, "3/4", "p");
        String specificPattern = specificMeasure.getJFuguePattern();
        
        assertTrue(specificPattern.contains("TIME:3/4"));
        assertTrue(specificPattern.contains("p"));
        assertTrue(specificPattern.contains("C4i"));
    }

    @Test
    public void testFromJSONWithSingleNote() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse("[\"C4q\"]");
        
        Measure jsonMeasure = Measure.fromJSON(jsonArray, "4/4", "mf");
        
        assertEquals("4/4", jsonMeasure.getBeats());
        assertEquals("mf", jsonMeasure.getDynamics());
        assertEquals(1, jsonMeasure.getChords().size());
        
        Chords chord = jsonMeasure.getChords().get(0);
        assertEquals(1, chord.getNotes().size());
        assertEquals("C", chord.getNotes().get(0).getPitch());
        assertEquals(Notetype.QUARTER_NOTE, chord.getNotes().get(0).getNoteType());
    }

    @Test
    public void testFromJSONWithChord() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse("[[\"C4q\", \"E4q\", \"G4q\"]]");
        
        Measure jsonMeasure = Measure.fromJSON(jsonArray, "4/4", "f");
        
        assertEquals("4/4", jsonMeasure.getBeats());
        assertEquals("f", jsonMeasure.getDynamics());
        assertEquals(1, jsonMeasure.getChords().size());
        
        Chords chord = jsonMeasure.getChords().get(0);
        assertEquals(3, chord.getNotes().size());
        assertEquals("C", chord.getNotes().get(0).getPitch());
        assertEquals("E", chord.getNotes().get(1).getPitch());
        assertEquals("G", chord.getNotes().get(2).getPitch());
        assertEquals(Notetype.QUARTER_NOTE, chord.getNotetype());
    }

    @Test
    public void testFromJSONWithNullInput() {
        Measure jsonMeasure = Measure.fromJSON(null, "4/4", "f");
        
        assertEquals("4/4", jsonMeasure.getBeats());
        assertEquals("f", jsonMeasure.getDynamics());
        assertEquals(0, jsonMeasure.getChords().size());
    }

     @Test
    public void testFromJSONWithInvalidInputType() {
        // Test with a JSONObject instead of a JSONArray
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test", "value");
        
        Measure jsonMeasure = Measure.fromJSON(jsonObject, "4/4", "f");
        
        assertEquals("4/4", jsonMeasure.getBeats());
        assertEquals("f", jsonMeasure.getDynamics());
        assertEquals(0, jsonMeasure.getChords().size());
    }

    @Test
    public void testFromJSONWithEmptyArray() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse("[]");
        
        Measure jsonMeasure = Measure.fromJSON(jsonArray, "4/4", "f");
        
        assertEquals("4/4", jsonMeasure.getBeats());
        assertEquals("f", jsonMeasure.getDynamics());
        assertEquals(0, jsonMeasure.getChords().size());
    }

    
}
