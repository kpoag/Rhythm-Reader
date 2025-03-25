 /*
    TO DO: reevaluate required vs. wanted requirements
     */ 
package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentUser extends User {
    private double progress;
    private double grade;
    private ArrayList<String> classes;
    private String skillLevel;
    private ArrayList<String> completedFlashcards;
    private Flashcard currentFlashcard;
    private Map<String, String> deadlines;
    private ArrayList<String> assignedFlashcards;

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

    public static StudentUser createStudentUser(String userName, String firstName, String lastName, String email, String password) {
        if (UserList.getInstance().haveUser(userName)) {
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

    public double getProgress(){
        return progress;
    }
    public boolean setProgress(double progress) {
        if (progress < 0.0 || progress > 100.0 ) return false;
        this.progress = progress ;
        return true;  
    }

    public double getGrade() {
        return grade;
    }
    public boolean setGrade(double grade) {
        if (grade < 0.0 || grade > 100.0 ) return false;
        this.grade = grade ;
        return true;  
    }


    public ArrayList<String> getClasses() {
        return classes;
    }
    public boolean setClasses(ArrayList<String> classes) {
        if (classes == null ) return false;
        this.classes = classes ;
        return true;  
    }

    public String getSkillLevel(){
        return skillLevel;
    }
    public boolean setSkilllevel(String skillLevel) {
        if (skillLevel == null ) return false;
        this.skillLevel = skillLevel ;
        return true;  
    }

    public ArrayList<String> getCompletedFlashcards() {
        return completedFlashcards;
    }
    public boolean setCompletedFlashcards(ArrayList<String> completedFlashcards) {
        if (completedFlashcards == null ) return false;
        this.completedFlashcards = completedFlashcards ;
        return true;  
    }

    public ArrayList<String> getAssignedFlashcards(){
        return assignedFlashcards;
    }
    public boolean setAssignedFlashcards(ArrayList<String> assignedFlashcards) {
        if (assignedFlashcards == null ) return false;
        this.assignedFlashcards = assignedFlashcards ;
        return true;  
    }

    public Flashcard getCurrentFlashcard(){
        return currentFlashcard;
    }
    public boolean setCurrentFlashcard(Flashcard currentFlashcard) {
        if (currentFlashcard == null ) return false;
        this.currentFlashcard = currentFlashcard ;
        return true;  
    }

    public Map<String, String> getDeadlines(){
        return deadlines;
    }
    public boolean setDeadlines(Map<String, String> deadlines){
        if (deadlines == null ) return false;
        this.deadlines = deadlines ;
        return true; 
    }

    public boolean hasClassroomCode(String code) {
        //finish method
        return true;
    }
    /* 
    public boolean takePlacementTest(){
        //finish method

    }*/
    
    public boolean isStudent() {
        return true;
    }

}
