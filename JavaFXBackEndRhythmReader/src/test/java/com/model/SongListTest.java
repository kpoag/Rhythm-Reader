package com.model;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static com.model.SongList.getInstance;
/**
 * Test for SongList methods
 * 
 * @author Rondasha
 */
public class SongListTest {

    @Test
    public void testAddSong() {
        // Create SongList instance
        SongList songList = SongList.getInstance();

        // Create a Song with correct parameters
        Song song = new Song("Song Name", "Artist Name", "Album Name", Genre.COUNTRY, DifficultyLevel.ADVANCED, "Description", 4.5, 180, "path/to/song");

        // Add the song
        final boolean isAdded = songList.addSong(song);

        // Assert the song was added successfully
        assertTrue(isAdded);
    }

    @Test
    public void testFilterByGenre() {
        // Create SongList instance
        SongList songList = getInstance();
        
        // Create songs and add them
        songList.addSong(new Song("Song 2", "Artist B", "Album B", Genre.CLASSICAL, DifficultyLevel.BEGINNER, "Description", 110.0, 4, "path2"));

        // Filter by genre
        ArrayList<Song> filteredSongs = songList.filterByGenre("ROCK");

        // Assert the filtered list contains the correct song
        assertEquals(1, filteredSongs.size());
        assertEquals("ROCK", filteredSongs.get(0).getGenre().toString());
    }

    @Test
    public void testSave() {
        // Create SongList instance
        SongList songList = SongList.getInstance();

        // Test save functionality
        boolean isSaved = songList.save();

        // Assert save is successful
        assertTrue(isSaved);
    }

    @Test
    public void testSaveSongs() {
        // Create SongList instance
        SongList songList = SongList.getInstance();

        // Test saving songs
        boolean isSaved = songList.saveSongs();

        // Assert saveSongs is successful
        assertTrue(isSaved);
    }
}
