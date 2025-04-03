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
import org.junit.BeforeClass;
import org.junit.Test;


public class TeacherUserTest {

    private TeacherUser teacherUser;
    private StudentUser student1;
    private StudentUser student2;
    private StudentUser student3;


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
        ArrayList<String> teachingClasses = new ArrayList<>();
        teachingClasses.add("Music Theory 101");
        teachingClasses.add("Advanced Composition");
        
        Map<String, ArrayList<Map<String, String>>> gradebook = new HashMap<>();
        
        // Initialize the gradebook with empty student lists for each class
        for (String classCode : teachingClasses) {
            gradebook.put(classCode, new ArrayList<>());
        }
        
          teacherUser = new TeacherUser(userName, firstName, lastName, email, 
                                     password, points, badges, friends, 
                                     teachingClasses, gradebook, students);
        
        // Create test students
        ArrayList<String> emptyClasses1 = new ArrayList<>();
        ArrayList<String> emptyClasses2 = new ArrayList<>();

        ArrayList<String> emptyBadges = new ArrayList<>();
        ArrayList<String> emptyFriends = new ArrayList<>();
        ArrayList<String> emptyFlashcards = new ArrayList<>();
        Map<String, String> emptyDeadlines = new HashMap<>();
        ArrayList<String> emptyAssignedFlashcards = new ArrayList<>();
        
        student1 = new StudentUser("studentUser", "John", "D", "student1@example.com", "pass1",
                                 0, emptyBadges, emptyFriends, 0, 0, emptyClasses1,
                                 "Beginner", emptyFlashcards, null, emptyDeadlines, emptyAssignedFlashcards);
        
        student2 = new StudentUser("student", "Jane", "Smith", "student2@example.com", "pass2",
                                 0, emptyBadges, emptyFriends, 0, 0, emptyClasses2,
                                 "Beginner", emptyFlashcards, null, emptyDeadlines, emptyAssignedFlashcards);

       
        // Add students to teacher
        teacherUser.addStudent(student1);
        teacherUser.addStudent(student2);

        System.out.println("Teacher has " + teacherUser.getStudents().size() + " students after setup");

    }

    @Test 
    public void testAddStudent() {
        ArrayList<String> emptyClasses = new ArrayList<>();
        ArrayList<String> emptyBadges = new ArrayList<>();
        ArrayList<String> emptyFriends = new ArrayList<>();
        ArrayList<String> emptyFlashcards = new ArrayList<>();
        Map<String, String> emptyDeadlines = new HashMap<>();
        ArrayList<String> emptyAssignedFlashcards = new ArrayList<>();
        
        student3 = new StudentUser("person", "New", "Student", "student3@example.com", "pass3",
        0, emptyBadges, emptyFriends, 0, 0, emptyClasses,
        "Beginner", emptyFlashcards, null, emptyDeadlines, emptyAssignedFlashcards);

        boolean result = teacherUser.addStudent(student3);
        System.out.println(result);


        assertTrue(result);
        assertTrue(teacherUser.getStudents().contains(student3));
        System.out.println(teacherUser.getStudents().size());
        System.out.println("Student3 classes: " + student3.getClasses());
        System.out.println("Teacher's students contains student3: " + teacherUser.getStudents().contains(student3));
        assertEquals(3, teacherUser.getStudents().size());

    }

    @Test
    public void testAddStudent_NoClasses() {

        TeacherUser teacherWithNoClasses = new TeacherUser("noClassTeacher", "No", "Classes", "noclasses@example.com", 
            "password", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new HashMap<>(), new ArrayList<>());

            StudentUser newStudent = StudentUser.createStudentUser("student4", "Another", "Student",
                "anotherstudent@example.com", "password456");
                boolean result = teacherWithNoClasses.addStudent(newStudent);
        assertFalse("Should fail to add student since teacher does not have a class", result);
    }

    @Test
    public void testAddStudent_AlreadyEnrolled() {
        boolean result = teacherUser.addStudent(student1);

        assertFalse("Should fail to add student who is already enrolled in all classes", result);
    }

    @Test
    public void testSendFeedback() {
        String feedback = "Great job!";
        String result = teacherUser.sendFeedback(student1, feedback);

        assertTrue("Feedback should have student's name", result.contains(student1.getFirstName()) && result.contains(student1.getLastName()));
        assertTrue("Feedback should have the message", result.contains(feedback));
    }
    @Test
    public void testSendFeedback_StudentNotInClass() {
        StudentUser outsideStudent = new StudentUser("outside", "Outside", "Student", "outside@example.com", "pass", 0, null, null, 0, 0, null, null, null, null, null, null);
        String result = teacherUser.sendFeedback(outsideStudent, "Good job!");
        assertTrue("Should return error for student not in class", result.startsWith("Error"));
    }
    @Test
    public void testSendFeedback_nullStudent() {
        String result = teacherUser.sendFeedback(null, "Good job!");
        assertTrue("Should return error for null student", result.startsWith("Error"));
    }
    @Test
    public void testSendFeedback_nullFeedback() {
        String result = teacherUser.sendFeedback(student1, null);
        assertTrue("Should return error for null feedback", result.startsWith("Error"));
    }

     @Test
    public void testCreateClassroom() {
        String className = "Piano Basics";
        String classCode = teacherUser.createClassroom(className);
        
        assertNotNull("Should return a valid class code", classCode);
        assertTrue("Teaching classes should contain new class", teacherUser.getTeachingClasses().contains(className));
        assertTrue("Gradebook should have entry for new class", teacherUser.getGradebook().containsKey(className));
    }
    @Test
    public void testCreateClassroom_NullClassName() {
        assertNull("Should return null for null class name", teacherUser.createClassroom(null));
    }
    @Test
    public void testCreateClassroom_DuplicateClassName() {
        assertNull("Should return null for duplicate class name", teacherUser.createClassroom("Music Theory 101"));
    }

    @Test
    public void testRemoveStudent() {
        boolean result = teacherUser.removeStudent(student1);
    
        assertTrue("Should successfully remove student", result);
        assertFalse("Student list should no longer contain removed student", 
                teacherUser.getStudents().contains(student1));
        assertEquals("Should have one student remaining", 1, teacherUser.getStudents().size());
    
        // Verify student was removed from classes
        for (String classCode : teacherUser.getTeachingClasses()) {
            assertFalse("Student should be removed from " + classCode, 
                   student1.getClasses().contains(classCode));
        }
    
        // Verify student was removed from gradebook
        for (String classCode : teacherUser.getTeachingClasses()) {
            ArrayList<Map<String, String>> classRecords = teacherUser.getGradebook().get(classCode);
            boolean foundInGradebook = false;
            for (Map<String, String> record : classRecords) {
                if (record.get("First Name").equals(student1.getFirstName()) && 
                    record.get("Last Name").equals(student1.getLastName())) {
                    foundInGradebook = true;
                    break;
                }
            }
            assertFalse("Student record should be removed from gradebook for " + classCode, 
                   foundInGradebook);
        }
    }   
    @Test
    public void testRemoveStudent_NullStudent() {
        boolean result = teacherUser.removeStudent(null);
        assertFalse("Should fail to remove null student", result);
        assertEquals("Number of students should remain unchanged", 2, teacherUser.getStudents().size());
    }

}