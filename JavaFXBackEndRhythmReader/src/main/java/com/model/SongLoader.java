package com.model;

import java.io.FileReader;
import java.util.ArrayList;
//import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class SongLoader extends SongConstants{
	
	public static ArrayList<Song> loadSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		try {
			FileReader reader = new FileReader(SONG_FILE_NAME);
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String  songTitle =((String)personJSON.get(SONG_SONGTITLE));
				String artist = (String)personJSON.get(SONG_ARTIST);
				Genre genre = (Genre)personJSON.get(SONG_GENRE);
				DifficultyLevel difficulty = (DifficultyLevel)personJSON.get(SONG_DIFFICULTY);
				Instrument instrument = (Instrument)personJSON.get(SONG_INSTRUMENT);
				double rating = (double)personJSON.get(SONG_RATING);
				ArrayList<Measure> measures= (ArrayList)personJSON.get(SONG_MEASURES);
				
				songs.add(new Song(songTitle, artist, genre, difficulty, instrument));
			}
			
			return songs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return songs;
	}

	public static void main(String[] args) {
        ArrayList<Song> songs = SongLoader.loadSongs();
        
        // Basic check to see if songs are loaded
        if (songs == null || songs.isEmpty()) {
            System.out.println("No songs loaded. Check the JSON file or parsing logic.");
            return;
        }
        
        // Test by displaying details of the first song.
        Song testSong = songs.get(0);
        System.out.println("\nTesting first song:");
        //System.out.println("ID: " + testSong.getId());
        System.out.println("Title: " + testSong.getsongTitle());
        System.out.println("Artist: " + testSong.getArtist());
        System.out.println("Genre: " + testSong.getGenre());
        System.out.println("Difficulty: " + testSong.getDifficulty());
		System.out.println("Instument: " + testSong.getInstrument()); 
		System.out.println("Rating: " + testSong.getRating());
		System.out.println("Measures: " + testSong.getMeasures());
    }
}
