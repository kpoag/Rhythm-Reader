package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TeacherUserTest {

    private TeacherUser teacherUser;
    private StudentUser student1;
    private StudentUser student2;

     @Before
    public void setUp() {
        // Create a teacher user for testing
        String userName = "testTeacher";
        String firstName = "Test";
        String lastName = "Teacher";
        String email = "teacher@example.com";
        String password = "securePassword123";
        
        int points = 100;
        ArrayList<String> badges = new ArrayList<>();
        badges.add("Experienced Teacher");
        ArrayList<String> friends = new ArrayList<>();
        friends.add("otherTeacher1");
        
        ArrayList<StudentUser> students = new ArrayList<>();
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Music Theory 101");
        courses.add("Advanced Composition");
        
        Map<String, String> assignments = new HashMap<>();
        assignments.put("Assignment1", "Due in 1 week");
        
        teacherUser = new TeacherUser(userName, firstName, lastName, email, 
                                     password, points, badges, friends, 
                                     students, courses, assignments);
        
        // Create test students
        student1 = StudentUser.createStudentUser("student1", "John", "Doe", "student1@example.com", "pass1");
        student2 = StudentUser.createStudentUser("student2", "Jane", "Smith", "student2@example.com", "pass2");
        
        // Add students to teacher
        teacherUser.addStudent(student1);
        teacherUser.addStudent(student2);
    }

    @Test 
    public void testAddStudent() {
        StudentUser newStudent = StudentUser.createStudentUser("student3", "New", "Student", "student@example.com", "password123");
        boolean result = teacherUser.addStudent(newStudent);

        assertTrue(result);
        assertTrue(teacherUser.getStudents().contains(newStudent));
        assertEquals(3, teacherUser.getStudents().size());


    }
    
}
