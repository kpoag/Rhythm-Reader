package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a flashcard with text, picture, category, difficulty, and a list of assigned students.
 * Each flashcard has a unique cardID, front and back text, associated picture, category, difficulty, and students assigned.
 * Provides methods for checking answers, updating progress, and managing student assignments.
 * 
 * @author Kennedy Poag and Rondasha Bonds
 */
public class Flashcard {
    private String cardID;
    private String frontText;
    private String picture;
    private String backText;
    private String category;
    private String difficulty;
    private String hint;
    private ArrayList<StudentUser> assignedStudents;

    /**
     * Constructs a Flashcard with specified attributes.
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
     * Flips the flashcard to show the back text.
     * 
     * @return true or false indicating the flip state (this could be expanded based on design).
     */
    public boolean flip() {
        return false;
    }

    /**
     * Gets the front text of the flashcard.
     * 
     * @return the front text of the flashcard
     */
    public String getFrontText() {
        return frontText;
    }

    /**
     * Gets the back text of the flashcard.
     * 
     * @return the back text of the flashcard
     */
    public String getBackText() {
        return backText;
    }

    /**
     * Gets the picture associated with the flashcard.
     * 
     * @return the picture associated with the flashcard
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Gets the unique identifier of the flashcard.
     * 
     * @return the card ID
     */
    public String getCardID() {
        return cardID;
    }
    /**
 * Gets the difficulty level of the flashcard.
 *
 * @return the difficulty level as a String
 */
    public String getDifficulty() {
        return difficulty;
    }
    /**
 * Gets the category of the flashcard.
 *
 * @return the category as a String
 */
    public String getCategory() {
        return category;
    }
    /**
     * Checks if the provided answer matches the back text of the flashcard.
     *
     * @param userAnswer the user's answer to check
     * @return true if the user's answer matches the back text, false otherwise
     */
    public boolean checkAnswer(String userAnswer) {
        return this.backText.equals(userAnswer);
    }

    /**
     * Updates the student's progress based on the flashcard's category or assigned cards.
     *
     * @param studentID  The ID of the student.
     * @param userAnswer The user's answer to the flashcard.
     * @param isStudent  Boolean indicating whether the user is a student.
     * @param category   The category of the flashcard.
     * @param flashcard  The Flashcard instance to check the answer for.
     */
    public static void updateProgress(String studentID, String userAnswer, boolean isStudent, String category, Flashcard flashcard) {
        Map<String, Double> studentProgress = new HashMap<>();

        if (isStudent) {
            boolean isCorrect = flashcard.checkAnswer(userAnswer);
            if (isCorrect) {
                studentProgress.put(studentID, studentProgress.getOrDefault(studentID, 0.0) + 1);
            }
        } else {
            double totalCards = Flashcard.getTotalCardsInCategory(category);
            double completedCards = Flashcard.getCompletedCardsInCategory(category);
            double progress = completedCards / totalCards;
            System.out.println("Category Progress for " + category + ": " + progress);
        }
    }

    /**
     * Returns the total number of flashcards in a specified category.
     *
     * @param category The category to check.
     * @return the total number of flashcards in the category
     */
    public static double getTotalCardsInCategory(String category) {
        return 3; // Placeholder value
    }

    /**
     * Returns the number of completed flashcards in a specified category.
     *
     * @param category The category to check.
     * @return the number of completed flashcards in the category
     */
    public static double getCompletedCardsInCategory(String category) {
        return 1; // Placeholder value
    }

    /**
     * Returns a string representation of the flashcard, including the card ID.
     *
     * @return a string representation of the flashcard
     */
    @Override
    public String toString() {
        return "Flashcard " + cardID;
    }

    /**
     * Gets the list of students assigned to this flashcard.
     *
     * @return the list of assigned students
     */
    public ArrayList<StudentUser> getAssignedStudents() {
        return assignedStudents;
    }

    /**
     * Sets the list of students assigned to this flashcard.
     *
     * @param assignedStudents the new list of assigned students
     * @return true if the list was set successfully, false if assignedStudents is null
     */
    public boolean setAssignedStudents(ArrayList<StudentUser> assignedStudents) {
        if (assignedStudents == null) return false;
        this.assignedStudents = assignedStudents;
        return true;
    }

    /**
     * Checks if a student has completed the flashcard.
     *
     * @param studentID the ID of the student
     * @return true if the student has completed the flashcard, false otherwise
     */
    public boolean hasStudentCompleted(String studentID) {
        return false; // Implement this logic based on how progress is tracked
    }
}
