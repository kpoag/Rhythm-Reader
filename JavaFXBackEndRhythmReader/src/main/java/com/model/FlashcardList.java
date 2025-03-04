package com.model;

import java.util.ArrayList;

public class FlashcardList {
    private static FlashcardList flashcards;
    private ArrayList<Flashcard> flashcardList;

    private FlashcardList(){
        flashcardList = Database.getFlashcard();
    }
    public static FlashcardList getInstance() {
        if(flashcards == null) {
            flashcards = new FlashcardList();
        }
        return flashcards;
    }

    public boolean haveFlashcard(String flashcardID) {
        return true;
    }

    public Flashcard getFlashcard(String flashcardID) {
        if(!haveFlashcard(flashcardID)) return null;

        return new Flashcard(flashcardID, "Question", "Answer", "Music Theory", "Beginner");
    }
}
