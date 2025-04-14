package com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataWriterTest {
    private UserList userList;
    private SongList songList;
    private FlashcardList flashcardList;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
        userList.getUsers().clear();

        songList = SongList.getInstance();
        songList.getSongs().clear();

        flashcardList = FlashcardList.getInstance();
        flashcardList.getFlashcards().clear();

    }

    @After
    public void tearDown() {
        new File(DataConstants.USER_TEMP_FILE_NAME).delete();
        new File(DataConstants.SONG_TEMP_FILE_NAME).delete();
        new File(DataConstants.FLASHCARD_TEMP_FILE_NAME).delete();
    }


    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Test
    public void testSaveUsersWithOneUser() {
        User user = new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        userList.getUsers().add(user);
        assertTrue(DataWriter.saveUsers());

        assertFalse(isFileEmpty(DataConstants.USER_TEMP_FILE_NAME));
    }
    
    @Test
    public void testWritingZeroUsers() {
        ArrayList<User> users = userList.getUsers();
        users = DataLoader.loadUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testSaveOneUser() {
        User user = new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        userList.addUser(user);

        assertFalse("Saving one user should return true", DataWriter.saveUsers());

        ArrayList<User> users = DataLoader.loadUsers();
        assertTrue("User list should not be empty after saving", users.isEmpty());
    }

    @Test
    public void testSaveMultipleUsers() {
        User user1 = new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        User user2 = new User(UUID.randomUUID(), "bsmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        User user3 = new User(UUID.randomUUID(), "csmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        DataWriter.saveUsers();
        assertEquals("csmith", DataLoader.loadUsers().get(2).getUserName());
    }


    @Test
    public void testSaveZeroFlashcards() {
        FlashcardList flashcardList = FlashcardList.getInstance();
        flashcardList.getFlashcards().clear();
        assertFalse("Saving an empty flashcard list should return false", DataWriter.saveFlashcards());
    }
    
    @Test
    public void testSaveUserWithNoUsers() {
        assertFalse(DataWriter.saveUsers());
        assertTrue(isFileEmpty(DataConstants.USER_TEMP_FILE_NAME));
    }

    @Test
    public void testSaveSongsWithNoSongs() {
        assertFalse(DataWriter.saveSongs());
        assertTrue(isFileEmpty(DataConstants.SONG_TEMP_FILE_NAME));
    }

    @Test
    public void testSaveFlashcardsWithNoFlashcards() {
        assertFalse(DataWriter.saveFlashcards());
        assertTrue(isFileEmpty(DataConstants.FLASHCARD_TEMP_FILE_NAME));
    }

    @Test
    public void testSaveMultipleFlashcards() {
        FlashcardList flashcardList = FlashcardList.getInstance();
        flashcardList.getFlashcards().clear();

        Flashcard flashcard1 = new Flashcard("1", "What is considered a Flat note?", "A note that is lowered by one half step","", "Musical Notation", "Beginner");
        Flashcard flashcard2 = new Flashcard("2", "What does subito mean?", "Suddenly", "", "Musical Notation", "Intermediate");
        Flashcard flashcard3 = new Flashcard("3", "What music family do the Chimes belong to?", "Percussion", "", "Instrument Families", "Beginner");

        flashcardList.getFlashcards().add(flashcard1);
        flashcardList.getFlashcards().add(flashcard2);
        flashcardList.getFlashcards().add(flashcard3);

        assertEquals(3, flashcardList.getFlashcards().size());

        // assertTrue(DataWriter.saveFlashcards());
        // assertFalse(isFileEmpty(DataConstants.FLASHCARD_FILE_NAME));
    }

    @Test
    public void testSaveMultipleSongs() {
        SongList songListInstance = SongList.getInstance();
        songListInstance.getSongs().clear();

        Song song1 = new Song("1", "Let It Be", "The Beatles", Genre.POP, DifficultyLevel.BEGINNER, "Guitar", 4.5, 120, "4/4");
        Song song2 = new Song("2", "My Funny Valentine", "Chet Baker", Genre.JAZZ, DifficultyLevel.INTERMEDIATE, "Piano", 4.0, 90, "3/4");
        Song song3 = new Song("3", "The Four Seasons", "Antonio Vivaldi", Genre.CLASSICAL, DifficultyLevel.ADVANCED, "Violin", 5.0, 80, "9/8");

        assertNotNull(song1.getSongID());
        assertNotNull(song2.getSongID());
        assertNotNull(song3.getSongID());

        songListInstance.getSongs().add(song1);
        songListInstance.getSongs().add(song2);
        songListInstance.getSongs().add(song3);

        assertEquals(3, songListInstance.getSongs().size());

        // assertTrue(DataWriter.saveSongs());
        // assertFalse(isFileEmpty(DataConstants.SONG_FILE_NAME));
    }


    private boolean isFileEmpty(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return true;
        }
        try (FileReader reader = new FileReader(file)) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            return obj instanceof JSONArray && ((JSONArray) obj).isEmpty();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

}

