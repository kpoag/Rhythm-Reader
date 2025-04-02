package com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
// This class includes static methods to retrieve lists of users and flashcards.

public class Database extends DataConstants {

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

   private static String getFileWritingPath(String PATH_NAME, String JUNIT_PATH_NAME) {
		try {
			if(isJUnitTest()){
				URI url = Database.class.getResource(JUNIT_PATH_NAME).toURI();
				return url.getPath();
			} else {
				return PATH_NAME;
			}
		} catch(Exception e){
			System.out.println("Difficulty getting resource path");
			return "";
		}
	}

	private static BufferedReader getReaderFromFile(String fileName, String jsonFileName){
		try {
			if(isJUnitTest()){
				InputStream inputStream = Database.class.getResourceAsStream(jsonFileName);
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				return new BufferedReader(inputStreamReader);
			} else {
				FileReader reader = new FileReader(fileName);
				return new BufferedReader(reader);
			}
		} catch(Exception e){
			System.out.println("Can't load");
			return null;
		}
			
	}
}
