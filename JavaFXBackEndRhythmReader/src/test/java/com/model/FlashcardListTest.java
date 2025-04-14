package com.model;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FlashcardListTest {
    private FlashcardList flashcardList;
    private Flashcard tempFlashcard;

    @Before
    public void setUp() {
        flashcardList = FlashcardList.getInstance();
        tempFlashcard = new Flashcard("1", "What are dynamics", "The volume of music", "", "Music Notation", "Beginner");
        
        flashcardList.getFlashcards().clear();
        flashcardList.getFlashcards().add(tempFlashcard);
    }

    @Test
    public void testInstance() {
        FlashcardList newInstance = FlashcardList.getInstance();
        assertSame(flashcardList, newInstance);
    }

    @Test
    public void testImaginaryFlashcard() {
        assertFalse(flashcardList.haveFlashcard("99"));
    }

    @Test
    public void testExistingFlashcard() {
        assertTrue(flashcardList.haveFlashcard("1"));
    }

    @Test
    public void testGetImaginaryFlashcard() {
        Flashcard copyFlashcard = flashcardList.getFlashcard("57");
        assertNull(copyFlashcard);
    }

    @Test
    public void testGetExistingFlashcard() {
        Flashcard copyFlashcard = flashcardList.getFlashcard("1");
        assertEquals("1", copyFlashcard.getCardID());
    }

    @Test
    public void testGetExistingFlashcardNotNull() {
        Flashcard copyFlashcard = flashcardList.getFlashcard("1");
        assertNotNull(copyFlashcard);
    }

    @Test
    public void testFlashcardList() {
        ArrayList<Flashcard> listOfFlashcards = flashcardList.getFlashcards();
        assertNotNull(listOfFlashcards);
    }

    @Test
    public void testFlashcardListSize() {
        ArrayList<Flashcard> listOfFlashcards = flashcardList.getFlashcards();
        assertEquals(1, listOfFlashcards.size());
    }

}

