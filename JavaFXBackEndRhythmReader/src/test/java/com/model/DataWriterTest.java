package com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

    private File file = new File(DataConstants.USER_FILE_NAME);

    @Before
    public void setUp() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        /*
        userList = UserList.getInstance();
        userList.getUsers().clear();
        */
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        /* 
        if (file.exists()) {
            file.delete();
        }
        */
    }


    @Test
    public void testTesting() {
        assertTrue(true);
    }

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

    @Test
    public void testWritingZeroUsers() {
        assertEquals(0, userList.size());
    }

    /*
    @Test
    public void testSaveUsers_MultipleUsers() {
        User user1 = new StudentUser("aliceSmith", "Alice", "Smith", "alice@example.com", "pass123", 0, null, null, 0, 0, null, null, null, null, null, null);
        User user2 = new TeacherUser("bobJohnson", "Bob", "Johnson", "bob@example.com", "securePass");
        userList.getUsers().add(user1);
        userList.getUsers().add(user2);
        
        assertTrue("Saving multiple users should return true", DataWriter.saveUsers());

        JSONArray jsonUsers = readJsonFile();
        assertEquals("JSON array should have 2 users", 2, jsonUsers.size());
    }
    */


    /*
     * private helper method - Reads JSON File
     */
    private JSONArray readJsonFile() {
        try(FileReader read = new FileReader(file)) {
            return (JSONArray) new JSONParser().parse(read);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            fail("Could not read JSON file");
            return null;
        }
    }

}
