package com.model;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jfugue.player.Player;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	/**
	 * loadUsers method that gets user information from the user.json file
	 * @authors Jaylen and Kennedy
	 */
	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				String email = (String)personJSON.get(USER_EMAIL);
				String password = (String)personJSON.get(USER_PASSWORD);
				int points= ((Long)personJSON.get(USER_POINTS)).intValue();
				ArrayList<String> friends = (ArrayList)personJSON.get(USER_FRIENDS);
				ArrayList<String> badges= (ArrayList)personJSON.get(USER_BADGES);

				if (personJSON.containsKey(USER_PROGRESS)) {
					double progress = ((Number) personJSON.get(USER_PROGRESS)).doubleValue();
					double grade = ((Number) personJSON.get(USER_GRADES)).doubleValue();
					String skillLevel = (String) personJSON.get(USER_SKILL_LEVEL);
					
					ArrayList<String> classes = (ArrayList)personJSON.get(USER_CLASSROOM);
					ArrayList<String> assignedFlashcards = (ArrayList)personJSON.get(USER_ASSIGNED_FLASHCARDS);
					ArrayList<String> completedFlashcards = (ArrayList)personJSON.get(USER_COMPLETED_FLASHCARDS);

					JSONObject deadlinesJSON = (JSONObject) personJSON.get(USER_DEADLINES);
					Map<String, String> deadlines = new HashMap();
					if (deadlinesJSON != null) {
						for (Object key : deadlinesJSON.keySet()) {
							deadlines.put(key.toString(), deadlinesJSON.get(key).toString());
						}
					}

					StudentUser student = new StudentUser(userName, firstName, lastName, email, password, 
					points, badges, friends, grade, grade, completedFlashcards, skillLevel, completedFlashcards, 
					null, deadlines, completedFlashcards);

					users.add(student);
				} else {

					ArrayList<String> teachingClasses = (ArrayList<String>) personJSON.get(USER_TEACHING_CLASSES);
					
					JSONObject gradebookJSON = (JSONObject) personJSON.get(USER_GRADEBOOK);
					Map<String, ArrayList<Map<String, String>>> gradebook = parseGradebook(gradebookJSON);

					TeacherUser teacher = new TeacherUser(userName, firstName, lastName, email, password, points, 
					friends, badges, teachingClasses, gradebook);

					users.add(teacher);
				}

				}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	/**
	 * gets information for the gradebook 
	 * @param gradebookJSON
	 * @return gradebook
	 */

	private static Map<String, ArrayList<Map<String, String>>> parseGradebook(JSONObject gradebookJSON) {
		Map<String, ArrayList<Map<String, String>>> gradebook = new HashMap<>();

		if (gradebookJSON != null) {
			for (Object classKey : gradebookJSON.keySet()) {
				JSONArray gradesArray = (JSONArray) gradebookJSON.get(classKey);
				ArrayList<Map<String, String>> gradeList = new ArrayList<>();
				for (Object gradeObj : gradesArray) {
					JSONObject gradeEntry = (JSONObject) gradeObj;
					Map<String, String> entry = new HashMap<>();
					for (Object key : gradeEntry.keySet()) {
						entry.put(key.toString(), gradeEntry.get(key).toString());
					}
				gradeList.add(entry);
			}
			gradebook.put(classKey.toString(), gradeList);

			}
			
		}
		return gradebook;


	}


	/**
	 * loadSongs method thats gets information from the songs.json
	 * @authors Jaylen
	 */


	public static ArrayList<Song> loadSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		try {
			FileReader reader = new FileReader(SONG_FILE_NAME);
			JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);

			for(int i=0; i < songsJSON.size(); i++) {
				JSONObject songJSON = (JSONObject)songsJSON.get(i);
				String songID= ((String)songJSON.get(SONG_SONG_ID));
				String songTitle =((String)songJSON.get(SONG_SONGTITLE));
				String artist = (String)songJSON.get(SONG_ARTIST);
				Genre genre = Genre.valueOf((String)songJSON.get(SONG_GENRE));
				DifficultyLevel difficulty = DifficultyLevel.valueOf((String)songJSON.get(SONG_DIFFICULTY));
				String instrument = (String)songJSON.get(SONG_INSTRUMENT);
				double rating = (double)songJSON.get(SONG_RATING);
				String timeSignature = (String)songJSON.get(SONG_TIME_SIGNATURE);
				int tempo = ((Long)songJSON.get(SONG_TEMPO)).intValue();
				JSONArray measuresJSON = (JSONArray)songJSON.get(SONG_MEASURES);
				ArrayList<Measure>  measureList = new ArrayList<>();
				for (Object m : measuresJSON) {
					JSONArray measureArray = (JSONArray) m;
					Measure measure = Measure.fromJSON(m, timeSignature, "");
					measureList.add(measure);

				}
				Song song = new Song(songID, songTitle, artist, genre, difficulty, instrument, rating, tempo, timeSignature);
				song.setMeasures(measureList);
				songs.add(song);


			}
			
			return songs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return songs;
	}

	/**
	 * loadFlashcards method that gets information from the flashcard.json
	 * @authors Jaylen
	 */
	public static ArrayList<Flashcard> loadFlashcards()
	{
		ArrayList<Flashcard> flashcards= new ArrayList<Flashcard>();
		
		try {
			FileReader reader = new FileReader(FLASHCARD_FILE_NAME);
			JSONArray flashcardJSON = (JSONArray)new JSONParser().parse(reader);

			for(int i=0; i < flashcardJSON.size(); i++) {
				JSONObject flashcardsJSON = (JSONObject)flashcardJSON.get(i);
				String cardID= ((String)flashcardsJSON.get(FLASHCARD_CARD_ID));
				String frontText= ((String)flashcardsJSON.get(FLASHCARD_FRONT_TEXT));
				String backText= ((String)flashcardsJSON.get(FLASHCARD_BACK_TEXT));
				String picture= ((String)flashcardsJSON.get(FLASHCARD_PICTURE));
				String category= ((String)flashcardsJSON.get(FLASHCARD_CATEGORY));
				String difficulty= ((String)flashcardsJSON.get(FLASHCARD_DIFFICULTY));
				ArrayList<StudentUser> assignedStudents = (ArrayList)flashcardsJSON.get(FLASHCARD_ASSIGNED_STUDENTS);
				

				flashcards.add(new Flashcard(cardID, frontText, backText, picture, category, difficulty));
			}
			
			return flashcards;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flashcards;
	}

	/**
	 * temparary main method to just check to make sure code works
	 * @param args
	 */
	public static void main(String[] args) {

		// Test Users
		ArrayList<User> users = loadUsers();
        if (users == null || users.isEmpty()) {
            System.out.println("No users loaded. Check the JSON file or parsing logic.");
        } else {
            System.out.println("Loaded " + users.size() + " users.");
        }

        
        // Test songs
        ArrayList<Song> songs = loadSongs();
        if (songs == null || songs.isEmpty()) {
            System.out.println("No songs loaded. Check the JSON file or parsing logic.");
        } else {
            System.out.println("Loaded " + songs.size() + " songs.");
		}	

		// Test playing first song 
		Song firstSong = songs.get(0);
		firstSong.playSong();

		// Test playing second song with custom tempo
		Song secondSong = songs.get(1);
        secondSong.playSongWithTempo(100);
        

		//Test flashcards
		ArrayList<Flashcard> flashcard= loadFlashcards();
		if (flashcard == null || flashcard.isEmpty()) {
            System.out.println("No flashcards loaded. Check the JSON file or parsing logic.");
        } else {
            System.out.println("Loaded " + flashcard.size() + " flashcards.");
        }
	
		// Test checkAnswer method on a flashcard
       if (!flashcard.isEmpty()) {
    Flashcard testCard = flashcard.get(0);
    System.out.println("Testing checkAnswer for flashcard: " + testCard.getFrontText());
    
    // Example test input
    String userInput = testCard.getBackText();
    boolean isCorrect = testCard.checkAnswer(userInput);
    
    System.out.println("User input: " + userInput);
    System.out.println("Check Answer Result: " + isCorrect);
}

	}

}



