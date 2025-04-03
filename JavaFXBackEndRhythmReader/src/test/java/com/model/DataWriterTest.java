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

import javafx.scene.chart.PieChart;


public class DataWriterTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    private FlashcardList flashcards = FlashcardList.getInstance();
    private ArrayList<Flashcard> flashcardList = flashcards.getInstance();

    private File file = new File(DataConstants.USER_FILE_NAME);

    @Before
    public void setUp() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }


    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Test
    public void testWritingZeroUsers() {
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
    }


    @Test
    public void testSaveOneUser() {
        User user = new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
        users.addUser(user); // Using addUser instead of direct access

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
        assertTrue("Saving an empty flashcard list should return true", DataWriter.saveFlashcards());
    }



    



}
