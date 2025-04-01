package com.model;


public abstract class DataConstants {
	protected static final String USER_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/users.json";
	protected static final String USER_TEMP_FILE_NAME = "/data/users_temp.json";
	protected static final String USER_ID = "id";
	protected static final String USER_USER_NAME = "username";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_EMAIL= "email";
	protected static final String USER_PASSWORD= "password";
	protected static final String USER_POINTS= "points";
	protected static final String USER_CLASSROOM= "classes";
	protected static final String USER_COMPLETED_FLASHCARDS= "completedFlashcards";
	protected static final String USER_ASSIGNED_FLASHCARDS= "assignedFlashcards";
	protected static final String USER_CURRENT_FLASHCARD= "currentFlashcard";
	protected static final String USER_DEADLINES= "deadlines";
	protected static final String USER_GRADES= "grade";
	protected static final String USER_BADGES= "badges";
	protected static final String USER_PROGRESS= "progress";
	protected static final String USER_SKILL_LEVEL= "skillLevel";
	protected static final String USER_TEACHING_CLASSES= "teachingClasses";
	protected static final String USER_GRADEBOOK= "gradebook";
	protected static final String USER_FRIENDS= "friends";

	protected static final String SONG_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/songs.json";
	protected static final String SONG_TEMP_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/songs_temp.json";
	protected static final String SONG_SONG_ID = "songID";
	protected static final String SONG_SONGTITLE = "songTitle";
	protected static final String SONG_ARTIST = "artist";
	protected static final String SONG_GENRE = "genre";
	protected static final String SONG_DIFFICULTY = "difficulty";
	protected static final String SONG_INSTRUMENT = "instrument";
	protected static final String SONG_RATING = "rating";
    protected static final String SONG_MEASURES = "measures";
	protected static final String SONG_TIME_SIGNATURE = "timeSignature";
	protected static final String SONG_TEMPO = "tempo";

	protected static final String FLASHCARD_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/flashcards.json";
	protected static final String FLASHCARD_TEMP_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/flashcards_temp.json";
	protected static final String FLASHCARD_CARD_ID = "cardID";
	protected static final String FLASHCARD_FRONT_TEXT = "frontText";
	protected static final String FLASHCARD_BACK_TEXT = "backText";
	protected static final String FLASHCARD_CATEGORY = "category";
	protected static final String FLASHCARD_DIFFICULTY = "difficulty";
	protected static final String FLASHCARD_PICTURE = "picture";
	protected static final String FLASHCARD_ASSIGNED_STUDENTS = "assignedStudents";


	public static boolean isJUnitTest() {  
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
		  if (element.getClassName().startsWith("org.junit.")) {
			return true;
		  }           
		}
		return false;
	  }

}