package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;

import com.model.*;

public class UserTest {

    private RRFacade facade;

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

    @Test
    public void testTesting()
    {
        assertTrue(true);
    }

    @Test
    public void testValidLogin(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("Jpear", "jane", "pear", "jpear@example.com", "password123", scanner);
        
        assertTrue("Regular account creation should be successful", accountCreated);

        boolean success = facade.login("jpear@example.com", "password123");  
        
        assertTrue("Login should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("jane", facade.getCurrentUser().getFirstName());
    }
    
    @Test
    public void testInvalidLogin(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("Lsmith", "Lauren", "smith", "lsmith@example.com", "password123", scanner);
        
        assertTrue("Regular account creation should be successful", accountCreated);

        boolean loginUnsuccessful = facade.login("lsmith@example.com", "wrongpassword");  
        
        assertFalse("Login should be unsuccessful", loginUnsuccessful);
        Assert.assertNotNull("Current user should  be null after failed login", facade.getCurrentUser());
    }


    @Test
    public void testCreateRegularAccount(){
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("kpoag", "kennedy", "poag", "kpoag@gmail.com", "password123", scanner);
        
        assertTrue("Regular account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("kennedy", facade.getCurrentUser().getFirstName());
        assertEquals("kpoag@gmail.com", facade.getCurrentUser().getEmail());
    }

    @Test
    public void testCreateStudentAccount(){
        String Input = "2";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("tStudent", "test", "student", "tStudent@gmail.com", "password123", scanner);
        
        assertTrue("Student account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("test", facade.getCurrentUser().getFirstName());
        assertEquals("tStudent@gmail.com", facade.getCurrentUser().getEmail());
    }

    @Test
    public void testCreateTeacherAccount(){
        String Input = "3";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean success = facade.createAccount("tTeacher", "test", "teacher", "tTeacher@gmail.com", "password123", scanner);
        
        assertTrue("Regular account creation should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("test", facade.getCurrentUser().getFirstName());
        assertEquals("tTeacher@gmail.com", facade.getCurrentUser().getEmail());
    }

    @Test
    // fix
    public void testCreateAccountNoUsername() {
        String Input = "2";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean emptyUsername = facade.createAccount("", "ran", "dom", "rd@gmail.com", "password123", scanner);
        
        assertFalse("Account creation with empty username should fail", emptyUsername);
        
    }

    @Test
    public void testCreateAccountInvalidEmailRegex() {
        String Input = "1";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean emptyEmailAccount = facade.createAccount("rPerson", "random", "person", "random.com", "password123", scanner);
        
        assertFalse("Account creation with empty email should fail", emptyEmailAccount);
    }


    @Test
    public void testCreateAccountNoPassword() {

    }

    @Test
    public void testInvalidAccountType() {
        String Input = "97";
        InputStream in = new ByteArrayInputStream(Input.getBytes());            
        Scanner scanner = new Scanner(in);      

        boolean accountCreated = facade.createAccount("invalidAccount", "Invalid", "Account", "invalid@gmail.com", "password123", scanner);
  
        assertFalse("Account creation with invalid type should fail", accountCreated);
        Assert.assertNull("Current user should be null after failed account creation", facade.getCurrentUser());
    }

    @Test
    public void testDuplicateCreateAccount() {

    }
}
