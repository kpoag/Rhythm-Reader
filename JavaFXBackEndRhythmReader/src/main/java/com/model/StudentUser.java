 /*
    TO DO: finish setters/getters, reevaluate required vs. wanted requirements
     */ 
package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
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
    public double getProgress(){
        return progress;
    }

    public double getGrade() {
        return grade;
    }
    public ArrayList<String> getClasses() {
        return classes;
    }

    public String getSkillLevel(){
        return skillLevel;
    }
    public ArrayList<String> getCompletedFlashcards() {
        return completedFlashcards;
    }
    public ArrayList<String> getAssignedFlashcards(){
        return assignedFlashcards;
    }
    public Flashcard getCurrentFlashcard(){
        return currentFlashcard;
    }
    public Map<String, String> getDeadlines(){
        return deadlines;
    }
    public boolean hasClassroomCode(String code) {
        //finish method
        return true;
    }
    public void takePlacementTest(){
        //finish method

    }

}
