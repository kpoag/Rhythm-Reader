package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a student user in the system.
 * This class extends the User class and adds properties specific to student users such as progress,
 * grade, enrolled classes, skill level, flashcard information, deadlines, and assigned flashcards.
 */
public class StudentUser extends User {
    private double progress;
    private double grade;
    private ArrayList<String> classes;
    private String skillLevel;
    private ArrayList<String> completedFlashcards;
    private Flashcard currentFlashcard;
    private Map<String, String> deadlines;
    private ArrayList<String> assignedFlashcards;

    /**
     * Constructs a new StudentUser with the specified parameters.
     *
     * @param userName            the username of the student.
     * @param firstName           the first name of the student.
     * @param lastName            the last name of the student.
     * @param email               the email address of the student.
     * @param password            the password for the student.
     * @param points              the initial points for the student.
     * @param badges              a list of badges earned by the student.
     * @param friends             a list of friends of the student.
     * @param progress            the progress percentage of the student.
     * @param grade               the current grade of the student.
     * @param classes             a list of classes the student is enrolled in.
     * @param skillLevel          the skill level of the student.
     * @param completedFlashcards a list of completed flashcard identifiers.
     * @param currentFlashcard    the current flashcard assigned to the student.
     * @param deadlines           a map containing deadlines for assignments.
     * @param assignedFlashcards  a list of flashcards assigned to the student.
     */
    public StudentUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends,
    double progress, double grade, ArrayList<String> classes, String skillLevel, ArrayList<String> completedFlashcards,
    Flashcard currentFlashcard, Map<String, String> deadlines, ArrayList<String> assignedFlashcards) {
        super(userName, firstName, lastName, email, password, points, badges, friends);
        this.progress = progress;
        this.grade = grade;
        this.classes = new ArrayList<>();
        this.skillLevel = skillLevel;
        this.completedFlashcards = new ArrayList<>();
        this.assignedFlashcards = new ArrayList<>();
        this.deadlines = new HashMap<>();
        this.currentFlashcard = null;    
    }

    /**
     * Creates a new student user with the specified minimal parameters.
     * This method checks if the username or email is already taken, and if the email is valid.
     * If any of these checks fail, it returns null.
     *
     * @param userName  the username for the student.
     * @param firstName the first name of the student.
     * @param lastName  the last name of the student.
     * @param email     the email address of the student.
     * @param password  the password for the student.
     * @return a new StudentUser instance if successful, or null otherwise.
     */
    public static StudentUser createStudentUser(String userName, String firstName, String lastName, String email, String password) {
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
        int points = 0;
        ArrayList<String> badges = new ArrayList<>();
        badges.add("Beginner");
        ArrayList<String> friends = new ArrayList<>();

        double progress = 0.0;
        double grade = 0.0;
        ArrayList<String> classes = new ArrayList<>();
        String skillLevel = "Beginner";
        ArrayList<String> completedFlashcards = new ArrayList<>();
        ArrayList<String> assignedFlashcards = new ArrayList<>();
        Map<String, String> deadlines = new HashMap<>();

         StudentUser newUser = new StudentUser(userName, firstName, lastName, email, password, 
                                             points, badges, friends, progress, grade, classes, 
                                             skillLevel, completedFlashcards, null, deadlines, assignedFlashcards);
        
        boolean success = UserList.getInstance().addUser(newUser);
        
        if (success) {
            return newUser;
        }
        return null;
    }

     /**
     * Retrieves the progress of the student.
     *
     * @return the progress percentage.
     */
    public double getProgress(){
        return progress;
    }

     /**
      * Sets the progress of the student.
      *
      * @param progress the progress percentage to set (must be between 0.0 and
      *                 100.0).
      * @return true or false if the progress was set successfully.
      */
    public boolean setProgress(double progress) {
        if (progress < 0.0 || progress > 100.0 ) return false;
        this.progress = progress ;
        return true;  
    }

    /**
     * Retrieves the grade of the student.
     *
     * @return the current grade.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the student.
     *
     * @param grade the grade to set (must be between 0.0 and 100.0).
     * @return true or false if grade was set
     */
    public boolean setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0 ) return false;
        this.grade = grade ;
        return true;  
    }

    /**
     * Retrieves the list of classes the student is enrolled in.
     *
     * @return an  ArrayList of class names.
     */
    public ArrayList<String> getClasses() {
        return classes;
    }

    /**
     * Sets the list of classes for the student.
     *
     * @param classes an ArrayList of class names.
     * @return true or false if classes were set successfully 
     */
    public boolean setClasses(ArrayList<String> classes) {
        if (classes == null ) return false;
        this.classes = classes ;
        return true;  
    }

    /**
     * Retrieves the skill level of the student.
     *
     * @return the skill level.
     */
    public String getSkillLevel(){
        return skillLevel;
    }

    /**
     * Sets the skill level of the student.
     *
     * @param skillLevel the skill level to set.
     * @return true or false if skill level was set successfully 
     */
    public boolean setSkilllevel(String skillLevel) {
        if (skillLevel == null ) return false;
        this.skillLevel = skillLevel ;
        return true;  
    }

    /**
     * Retrieves the list of completed flashcards.
     *
     * @return an  ArrayList of completed flashcard identifiers.
     */
    public ArrayList<String> getCompletedFlashcards() {
        return completedFlashcards;
    }

    /**
     * Sets the list of completed flashcards.
     *
     * @param completedFlashcards an ArrayList of completed flashcard identifiers.
     * @return true if the list was successfully set; false otherwise.
     */
    public boolean setCompletedFlashcards(ArrayList<String> completedFlashcards) {
        if (completedFlashcards == null ) return false;
        this.completedFlashcards = completedFlashcards ;
        return true;  
    }

     /**
     * Retrieves the list of assigned flashcards.
     *
     * @return an  ArrayList of assigned flashcard identifiers.
     */
    public ArrayList<String> getAssignedFlashcards(){
        return assignedFlashcards;
    }

    /**
     * Sets the list of assigned flashcards.
     *
     * @param assignedFlashcards an  ArrayList of assigned flashcard identifiers.
     * @return  true if the list was successfully set; false otherwise
     */
    public boolean setAssignedFlashcards(ArrayList<String> assignedFlashcards) {
        if (assignedFlashcards == null ) return false;
        this.assignedFlashcards = assignedFlashcards ;
        return true;  
    }

    /**
     * Retrieves the current flashcard assigned to the student.
     *
     * @return the current Flashcard.
     */
    public Flashcard getCurrentFlashcard(){
        return currentFlashcard;
    }
    /**
     * Sets the current flashcard for the student.
     *
     * @param currentFlashcard the  Flashcard to set as current.
     * @return true if the flashcard was successfully set; false otherwise.
     */
    public boolean setCurrentFlashcard(Flashcard currentFlashcard) {
        if (currentFlashcard == null ) return false;
        this.currentFlashcard = currentFlashcard ;
        return true;  
    }

    /**
     * Retrieves the deadlines for assignments or classes.
     *
     * @return a Map with deadlines, where keys represent subjects or assignments and values represent deadlines.
     */
    public Map<String, String> getDeadlines(){
        return deadlines;
    }
    /**
     * Sets the deadlines for assignments or classes.
     *
     * @param deadlines a Map with deadlines, where keys represent subjects or assignments and values represent deadlines.
     * @return  true if the deadlines were successfully set;  false otherwise.
     */
    public boolean setDeadlines(Map<String, String> deadlines){
        if (deadlines == null ) return false;
        this.deadlines = deadlines ;
        return true; 
    }

    /**
     * Checks whether the student has the specified classroom code.
     *
     * @param code the classroom code to check.
     * @return  true if the student has the specified classroom code;  false otherwise.
     */
    public boolean joinCourse(String code) {
        //finish method
        return true;
    }
    
    /**
     * Indicates that this user is a student.
     *
     * @return true  since this instance represents a student.
     */
    public boolean isStudent() {
        return true;
    }

}
