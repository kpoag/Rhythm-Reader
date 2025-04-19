package com.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for User-related functionality in the RhythmReader application.
 * Tests user account creation, login, and validation of user inputs.
 */
public class UserTest {

    private RRFacade facade;

     /**
     * Sets up the test environment before each test.
     * Resets the RRFacade and UserList singletons to ensure tests are isolated.
     */
    @Before
    public void setUp() {
        // Reset the RRFacade singleton for each test
        if (RRFacade.getInstance() != null) {
            try {
                java.lang.reflect.Field instance = RRFacade.class.getDeclaredField("facade");
                instance.setAccessible(true);
                instance.set(null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // Reset the UserList singleton for each test
        if (UserList.getInstance() != null) {
            try {
                java.lang.reflect.Field instance = UserList.class.getDeclaredField("instance");
                instance.setAccessible(true);
                instance.set(null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        facade = RRFacade.getInstance();
    }

    /**
     * Tests that a user can successfully log in with valid credentials.
     * Creates an account and then attempts to log in with the correct email and password.
     */
    @Test
    public void testValidLogin(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("Jpear", "jane", "pear", "jpear@example.com", "password123", true);
        
        assertTrue("Regular account creation should be successful", accountCreated);

        boolean success = facade.login("jpear@example.com", "password123");  
        
        assertTrue("Login should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("jane", facade.getCurrentUser().getFirstName());
    }
    
    /**
     * Tests that login fails when incorrect credentials are provided.
     * Creates an account and then attempts to log in with an incorrect password.
     */
    @Test
    public void testInvalidLogin(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("Lsmith", "Lauren", "smith", "lsmith@example.com", "password123", true);
        
        assertTrue("Regular account creation should be successful", accountCreated);

        boolean loginUnsuccessful = facade.login("lsmith@example.com", "wrongpassword");  
        
        assertFalse("Login should be unsuccessful", loginUnsuccessful);
        Assert.assertNotNull("Current user should  be null after failed login", facade.getCurrentUser());
    }

    /**
     * Tests the creation of a regular user account.
     * Verifies that the account is created successfully and the user is logged in.
     */
    @Test
    public void testCreateRegularAccount(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("kpoag", "kennedy", "poag", "kpoag@gmail.com", "password123", true);
        
        assertTrue("Regular account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("kennedy", facade.getCurrentUser().getFirstName());
        assertEquals("kpoag@gmail.com", facade.getCurrentUser().getEmail());
    }

     /**
     * Tests the creation of a student user account.
     * Verifies that the account is created successfully and the user is logged in.
     */
    @Test
    public void testCreateStudentAccount(){
        String Input = "2";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("tStudent", "test", "student", "tStudent@gmail.com", "password123", true);
        
        assertTrue("Student account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("test", facade.getCurrentUser().getFirstName());
        assertEquals("tStudent@gmail.com", facade.getCurrentUser().getEmail());
    }

     /**
     * Tests the creation of a teacher user account.
     * Verifies that the account is created successfully and the user is logged in.
     */
    @Test
    public void testCreateTeacherAccount(){
        String Input = "3";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("tTeacher", "test", "teacher", "tTeacher@gmail.com", "password123", true);
        
        assertTrue("Regular account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("test", facade.getCurrentUser().getFirstName());
        assertEquals("tTeacher@gmail.com", facade.getCurrentUser().getEmail());
    }

    /**
     * Tests that account creation fails when an invalid email format is provided.
     * Attempts to create an account with an email that doesn't match the regex
     * pattern.
     */
    @Test
    public void testCreateAccountInvalidEmailRegex() {
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean emptyEmailAccount = facade.createAccount("rPerson", "random", "person", "random.com", "password123", true);
        
        assertFalse("Account creation with empty email should fail", emptyEmailAccount);
    }


    /**
     * Tests that account creation fails when an invalid account type is selected.
     */
    @Test
    public void testInvalidAccountType() {
        String Input = "97";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("invalidAccount", "Invalid", "Account", "invalid@gmail.com", "password123", true);
  
        assertFalse("Account creation with invalid type should fail", accountCreated);
        Assert.assertNull("Current user should be null after failed account creation", facade.getCurrentUser());
    }

    /**
     * Tests that account creation fails when attempting to create an account with a username
     * that already exists in the system.
     */
    @Test
    public void testCreateAccountUserExists() {
        String input1 = "1";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());            
        Scanner scanner1 = new Scanner(in1);      

        boolean firstAccountCreated = facade.createAccount( "testUser", "Test", "User", "testuser@example.com", "password123", true);
    
        assertTrue("First account creation should be successful", firstAccountCreated);

        // Test Case 1: Try to create another account with the same username
        String input2 = "1";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());            
        Scanner scanner2 = new Scanner(in2);
    
        boolean duplicateUsernameAccount = facade.createAccount("testUser","Different", "Person", "different@example.com", "password456", true);
    
        assertFalse("Account creation with duplicate username should fail", duplicateUsernameAccount);
    

    }

}
