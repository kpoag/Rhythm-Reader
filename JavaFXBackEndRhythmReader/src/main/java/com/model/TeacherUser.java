package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a teacher user in the system.
 * This class extends the User class and includes teacher-specific functionalities such as managing teaching classes,
 * maintaining a gradebook, adding or removing students, sending feedback, and creating classrooms.
 */
public class TeacherUser extends User {

    private ArrayList<String> teachingClasses;
    private Map<String, ArrayList<Map<String, String>>> gradebook;
    private ArrayList<StudentUser> students;

    /**
     * Constructs a new TeacherUser with the specified parameters.
     *
     * @param userName        the username of the teacher.
     * @param firstName       the teacher's first name.
     * @param lastName        the teacher's last name.
     * @param email           the teacher's email address.
     * @param password        the teacher's password.
     * @param points          the initial points for the teacher.
     * @param badges          a list of badges earned by the teacher.
     * @param friends         a list of the teacher's friends.
     * @param teachingClasses an ArrayList of classes the teacher is teaching.
     * @param gradebook       a Map mapping class codes to lists of student records.
     * @param students        a list of students in the teacher's classes.
     */
    public TeacherUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends, 
    ArrayList<String> teachingClasses, Map<String, ArrayList<Map<String, String>>> gradebook, ArrayList<StudentUser> students ) {
       super(userName, firstName, lastName, email, password, points, badges, friends);
       this.teachingClasses = teachingClasses;
       this.gradebook = gradebook;
       this.students = students;
    }

    /**
     * Creates a teacher account after validating that the username is unique and the email is valid and not already taken.
     * Default values are assigned for teacher-specific attributes.
     *
     * @param userName  the username for the teacher.
     * @param firstName the teacher's first name.
     * @param lastName  the teacher's last name.
     * @param email     the teacher's email address.
     * @param password  the teacher's password.
     * @return a new TeacherUser if the account is created successfully, or null otherwise.
     */
    public static TeacherUser createTeacherAccount(String userName, String firstName, String lastName, String email, String password) {
        // Check if username already exists
        if (UserList.getInstance().haveUser(userName)) {
            return null;
        }
        if (User.isEmailTaken(email)) {
			System.out.println("Email is already registered. Please use a different email.");
			return null;  
		}
		if (!User.isValidEmail(email)) {
			System.out.println("Invalid email format. Please enter a valid email address.");
			return null;  
		}
        
        // Default values for new teacher users
        int points = 0;
        ArrayList<String> badges = new ArrayList<>();
        badges.add("Instructor");
        ArrayList<String> friends = new ArrayList<>();
        ArrayList<StudentUser> students = new ArrayList<>();

        
        // Teacher-specific attributes
        ArrayList<String> teachingClasses = new ArrayList<>();
        Map<String, ArrayList<Map<String, String>>> gradebook = new HashMap<>();
        
        // Create and add the teacher user
        TeacherUser newUser = new TeacherUser(userName, firstName, lastName, email, password, 
                                             points, badges, friends, teachingClasses, gradebook, students);
        
        boolean success = UserList.getInstance().addUser(newUser);
        
        if (success) {
            return newUser;
        }
        
        return null;
    }

    /**
     * Adds a student to the teacher's classes and updates the gradebook.
     * The method iterates over the teacher's classes and, for each class, checks whether the student is already enrolled.
     * If not, it enrolls the student and adds a corresponding record in the gradebook.
     *
     * @param student the  StudentUser to be added.
     * @return  true if the student was successfully added to at least one class; false otherwise.
     */
    public boolean addStudent(StudentUser student) {
        if (student == null) {
            System.out.println("Cannot add null student");
            return false;
        }
        if (teachingClasses == null || teachingClasses.isEmpty()) {
            System.out.println("Teacher has no classes assigned.");
            return false;
        }
        boolean studentAdded = false;

        for (String classCode: teachingClasses) {
            if (!student.getClasses().contains(classCode)) {
                student.getClasses().add(classCode);


                Map<String, String> studentRecord = new HashMap<>();
                studentRecord.put("First Name", student.getFirstName());
                studentRecord.put("Last Name", student.getLastName());
                studentRecord.put("Grade", String.valueOf(student.getGrade()));
                studentRecord.put("Progress", String.valueOf(student.getProgress()));

                ArrayList<Map<String, String>> records = gradebook.get(classCode);
                if (records == null) {
                    records = new ArrayList<>();
                }
                records.add(studentRecord);
                gradebook.put(classCode, records);

                studentAdded = true;
            }
        }
        if (!studentAdded) {
            System.out.println("Student " + student.getLastName() +" " + student.getLastName() + 
            " is already enrolled in class.");
            return false;
        }

        if (!students.contains(student)) {
            students.add(student);
        }
         return true;
    }

     /**
     * Retrieves the list of classes the teacher is teaching.
     *
     * @return an  ArrayList containing the class codes.
     */
    public ArrayList<String> getTeachingClasses() {
        return teachingClasses;
    }

    /**
     * Sets the list of teaching classes for the teacher.
     *
     * @param teachingClass an ArrayList containing the new teaching class codes.
     * @return true if the classes were successfully updated;  false otherwise.
     */
    public boolean setTeachingClasses(ArrayList<String> teachingClass) {
        if (teachingClasses == null ) return false;
        this.teachingClasses = teachingClass;
        return true;  
    }

    /**
     * Retrieves the gradebook mapping class codes to lists of student records.
     *
     * @return a  Map where each key is a class code and the value is a list of student records.
     */
    public Map<String, ArrayList<Map<String, String>>> getGradebook() {
        return gradebook;
    }
    /**
     * Sets the gradebook for the teacher.
     *
     * @param gradebook a  Map where each key is a class code and the value is a list of student records.
     * @return true if the gradebook was successfully updated; false otherwise.
     */
    public boolean setGradebook(Map<String, ArrayList<Map<String, String>>> gradebook){
        if (gradebook == null ) return false;
        this.gradebook = gradebook;
        return true;  
    }

    /**
     * Views the overall progress of students.
     * TO DO: Implement the method to calculate and return the average progress of students across classes.
     *
     * @return the average progress of students.
     */
    public double viewStudentsProgress(){
        // finish method
        return 0.0;
    }

    /**
     * Sends feedback to a student.
     *
     * @param feedback the feedback message.
     * @param userName the username of the student receiving feedback.
     * @return a confirmation message regarding the feedback.
     */
    public String sendFeedback(StudentUser student, String feedback){
        if (student == null || feedback == null || feedback.trim().isEmpty()) {
            return "Error: Invalid student or feedback message";
        }

        if (!students.contains(student)){
            return "Error: Student is not enrolled in your class";
        }

        return "Feedback sent to " + student.getFirstName() + " " + student.getLastName() + ": " + feedback;
    }

    /**
     * Creates a new classroom with the specified class name.
     *
     * @param className the name of the new classroom.
     * @return the unique identifier for the created classroom.
     */
    public String createClassroom(String className){
        if (className == null || className.trim().isEmpty()) {
            return null;
        }
        
        // Check if the class already exists
        if (teachingClasses.contains(className)) {
            return null; // Class already exists
        }
        
        // Generate a unique class code (in a real app, this might be more sophisticated)
        String classCode = className.replaceAll("\\s+", "").substring(0, Math.min(className.length(), 3)).toUpperCase() 
                         + "-" + String.format("%03d", teachingClasses.size() + 1);
        
        // Add the class to the teacher's teaching classes
        teachingClasses.add(className);
        
        // Initialize an empty gradebook for the new class
        gradebook.put(className, new ArrayList<>());
        
        return classCode;
    }

    /**
     * Removes a student from the teacher's classes.
     *
     * @param student the StudentUse} to be removed.
     * @return true if the student was successfully removed; false  otherwise.
     */
    public boolean removeStudent(StudentUser student) {
        if (student == null || !students.contains(student)) {
            return false;
        }
        
        boolean removed = false;
        
        // Remove the student from the students list
        removed = students.remove(student);
        
        // Remove the student from all classes they're enrolled in
        for (String classCode : teachingClasses) {
            if (student.getClasses().contains(classCode)) {
                student.getClasses().remove(classCode);
                
                // Remove the student's record from the gradebook
                ArrayList<Map<String, String>> classRecords = gradebook.get(classCode);
                if (classRecords != null) {
                    // Find and remove the student's record
                    for (int i = 0; i < classRecords.size(); i++) {
                        Map<String, String> record = classRecords.get(i);
                        if (record.get("First Name").equals(student.getFirstName()) && 
                            record.get("Last Name").equals(student.getLastName())) {
                            classRecords.remove(i);
                            break;
                        }
                    }
                }
                
                removed = true;
            }
        }
        
        return removed;
    }

    /**
     * Assigns a flashcard to a specific class.
     * TO DO: Complete the implementation of this method.
     *
     * @param flashcard     the  Flashcard to assign.
     * @param assignedClass the class code to which the flashcard is assigned.
     * @return true if the flashcard was successfully assigned; false otherwise.
     */
    public boolean assignFlashcard(Flashcard flashcard, String assignedClass) {
        if (flashcard == null || assignedClass == null || assignedClass.trim().isEmpty()) {
            return false;
        }
        
        // Check if the class exists
        if (!teachingClasses.contains(assignedClass)) {
            return false;
        }
        
        // Assign the flashcard to all students in the class
        boolean assigned = false;
        for (StudentUser student : students) {
            if (student.getClasses().contains(assignedClass)) {
                // Add the flashcard to the student's assigned flashcards
                // Assuming the Flashcard class has a getUUID() or getId() method
                String flashcardId = flashcard.getCardID(); // or getUUID() depending on your implementation
                if (!student.getAssignedFlashcards().contains(flashcardId)) {
                    student.getAssignedFlashcards().add(flashcardId);
                    assigned = true;
                }
            }
        }
        
        return assigned;
    }
    /**
    * Retrieves the list of students associated with this teacher.
    *
    * @return an ArrayList of StudentUser objects representing the students managed by this teacher
    */
    public ArrayList<StudentUser> getStudents() {
        return students;
    }

    /**
     * Determines that current User is a Teacher
     * @return boolean answer True that User is a Teacher
     */
    public boolean isTeacher() {
        return true;
    }
}