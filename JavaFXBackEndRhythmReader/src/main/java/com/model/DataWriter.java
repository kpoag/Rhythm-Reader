package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static boolean saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        // ArrayList<User> userList = new ArrayList<>();
        // userList.add(new User(""));

        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_TEMP_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /*
     * separate into two private methods - getStudentJSON and getTeacherJSON and keep getUserJSON
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        
        /*userDetails.put(USER_POINTS, user.getPoints());
        userDetails.put(USER_CLASSROOM, user.getClassroom());
        userDetails.put(USER_ASSIGNED_MODULES, user.getAssignedModules());
        userDetails.put(USER_COMPLETED_MODULES, user.getCompleteddModules());
        userDetails.put(USER_CURRENT_MODULE, user.getCurrentModule());
        userDetails.put(USER_RECOMMENDED_MODULES, user.getRecommendedModules());
        userDetails.put(USER_DEADLINES, user.getDeadlines());
        userDetails.put(USER_GRADES, user.getGrades());
        userDetails.put(USER_BADGES, user.getBadges());
        userDetails.put(USER_PROGRESS, user.getProgress());
        userDetails.put(USER_SKILL_LEVEL, user.getskillLevel());
        userDetails.put(USER_FRIENDS, user.getFriends());
        */
        if (userDetails instanceof StudentUser) {

        }

        return userDetails;
    }

    private static JSONObject getStudentJSON(StudentUser student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(USER_POINTS, student.getPoints());

        return studentDetails;
    }

    /*
    public static boolean saveSongs() {
        SongList songs = SongList.getInstance();
        ArrayList<Song> songList = songs.g();
       // ArrayList<Song> songList = new ArrayList<>();
       // songList.add(new User(""));
       
       JSONArray jsonSongs = new JSONArray();

       for (int i = 0; i < songList.size(); i++) {
           jsonSongs.add(getSongJSON(songList.get(i)));
       }

       try (FileWriter file = new FileWriter(SONG_TEMP_FILE_NAME)) {
           file.write(jsonSongs.toJSONString());
           file.flush();
           return true;
       }
       catch(IOException e) {
           e.printStackTrace();
           return false;
       }
    }
     */
 /* 
    public static JSONObject getSongJSON(Song song) {
        JSONObject songDetails = new JSONObject();
        songDetails.put(SONG_, songDetails)

        return songDetails;
    }
     */

 /*
    public static boolean saveFlashcards() {
        return true;
    }
     */
    public static void main(String[] args) {
        DataWriter.saveUsers();
    }
}
