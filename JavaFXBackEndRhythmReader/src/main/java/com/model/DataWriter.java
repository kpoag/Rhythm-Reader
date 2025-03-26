package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataWriter for Rhythm Reader Application
 * @author Kristen Mack
 */
public class DataWriter extends DataConstants {

    /**
     * saveUsers method for DataWriter
     * @return Boolean of whether Users are saved in program correctly
     */
    public static boolean saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();

        JSONArray jsonUsers = new JSONArray();

        System.out.println("Total users in UserList: " + users.getUsers().size());
        
        Set<String> uuid = new HashSet<>();
        for (User user : userList) {
            if (!uuid.contains(user.getId().toString())) {
                jsonUsers.add(getUserJSON(user));
                uuid.add(user.getId().toString());
            }
            else {
                System.out.println("Duplicate user: " + user.getId());
            }
        }
        System.out.println("Writing " + userList.size() + " users to file.");

        try (FileWriter file = new FileWriter(USER_TEMP_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Acesses User JSON and separates into two private methods - getStudentJSON and getTeacherJSON
     * @return JSONObject of new UserJSON
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        if (user.isStudent()) {
            if (user instanceof StudentUser) {
            userDetails.putAll(getStudentJSON((StudentUser) user));
            }
        }
        else if (user.isTeacher()) {
            if (user instanceof TeacherUser) {
            userDetails.putAll(getTeacherJSON((TeacherUser) user));
            }
        }
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_POINTS, user.getPoints());
        userDetails.put(USER_BADGES, user.getBadges());
        userDetails.put(USER_FRIENDS, user.getFriendNames(userDetails));
        
        return userDetails;
    }   
    
    /**
     * getStudentJSON method for getUserJSON - establishes Student
     * @param student new StudentUser
     * @return JSONObject of new Student
     */
    private static JSONObject getStudentJSON(StudentUser student) {
            JSONObject studentDetails = new JSONObject();
            studentDetails.put(USER_PROGRESS, student.getProgress());
            studentDetails.put(USER_SKILL_LEVEL, student.getSkillLevel());
            studentDetails.put(USER_CLASSROOM, student.getClasses());
            studentDetails.put(USER_GRADES, student.getGrade());
            studentDetails.put(USER_ASSIGNED_FLASHCARDS, student.getAssignedFlashcards());
            studentDetails.put(USER_CURRENT_FLASHCARD, student.getCurrentFlashcard());
            studentDetails.put(USER_COMPLETED_FLASHCARDS, student.getCompletedFlashcards());
            studentDetails.put(USER_DEADLINES, student.getDeadlines());
        return studentDetails;
    }
    
    /**
     * getTeacherJSON method for getUserJSON - establishes Teacher
     * @param teacher new TeacherUser
     * @return JSONObject of new Teacher
     */

    private static JSONObject getTeacherJSON(TeacherUser teacher) {
        JSONObject teacherDetails = new JSONObject();
        teacherDetails.put(USER_TEACHING_CLASSES, teacher.getTeachingClasses());
        teacherDetails.put(USER_GRADEBOOK, teacher.getGradebook());
        return teacherDetails;
    }   

    /**
     * saveSongs method for DataWriter
     * @return Boolean of whether Songs are saved in program correctly
     */
    public static boolean saveSongs() {
      System.out.println("saveSongs() method called."); 
      SongList songs = SongList.getInstance();
      ArrayList<Song> songList = songs.getSongs();
      
      System.out.println("Number of songs: " + songList.size());

      JSONArray jsonSongs = new JSONArray();

       for (int i = 0; i < songList.size(); i++) {
           jsonSongs.add(getSongJSON(songList.get(i)));
       }

       try (FileWriter file = new FileWriter(SONG_FILE_NAME)) {
           file.write(jsonSongs.toJSONString());
           file.flush();
           System.out.println("Songs written to " + SONG_FILE_NAME);
           return true;
       }
       catch(IOException e) {
           e.printStackTrace();
           return false;
       }
    }
  
    /**
     * Accesses Song JSON
     * @return JSONObject of new SongJSON
     */
    public static JSONObject getSongJSON(Song song) {
        JSONObject songDetails = new JSONObject();
        songDetails.put(SONG_SONG_ID, song.getSongID().toString());
        songDetails.put(SONG_SONGTITLE, song.getSongTitle());
        songDetails.put(SONG_ARTIST, song.getArtist());
        songDetails.put(SONG_GENRE, song.getGenre());
        songDetails.put(SONG_DIFFICULTY, song.getDifficulty());
        songDetails.put(SONG_INSTRUMENT, song.getInstrument());
        songDetails.put(SONG_RATING, song.getRating());
        songDetails.put(SONG_TIME_SIGNATURE, song.getTimeSignature());
        songDetails.put(SONG_TEMPO, song.getTempo());
        songDetails.put(SONG_MEASURES, song.getMeasures());
        return songDetails;
    }

    /**
     * saveFlashcards method for DataWriter
     * @return Boolean of whether Flashcards are saved in program correctly
     */
    public static boolean saveFlashcards() {
        FlashcardList flashcards = FlashcardList.getInstance();
        ArrayList<Flashcard> flashcardList = flashcards.getFlashcards();

        if (flashcardList.isEmpty()) {
            System.out.println("No flashcards to save");
        }

        JSONArray jsonFlashcards = new JSONArray();

        for (int i = 0; i < flashcardList.size(); i++) {
            jsonFlashcards.add(getFlashcardJSON(flashcardList.get(i)));
        }

        try (FileWriter file = new FileWriter(FLASHCARD_TEMP_FILE_NAME)) {
            file.write(jsonFlashcards.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Accesses Flashcard JSON
     * @return JSONObject of new FlashcardJSON
     */
    public static JSONObject getFlashcardJSON(Flashcard flashcard) {
        JSONObject flashcardDetails = new JSONObject();
        flashcardDetails.put(FLASHCARD_CARD_ID, flashcard.getCardID().toString());
        flashcardDetails.put(FLASHCARD_FRONT_TEXT, flashcard.getFrontText());
        flashcardDetails.put(FLASHCARD_BACK_TEXT, flashcard.getBackText());
        flashcardDetails.put(FLASHCARD_CATEGORY, flashcard.getCategory());
        flashcardDetails.put(FLASHCARD_DIFFICULTY, flashcard.getDifficulty());
        flashcardDetails.put(FLASHCARD_PICTURE, flashcard.getPicture());
        flashcardDetails.put(FLASHCARD_ASSIGNED_STUDENTS, flashcard.getAssignedStudents());
        return flashcardDetails;
    }


    public static void main(String[] args) {
        DataWriter.saveUsers();
        DataWriter.saveSongs();
        DataWriter.saveFlashcards();
    }
}