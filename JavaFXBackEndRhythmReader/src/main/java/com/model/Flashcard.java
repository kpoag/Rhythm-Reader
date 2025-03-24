package com.model;

import java.util.ArrayList;

/**
 * @author Kennedy Poag
 * Represents a flashcard with text, picture, category, difficulty, and a list of assigned students.
 */
public class Flashcard {
    private String cardID;
    private String frontText;
    private String picture;
    private String backText;
    private String category;
    private String difficulty;
    private ArrayList<StudentUser> assignedStudents;

    /**
     * Constructs a Flashcard
     *
     * @param cardID     the unique identifier for the flashcard
     * @param frontText  the text displayed on the front of the flashcard
     * @param backText   the text displayed on the back of the flashcard
     * @param picture    the picture associated with the flashcard
     * @param category   the category of the flashcard
     * @param difficulty the difficulty level of the flashcard
     */
    Flashcard(String cardID, String frontText, String backText, String picture, String category, String difficulty) {
        this.cardID = cardID;
        this.frontText = frontText;
        this.backText = backText;
        this.picture = picture;
        this.category = category;
        this.difficulty = difficulty;
        this.assignedStudents = new ArrayList<>();
    }

    /**
     * Returns the flashcard ID.
     *
     * @return cardID
     */
    public String getCardID() {
        return cardID;
    }

    /**
     * Sets the flashcard ID.
     *
     * @param cardID new card ID
     * @return true if set successfully, false if cardID is null
     */
    public boolean setCardID(String cardID) {
        if (cardID == null ) return false;
        this.cardID= cardID;
        return true; 
    }

    /**
     * Returns the front text of the flashcard.
     *
     * @return frontText
     */
    public String getFrontText() {
        return frontText;
    }

    /**
     * Sets the front text of the flashcard.
     *
     * @param frontText new front text
     * @return true if set successfully, false if frontText is null
     */
    public boolean setFrontText(String frontText) {
        if (frontText == null ) return false;
        this.frontText= frontText;
        return true; 
    }

    /**
     * Returns the back text of the flashcard.
     *
     * @return the backText
     */
    public String getBackText() {
        return backText;
    }

    /**
     * Sets the back text of the flashcard.
     *
     * @param backText new back text
     * @return true if set successfully, false if backText is null
     */
    public boolean setBackText(String backText) {
        if (backText == null ) return false;
        this.backText = backText ;
        return true; 
    }

    /**
     * Returns the picture associated with the flashcard.
     *
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

     /**
     * Sets the picture for the flashcard.
     *
     * @param picture new picture
     * @return true if set successfully, false if picture is null
     */
    public boolean setPicture(String picture) {
        if (picture == null ) return false;
        this.picture = picture ;
        return true; 
    }

     /**
     * Returns the category of flashcard.
     *
     * @return category
     */
    public String getCategory( ){
        return category;
    }

     /**
     * Sets the category of the flashcard.
     *
     * @param category new category
     * @return true if set successfully, false if category is null
     */
    public boolean setCategory(String category){
        if (category == null ) return false;
        this.category = category ;
        return true;   
    }

    /**
     * Returns the difficulty level of the flashcard.
     *
     * @return  difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty level of the flashcard.
     *
     * @param difficulty new difficulty level
     * @return true if set successfully, false if difficulty is null
     */
    public boolean setDifficulty(String difficulty){
        if (difficulty == null ) return false;
        this.difficulty = difficulty ;
        return true;   
    }
    
    /**
     * Flips the flashcard.
     *
     * @return true or false
     */
    public boolean flip(){
        // TO DO:Implement flip functionality
        return false;
    }
    
     /**
      * Checks if the user's answer is correct.
      *
      * @param userAnswer user's answer
      * @return true or false if user's answer is correct.
      */
    public boolean checkAnswer(String userAnswer) {
        // TO DO: Implement answer checking functionality
        return false;
    }

    /**
     * Returns a string representation of the flashcard.
     *
     * @return string representation including the cardID
     */
    @Override
    public String toString() {
        return "Flashcrd " + cardID;
    }

    /**
     * Returns the list of students assigned to this flashcard.
     *
     * @return assignedStudents list
     */
    public ArrayList<StudentUser> getAssignedStudents(){
        return assignedStudents;
    }

    /**
     * Sets the list of students assigned to this flashcard.
     *
     * @param assignedStudents new list of assigned students
     * @return true if set successfully, false if assignedStudents is null
     */
    public boolean setAssignedStudents(ArrayList<StudentUser> assignedStudents) {
        if (assignedStudents == null ) return false;
        this.assignedStudents = assignedStudents ;
        return true;   
    }

    /**
     * Checks if a student has completed the flashcard.
     *
     * @param studentID student's ID
     * @return false (placeholder implementation)
     */
    public boolean hasStudentCompleted(String studentID){
        //To DO: implement this method to check if a student has completed the
        // flashcard based on the studentID
        return false;
    }
}
