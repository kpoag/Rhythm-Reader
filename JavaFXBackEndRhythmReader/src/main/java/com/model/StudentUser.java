 /*
    TO DO: finish setters/getters, reevaluate required vs. wanted requirements
     */ 
package com.model;

import java.util.ArrayList;
import java.util.List;

public class StudentUser extends User {
    private double progress;
    private double grade;
    private String classroomCode;
    private String skillLevel;
    private ArrayList<Flashcard> completedFlashcards;
    private Flashcard currentFlashcard;

    public StudentUser(String userName, String firstName, String lastName, String email,
    String password, int points, ArrayList<String> badges, ArrayList<String> friends) {
        super(userName, firstName, lastName, email, password, points, badges, friends);
        this.progress = progress;
        this.grade = grade;
        this.classroomCode = classroomCode;
        this.skillLevel = skillLevel;
        this.completedFlashcards = new ArrayList<>();    
        this.currentFlashcard = null;    
    }
    public double getProgress(){
        return progress;
    }

    public double getGrade() {
        return grade;
    }

    public String getClassroomCode(){
        return classroomCode;
    }
    public String getSkillLevel(){
        return skillLevel;
    }
    public ArrayList<Flashcard> getCompletedFlashcards() {
        return completedFlashcards;
    }
    public Flashcard getCurrenFlashcard(){
        return currentFlashcard;
    }
    public boolean hasClassroomCode(String code) {
        return true;
    }
    public void takePlacementTest(){

    }

}
