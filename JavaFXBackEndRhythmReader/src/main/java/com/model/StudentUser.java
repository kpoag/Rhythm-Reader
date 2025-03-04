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

    public StudentUser() {
        //TODO Auto-generated constructor stub
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
