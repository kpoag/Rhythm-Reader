package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for StudentUser.
 */
public class StudentUserTest {

    private StudentUser student;
    private ArrayList<String> classes;
    private ArrayList<String> badges;
    private ArrayList<String> friends;
    private ArrayList<String> flashcards;
    private Map<String, String> deadlines;
    private ArrayList<String> assignedFlashcards;

     /**
     * Sets up the test environment before each test execution.
     * Creates a student user with predefined attributes for testing.
     */
    @Before
    public void setUp(){
        classes = new ArrayList<>();
        classes.add("Music Theory 101");

        badges = new ArrayList<>();
        badges.add("Beginner");

        friends = new ArrayList<>();
        friends.add("friendUser1");
        
        flashcards = new ArrayList<>();
        flashcards.add("flashcard1");
        
        deadlines = new HashMap<>();
        deadlines.put("Assignment 1", "2023-12-15");
        
        assignedFlashcards = new ArrayList<>();
        assignedFlashcards.add("assignedCard1");

        student = new StudentUser("testStudent", "Test", "Student", "test.student@example.com", "password123", 50, badges, friends, 75.5, 85.0, classes, "Intermediate", flashcards, null, deadlines, assignedFlashcards);

    }

    /**
     * Tests that valid progress values (0.0, 50.5, 100.0) are accepted
     * and correctly set in the student object.
     */
     @Test
    public void testValidProgressBoundaries() {
        assertTrue(student.setProgress(0.0));
        assertEquals(0.0, student.getProgress(), 0.001);
        
        assertTrue(student.setProgress(50.5));
        assertEquals(50.5, student.getProgress(), 0.001);
        
        assertTrue(student.setProgress(100.0));
        assertEquals(100.0, student.getProgress(), 0.001);
    }

     /**
     * Tests the findTeacherByClassCode method to ensure it correctly
     * finds teachers based on class codes.
     */
    @Test
    public void testFindTeacherByClassCode() {
    // Create multiple teachers
    TeacherUser teacher1 = new TeacherUser(
        "teacher1", "First", "Teacher", "teacher1@example.com", "password", 
        0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>(), new ArrayList<>());
    
    TeacherUser teacher2 = new TeacherUser(
        "teacher2", "Second", "Teacher", "teacher2@example.com", "password", 
        0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>(), new ArrayList<>());
    
    // Create classes for each teacher
    String class1 = "Music Theory";
    String class2 = "Piano Basics";
    
    String code1 = teacher1.createClassroom(class1);
    String code2 = teacher2.createClassroom(class2);
    
    // Create a list of teachers
    UserList userList = UserList.getInstance();
    userList.addUser(teacher1);
    userList.addUser(teacher2);
    
    // Test finding teacher by class code
    TeacherUser foundTeacher1 = student.findTeacherByClassCode(code1);
    TeacherUser foundTeacher2 = student.findTeacherByClassCode(code2);
        
    assertEquals("Should find the correct teacher for code1", teacher1, foundTeacher1);
    assertEquals("Should find the correct teacher for code2", teacher2, foundTeacher2);
    }

     /**
     * Tests that findTeacherByClassCode returns null when given an invalid class code.
     */
    @Test
    public void testFindTeacherByClassCode_InvalidCode() {
        TeacherUser teacher1 = new TeacherUser(
            "teacher1", "First", "Teacher", "teacher1@example.com", "password", 
            0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>(), new ArrayList<>());
    
        TeacherUser teacher2 = new TeacherUser(
            "teacher2", "Second", "Teacher", "teacher2@example.com", "password", 
            0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>(), new ArrayList<>());
    
        // Create classes for each teacher
        String class1 = "Music Theory";
        String class2 = "Piano Basics";
    
        String code1 = teacher1.createClassroom(class1);
        String code2 = teacher2.createClassroom(class2);
    
        // Create a list of teachers
        ArrayList<TeacherUser> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        TeacherUser notFound = student.findTeacherByClassCode("INVALID-CODE");
        assertNull("Should return null for invalid code", notFound);
    }

    /**
     * Tests that invalid progress values (negative or greater than 100)
     * are rejected and the original progress value remains unchanged.
     */
    @Test
    public void testInvalidProgressBoundaries() {
        student.setProgress(75.5); 
    
        assertFalse(student.setProgress(-0.1));
        assertEquals(75.5, student.getProgress(), 0.001);
        
        assertFalse(student.setProgress(100.1));
        assertEquals(75.5, student.getProgress(), 0.001);
    }
}