package com.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import com.model.*;

import org.junit.Before;

public class FlashcardTest {

    @Test
    public void testTesting() {
        assertTrue(true);
    }

    /*
     * Tests that the users answer is the correct answer
     */
    @Test
    public void testCheckCorrectAnswer() {
        Flashcard tempFlashcard = new Flashcard("1","Which clef is used for violin music?", 
       "Treble Clef", "", "Music Instruments", "Beginner");
        assertTrue(tempFlashcard.checkAnswer("Treble Clef"));
    }

    /*
     * Tests that the user's answer is the incorrect answer
     */
    @Test
    public void testCheckIncorrectAnswer() {
        Flashcard tempFlashcard = new Flashcard("2", "Which note does a treble clef start on", "G", "", "Music Theory", "Intermediate");
        assertFalse(tempFlashcard.checkAnswer("C"));
    }

    /*
     * Tests if the user's blank empty answer will be correct
     */
    @Test
    public void testEmptyAnswer() {
        Flashcard tempFlashcard = new Flashcard("3","How many beats are in a bar of 9/8 time?", "3", "", "Music Theory", "Beginner");
        assertFalse(tempFlashcard.checkAnswer(""));
    }

    /*
     * Tests if the user's answer should be considered due to case sensitivity
     */
    @Test
    public void testCheckAnswerCaseSensitive() {
        Flashcard tempFlashcard = new Flashcard("4", "Who released Fly Me To The Moon", "Bart Howard", "", "Music History", "Intermediate");
        assertFalse(tempFlashcard.checkAnswer("bart howard"));
    }

    /*
     * Tests if the user's answer should be considered due to empty space
     */
    @Test
    public void testEmptySpaceinAnswer() {
        Flashcard tempFlashcard = new Flashcard("5", "How many sharps are in the key of G Major", "1", "", "Music Theory","Beginner");
        assertFalse(tempFlashcard.checkAnswer(" 1"));
    }
    

    /*
     * Tests if Progress is updated with correct answer
     */
    @Test
    public void testProgressWithCorrectAnswer() {
        Flashcard tempFlashcard = new Flashcard("6","What does the acronym EDM stand for?", "Electronic Dance Music", "", "Music Definitions", "Beginner");
        boolean result = tempFlashcard.updateProgress("1", "Electronic Dance Music", true, "Music Definitions", tempFlashcard);
        assertTrue("Student answered this question correctly.", result);
    }
    
    /*
     * Tests if Progress is updated with incorrect answer
     */
    @Test
    public void testProgressWithIncorrectAnswer() {
        Flashcard tempFlashcard = new Flashcard("7", "What is a note marked with a sharp, flat, or natural outside of it's key signature?", "Accidental", "", "Musical Notation", "Beginner");
        boolean result = tempFlashcard.updateProgress("2", "Pitch", true, "Musical Notation", tempFlashcard);
        assertFalse("Student did not answer this question correctly.", result);
    }

    /*
     * Tests the updated Progress through TeacherUser
     */
    @Test
    public void testProgressWithTeacher() {
        boolean result = Flashcard.updateProgress("", "", false, "Music Theory", null);
        assertTrue("Category has progress data.", result);
    }

    /*
     * Tests the updated Progress with nonexistent category through TeacherUser
     */
    @Test
    public void testProgressWithTeacherInEmptyCategory() {
        boolean result = Flashcard.updateProgress("", "", false, "Musician Fun Facts", null);
        assertTrue("There are currently no flashcards in this category.", result);
    }

}
