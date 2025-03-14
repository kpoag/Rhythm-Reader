package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
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

				users.add(new User(id, userName, firstName, lastName, email, password, points, badges, friends));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
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
				//ArrayList<Measure> measures= (ArrayList)songJSON.get(SONG_MEASURES);

				songs.add(new Song(songID, songTitle, artist, genre, difficulty, instrument, rating));
			}
			
			return songs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return songs;
	}

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
	
	}

}



