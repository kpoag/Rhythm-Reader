package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for Settings methods
 * 
 * @author Rondasha
 */
public class SettingsTest {
    private Settings settings;

    @Before
    public void setUp() {
        settings = new Settings(1, "John Doe", "Classic", "Bio information", "Blue", "English", new ArrayList<>(Arrays.asList("Sports", "News")));
    }

    @Test
    public void testSetProfilePicture() {
        assertEquals("Profile picture set.", settings.setProfilePicture());
    }

    @Test
    public void testAddProfileBio() {
        assertEquals("Profile bio updated.", settings.addProfileBio("New Bio"));
    }

    @Test
    public void testGetExperienceLevel() {
        assertEquals(1, settings.getExperienceLevel());
    }

    @Test
    public void testSetThemeColor() {
        assertTrue(settings.setThemeColor("Red"));
        assertFalse(settings.setThemeColor(null));
    }

    @Test
    public void testFilterContent() {
        List<String> newFilters = Arrays.asList("Technology", "Music");
        assertEquals("Content filtered.", settings.filterContent(newFilters));
    }

    @Test
    public void testResetAccount() {
        assertEquals("Account reset.", settings.resetAccount());
    }

    @Test
    public void testDeleteAccount() {
        assertEquals("Account deleted.", settings.deleteAccount("correctPassword"));
        assertEquals("Incorrect password.", settings.deleteAccount("wrongPassword"));
    }

    @Test
    public void testDarkMode() {
        assertTrue(settings.darkMode(true));
        assertFalse(settings.darkMode(false));
    }
}

