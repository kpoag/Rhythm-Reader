package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for dataLoader 
 * 
 * @author Jaylen
 */

public class DataLoaderTest {
	 //private static final String TEST_USER_FILE_NAME = "JavaFXBackEndRhythmReader/src/test/java/com/data/users.json";
     
     private UserList users = UserList.getInstance();
     private ArrayList<User> userList = users.getUsers();

     private SongList songs = SongList.getInstance();
     private ArrayList<Song> songList = songs.getSongs();

     private FlashcardList flashcards = FlashcardList.getInstance();
     private ArrayList<Flashcard> flashcardList = flashcards.getFlashcards();
     
     @Before
     public void LoadUsers_setup() {
         userList.clear();
         userList.add(new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "princessdiana@gmail.com", "Ilov3Dogs", 25, new ArrayList<>(), new ArrayList<>()));
         userList.add(new User(UUID.randomUUID(), "bwhite", "bob", "White", "bobbybrown@gmail.com", "Ilov3atss", 20000, new ArrayList<>(), new ArrayList<>()));
         DataWriter.saveUsers();
     }
     
     @After
     public void LoadUsers_tearDown() {
         UserList.getInstance().getUsers().clear();
         DataWriter.saveUsers();
     }
     
     
     @Test
     public void LoadUsers_testGetUsersSize() {
         userList = users.getUsers();
         assertEquals(2, userList.size());
     }
 
     @Test
     public void LoadUsers_testGetUsersSizeZero() {
         UserList.getInstance().getUsers().clear();
         DataWriter.saveUsers();
         assertEquals(0, userList.size());
     }
     
     @Test
     public void LoadUsers_testGetUserFirstUserName() {
         userList = users.getUsers();
         assertEquals("asmith", userList.get(0).getUserName());
     }

     @Before
     public void LoadFlashcards_setup() {
         flashcardList.clear();
         flashcardList.add(new Flashcard("123123","Question", "Answer", "key_signature.png", "Notes", "Beginner"));
         flashcardList.add(new Flashcard("123456","Question", "Answer", "key_signature.png", "Chords", "Hard"));
         DataWriter.saveFlashcards();
     }

     @After
     public void LoadFlashcards_tearDown() {
         FlashcardList.getInstance().getFlashcards().clear();
         DataWriter.saveFlashcards();
     }

     @Test
     public void LoadFlashcards_testGetFlashcardsSize() {
         flashcardList = flashcards.getFlashcards();
         assertEquals(2, flashcardList.size());
     }

     @Test
     public void LoadFlashcards_testGetFlashcardsSizeZero() {
         FlashcardList.getInstance().getFlashcards().clear();
         DataWriter.saveFlashcards();
         assertEquals(0, flashcardList.size());
     }

     @Test
     public void LoadFlashcards_testGetFirstFlashcardFrontText() {
         flashcardList = flashcards.getFlashcards();
         assertEquals("Question", flashcardList.get(0).getFrontText());
     }

     @Before
     public void LoadSongs_setup() {
         songList.clear();
         songList.add(new Song("123321", "cats", "him", Genre.JAZZ, DifficultyLevel.ADVANCED, "piano", 5.0, 4, "4/4"));
         songList.add(new Song("1234556", "dogs", "her", Genre.JAZZ, DifficultyLevel.BEGINNER, "guitar", 4.0, 4, "3/4"));
         DataWriter.saveSongs();
     }

     @After
     public void LoadSongs_tearDown() {
         SongList.getInstance().getSongs().clear();
         DataWriter.saveSongs();
     }

     @Test
     public void LoadSongs_testGetSongsSize() {
         songList = songs.getSongs();
         assertEquals(2, songList.size());
     }

     @Test
     public void LoadSongs_testGetSongsSizeZero() {
         SongList.getInstance().getSongs().clear();
         DataWriter.saveSongs();
         assertEquals(0, songList.size());
     }

     @Test
     public void LoadSongs_testGetFirstSongsTitle() {
         songList = songs.getSongs();
         assertEquals("cats", songList.get(0).getSongTitle());
     }

     

}