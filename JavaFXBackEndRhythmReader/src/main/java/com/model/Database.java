package com.model;

import java.util.ArrayList;
// This class includes static methods to retrieve lists of users and flashcards.

public class Database {

   /**
     * Retrieves a list of users.
     * This method returns a new, empty ArrayList of User objects.
     *
     * @return a new, empty  ArrayList containing User objects.
     */
   public static ArrayList<User> getUsers(){
    return new ArrayList<User>();
   }

   /**
     * Retrieves a list of Flashcards.
     * This method returns a new, empty ArrayList of Flashcard objects.
     *
     * @return a new, empty  ArrayList containing Flashcards objects.
     */
   public static ArrayList<Flashcard> getFlashcards(){
    return new ArrayList<Flashcard>();
   }
}
