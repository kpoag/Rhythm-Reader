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
    public void testWritingOneUser() {
    UserList users = UserList.getInstance();
    
    // Ensure user list is empty before test
    users.getUsers().clear();
    System.out.println("Users before adding: " + users.getUsers().size());

    // Add a new user
    users.addUser("asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>());
    
    System.out.println("Users after adding: " + users.getUsers().size());
    
    // Save users
    assertTrue("Saving users should return true", DataWriter.saveUsers());

    // Reload user list and validate
    users = UserList.getInstance();
    ArrayList<User> loadedUsers = users.getUsers();
    
    System.out.println("Users after reloading: " + loadedUsers.size());
    
    assertFalse("User list should not be empty", loadedUsers.isEmpty());
    assertEquals("asmith", loadedUsers.get(0).getUserName());
}

    /*
    @Test
    public void testWritingOneUser() {
        /*
        userList.add(new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>()));
        DataWriter.saveUsers();
        assertEquals("asmith", DataLoader.loadUsers().get(0).getUserName());
        
        UserList users = UserList.getInstance();
        userList.add(new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>()));

        // Save users
        assertTrue("Saving users should return true", DataWriter.saveUsers());

        // Reload the singleton instance to ensure it reads from file
        UserList newUserList = UserList.getInstance();
        ArrayList<User> loadedUsers = newUserList.getUsers();

        // Ensure at least one user exists after loading
        assertFalse("User list should not be empty after saving and loading", loadedUsers.isEmpty());

        // Validate that the saved user's information matches
        User loadedUser = loadedUsers.get(0);
        assertEquals("asmith", loadedUser.getUserName());
        assertEquals("Amy", loadedUser.getFirstName());
        assertEquals("Smith", loadedUser.getLastName());
        assertEquals("asmith@gmail.com", loadedUser.getEmail());

}
    */


    /*
    @Test
    public void testWritingZeroUsers() {
        assertTrue("Saving an empty user list", DataWriter.saveUsers());
        
        assertTrue("Zero user file exists after saving", file.exists());

        JSONArray jsonUsers = readJsonFile();
        assertNotNull("JSON file shouldn't be null", jsonUsers);
        assertEquals("JSON array should be empty", 0, jsonUsers.size());

    }
    */

    /*
    @Test
    public void WriteToJustOneUser() {
        StudentUser user = new StudentUser("johnDoe", "John", "Doe", "john@gmail.com", "password123", 0, null, null, 0, 0, null, null, null, null, null, null);
        userList.getUsers().add(user);
        assertTrue("Saving a user should return true", DataWriter.saveUsers());

        JSONArray jsonUsers = readJSONFile();
        assertEquals("JSON array should have 1 user", 1, jsonUsers.size());
    }
    */


    /*
    @Test
    public void testSaveUsers_EmptyList() {
        assertFalse("Saving empty user list should return false", DataWriter.saveUsers());
        // assertTrue("User file should exist after saving", file.exists());

        JSONArray jsonUsers = readJsonFile();
        assertNotNull("JSON file should not be null", jsonUsers);
        assertEquals("JSON array should be empty", 0, jsonUsers.size());
    }
    */
    /*
    @Test
    public void writingToOneUser() {
        UserList users = UserList.getInstance();
        userList.add(new User(UUID.randomUUID(), "asmith", "Amy", "Smith", "asmith@gmail.com", "pswd476", 3, new ArrayList<>(), new ArrayList<>()));
        assertTrue("Saving users should return true", DataWriter.saveUsers());
        assertFalse("User list shouldn't be empty", DataLoader.loadUsers().isEmpty());
        assertEquals("asmith", DataLoader.loadUsers().get(0).getUserName());
    }
    */

    
    /*
    @Test
    public void testSaveUsers() {
        userList.add(new User("1", "asmith", "amy", "smith", "asmith@email.com",0, null, null));
        // userList.add(new User("959e734f-e626-476d-a32b-5ae94a799cb4","Fellicia", "Fredrickson", "ffredrickson", "ffredrickson@gmail.com", "securepassword123", 100, null, null));
        assertTrue("Saving multiple users should return true", DataWriter.saveUsers());

        JSONArray jsonUsers = readJsonFile();
        assertEquals("JSON array should have 2 users", 2, jsonUsers.size());
    }
    */

    @Test
    public void testSaveZeroFlashcards() {
        assertTrue("Saving an empty flashcard list should return true", DataWriter.saveFlashcards());

        FlashcardList loadedFlashcards = FlashcardList.getInstance();
        assertEquals("Loaded flashcard list should be empty", 0, loadedFlashcards.getFlashcards().size());
    

    /*
     * private helper method - Reads JSON File
     */
    private JSONArray readJsonFile() {
        try(FileReader read = new FileReader(DataConstants.USER_FILE_NAME)) {
            return (JSONArray) new JSONParser().parse(read);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            fail("Could not read JSON file");
            return null;
        }
    }

}
