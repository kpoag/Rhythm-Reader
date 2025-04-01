package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.model.RRFacade;

public class UsersTest {

    @Test
    public void testTesting(){
        assertTrue(true);
    }


    @Test
    public void testValidLogin(){
        DataLoader.loadUsers();
        RRFacade facade = RRFacade.getInstance();
        boolean success = facade.login("johndoe@example.com", "securepassword123");
        assertTrue("Login should be successful", success);
        assertNotNull("Current user should not be null", facade.getCurrentUser());
        assertEquals("John", facade.getCurrentUser().getFirstName());
    }
 }