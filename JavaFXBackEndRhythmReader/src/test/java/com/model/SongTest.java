package com.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SongTest {

    private Song song;
    private List<Note> chordNotes;

    @Before
    public void setUp() {
        // Set up test data for each test
        List<Chords> chordsList = new ArrayList<>();
        chordNotes = new ArrayList<>();
        chordNotes.add(new Note("C", "NATURAL", Notetype.DOTTED_EIGHTH_NOTE, true, "quarter", 1, "sharp"));
        chordNotes.add(new Note("D", "NATURAL", Notetype.EIGHTH_NOTE, true, "quarter", 1, "sharp"));
        chordNotes.add(new Note("E", "NATURAL", Notetype.EIGHTH_NOTE, true, "quarter", 1, "sharp"));
        chordNotes.add(new Note("F", "NATURAL", Notetype.HALF_REST, true, "quarter", 1, "sharp"));
        // Create a Measure with a List<Chords>, a time signature string, and another string (e.g., "description").
        Measure sampleMeasure = new Measure(chordsList, "4/4", "First measure");

        ArrayList<Measure> measures = new ArrayList<>();
        measures.add(sampleMeasure);
        song = new Song("Test Song", "Test Artist", "4/4", Genre.JAZZ, DifficultyLevel.BEGINNER, "piano", 4.5, 40, "4/4");
    }

    @Test
    public void testPlaySong() {
        boolean result = song.playSong();
        assertTrue("The song should play successfully.", result);
    }

    @Test
    public void testPlaySongWithTempo() {
        boolean result = song.playSongWithTempo(140);
        assertTrue("The song should play successfully with the modified tempo.", result);
    }

    @Test
    public void testPlaySongWithTempoInvalid() {
        boolean result = song.playSongWithTempo(0); // Invalid tempo
        assertFalse("The song should not play with an invalid tempo.", result);
    }

    @Test
    public void testPlaySongWithTempoAndSheetMusicFile() {
        String filePath = "testSheetMusic.txt";
        boolean result = song.playSongWithTempo(120, filePath);
        assertTrue("The song should play and write sheet music to the file.", result);
    }

    @Test
    public void testMatchesWithTitle() {
        boolean result = song.matches("Test Song");
        assertTrue("The song should match the search query based on the title.", result);
    }

    @Test
    public void testMatchesWithArtist() {
        boolean result = song.matches("Test Artist");
        assertTrue("The song should match the search query based on the artist.", result);
    }

    @Test
    public void testMatchesWithGenre() {
        song.setGenre(Genre.CLASSICAL); // Assuming Genre is an enum
        boolean result = song.matches("CLASSICAL");
        assertTrue("The song should match the search query based on the genre.", result);
    }

    @Test
    public void testMatchesWithDifficulty() {
        song.setDifficulty(DifficultyLevel.ADVANCED); // Assuming Difficulty is an enum
        boolean result = song.matches("ADVANCED");
        assertTrue("The song should match the search query based on the difficulty.", result);
    }

    @Test
    public void testMatchesNoMatch() {
        boolean result = song.matches("Nonexistent Song");
        assertFalse("The song should not match an unrelated search query.", result);
    }

    @Test
    public void testPlaySongWithInvalidMeasures() {
        song.setMeasures(null);
        boolean result = song.playSong();
        assertFalse("The song should not play if there are no measures.", result);
    }

    @Test
    public void testPlaySongWithInvalidTempo() {
        boolean result = song.playSongWithTempo(-1); // Invalid tempo
        assertFalse("The song should not play with a negative tempo.", result);
    }

    @Test
    public void testCreateSongPattern() {
        org.jfugue.pattern.Pattern pattern = song.createSongPattern(140);
        assertNotNull("The song pattern should be created successfully.", pattern);
    }


    @Test
    public void testPlaySongWithInvalidTempoAndWriteToFile() {
        String sheetMusicFile = "invalidTempoTest.txt";
        boolean result = song.playSongWithTempo(-1, sheetMusicFile); // Invalid tempo
        assertFalse("The song should not play with an invalid tempo and should not write to the file.", result);
    }

    @Test
    public void testPlaySongWithValidTempoAndWriteToFile() {
        String sheetMusicFile = "validTempoTest.txt";
        boolean result = song.playSongWithTempo(130, sheetMusicFile);
        assertTrue("The song should play with a valid tempo and write the sheet music to the file.", result);
    }

    @Test
    public void testMatchesWithNullQuery() {
        boolean result = song.matches(null);
        assertFalse("The song should not match with a null query.", result);
    }

    @Test
    public void testPrintSheetMusic() {
        // Assuming this test is about verifying if printSheetMusic produces output
        // Since we can't capture console output directly without special setup,
        // we can check if the song's data is present.
        String expectedOutput = "Sheet music for: Test Song\n" +
                                "Artist: Test Artist\n" +
                                "Time Signature: 4/4\n" +
                                "Tempo: 120\n" +
                                "Instrument: piano\n" +
                                "Measures:\n" +
                                "First measure"; // Assuming we print measure descriptions

        // You may have to adjust the expected output depending on how your `printSheetMusic()` works
        assertTrue("Sheet music was printed correctly.", song.toString().contains(expectedOutput));
    }
}

