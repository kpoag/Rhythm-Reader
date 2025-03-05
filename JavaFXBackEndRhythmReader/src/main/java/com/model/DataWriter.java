package com.model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static boolean saveUsers() {
        // Users users = UserList.getInstance();
        // ArrayList<User> userList = users.getUsers();
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("johndoe","John","Doe", 15, "102-683-2093"));
        
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_TEMP_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName().toString());
        userDetails.put(USER_LAST_NAME, user.getLastName().toString());
        userDetails.put(USER_AGE, user.getAge());
        userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber().toString());
        
        return userDetails;
    }

    
    public static boolean saveSongs() {
        return false;
    }
    
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
