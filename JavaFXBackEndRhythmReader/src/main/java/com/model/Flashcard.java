package com.model;

import java.util.ArrayList;
import java.util.List;

public class Flashcard {
    private String cardID;
    private String frontText;
    private String picture;
    private String backText;
    private String category;
    private String difficulty;

    private List<StudentUser> assignedStudents;

    Flashcard(String cardID, String frontText, String backText, String category, String difficulty) {
        this.cardID = cardID;
        this.frontText = frontText;
        this.backText = backText;
        this.picture = picture;
        this.category = category;
        this.difficulty = difficulty;
        this.assignedStudents = new ArrayList<>();
    }

    public boolean flip(){
        return false;
    }
    
    public boolean checkAnswer(String userAnswer) {
        return false;
    }
    public String toString() {
        return "Flashcrd " + cardID;
    }
    public List<StudentUser> getAssignedStudents(){
        return assignedStudents;
    }

    public boolean hasStudentCompleted(String studentID){
        return false;
    }
}
