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
    public boolean setCardID(String cardID)
    {
        if (cardID == null ) return false;
        this.cardID= cardID;
        return true; 
    }
    public String getFrontText()
    {
        return frontText;
    }
    public boolean setFrontText(String frontText)
    {
        if (frontText == null ) return false;
        this.frontText= frontText;
        return true; 
    }
    public String getBackText()
    {
        return backText;
    }
    public boolean setBackText(String backText)
    {
        if (backText == null ) return false;
        this.backText = backText ;
        return true; 
    }
    public String getPicture()
    {
        return picture;
    }
    public boolean setPicture(String picture){
        if (picture == null ) return false;
        this.picture = picture ;
        return true; 
    }
    public String getCategory(){
        return category;
    }
    public boolean setCategory(String category){
        if (category == null ) return false;
        this.category = category ;
        return true;   
    }
    public String getDifficulty()
    {
        return difficulty;
    }
    public boolean setDifficulty(String difficulty){
        if (difficulty == null ) return false;
        this.difficulty = difficulty ;
        return true;   
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
    public boolean setAssignedStudents(ArrayList<StudentUser> assignedStudents) {
        if (assignedStudents == null ) return false;
        this.assignedStudents = assignedStudents ;
        return true;   
    }

    public boolean hasStudentCompleted(String studentID){
        return false;
    }
}
