package com.model;

import java.util.ArrayList;

/**
 * The FlashcardList class provides a singleton pattern for managing a list of flashcards.
 * It allows access to a list of flashcards, retrieval of individual flashcards by their ID, 
 * and checking if a flashcard exists in the collection.
 */
public class FlashcardList {
    
    // Singleton instance of FlashcardList
    private static FlashcardList flashcards;
    
    // List that holds the flashcards
    private ArrayList<Flashcard> flashcardList;

    /**
     * Private constructor to initialize the flashcards list by fetching data from the database.
     */
    private FlashcardList(){
        flashcardList = DataLoader.loadFlashcards();
    }

    /**
     * Retrieves the singleton instance of FlashcardList.
     * If the instance doesn't exist, it will create a new instance.
     *
     * @return The singleton instance of FlashcardList.
     */
    public static FlashcardList getInstance() {
        if(flashcards == null) {
            flashcards = new FlashcardList();
        }
        return flashcards;
    }

    /**
     * Checks if a flashcard with the specified ID exists in the list.
     *
     * @param flashcardID The ID of the flashcard to check.
     * @return true if the flashcard exists; false otherwise.
     */
    public boolean haveFlashcard(String flashcardID) {
        for (Flashcard flashcard : flashcardList) {
            if (flashcard.getCardID().equals(flashcardID)) {
                return true;
            }
        }
        return false;  // This can be modified to properly check the existence of the flashcard
    }

    /**
     * Retrieves a flashcard by its ID. If the flashcard is not found, it returns null.
     *
     * @param flashcardID The ID of the flashcard to retrieve.
     * @return The Flashcard object with the specified ID, or null if not found.
     */
    public Flashcard getFlashcard(String flashcardID) {
        for (Flashcard flashcard : flashcardList) {
            if (flashcard.getCardID().equals(flashcardID)) {
                return flashcard;
            }
        }
        return null;
        // This is a placeholder; it can be replaced with a proper flashcard retrieval logic
        // return new Flashcard(flashcardID, "Question", "Answer", "key_signature.png", "Music Theory", "Beginner");
    }

    /**
     * Retrieves the list of all flashcards.
     *
     * @return An ArrayList containing all the flashcards.
     */
    public ArrayList<Flashcard> getFlashcards() {
        return flashcardList;
    }

}

