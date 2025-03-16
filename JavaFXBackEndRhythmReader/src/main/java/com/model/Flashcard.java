package com.model;

import java.util.ArrayList;

public class Flashcard {
    private String cardID;
    private String frontText;
    private String picture;
    private String backText;
    private String category;
    private String difficulty;

    private ArrayList<StudentUser> assignedStudents;

    Flashcard(String cardID, String frontText, String backText, String picture, String category, String difficulty) {
        this.cardID = cardID;
        this.frontText = frontText;
        this.backText = backText;
        this.picture = picture;
        this.category = category;
        this.difficulty = difficulty;
        this.assignedStudents = new ArrayList<>();
    }

    public String getCardID()
    {
        return cardID;
    }
    public void setCardID(String cardID)
    {
        this.cardID= cardID;
    }
    public String getFrontText()
    {
        return frontText;
    }
    public void setFrontText(String frontText)
    {
        this.frontText= frontText;
    }
    public String getBackText()
    {
        return backText;
    }
    public void setBackText(String backText)
    {
        this.backText= backText;
    }
    public String getPicture()
    {
        return picture;
    }
    public void setPicture(String picture)
    {
        this.picture= picture;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category= category;
    }
    public String getDifficulty()
    {
        return difficulty;
    }
    public void setDifficulty(String difficulty)
    {
        this.difficulty= difficulty;
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
    public ArrayList<StudentUser> getAssignedStudents(){
        return assignedStudents;
    }
    public void setAssignedStudents(ArrayList<StudentUser> assignedStudents)
    {
        this.assignedStudents= assignedStudents;
    }

    public boolean hasStudentCompleted(String studentID){
        return false;
    }
}
