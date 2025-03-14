package com.model;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class SongLoader extends SongConstants{
	
	public static ArrayList<Song> loadSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		try {
			FileReader reader = new FileReader(SONG_FILE_NAME);
			JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);
			System.out.println("Number of songs in JSON: " + songsJSON.size());

			for(int i=0; i < songsJSON.size(); i++) {
				System.out.println("inside at index: "+ i);
				JSONObject songJSON = (JSONObject)songsJSON.get(i);
				String songID= ((String)songJSON.get(SONG_SONG_ID));
				String songTitle =((String)songJSON.get(SONG_SONGTITLE));
				String artist = (String)songJSON.get(SONG_ARTIST);
				Genre genre = Genre.valueOf((String)songJSON.get(SONG_GENRE));
				DifficultyLevel difficulty = DifficultyLevel.valueOf((String)songJSON.get(SONG_DIFFICULTY));
				String instrument = (String)songJSON.get(SONG_INSTRUMENT);
				double rating = (double)songJSON.get(SONG_RATING);
				//ArrayList<Measure> measures= (ArrayList)songJSON.get(SONG_MEASURES);

				System.out.println("Song " + i + " -> id: " + songID + ", title: " + songTitle 
                       + ", artist: " + artist + ", genre: " + genre + ", difficulty: " + difficulty);
    
    			// Check if any field is null or unexpected
    			if ( songID == null || songTitle == null || artist == null || genre == null) {
        			System.out.println("Warning: One or more fields are null for song index " + i);
    			}
    
				
				songs.add(new Song(songID, songTitle, artist, genre, difficulty, instrument, rating));
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
        System.out.println("ID: " + testSong.getSongID());
        System.out.println("Title: " + testSong.getsongTitle());
        System.out.println("Artist: " + testSong.getArtist());
        System.out.println("Genre: " + testSong.getGenre());
        System.out.println("Difficulty: " + testSong.getDifficulty());
		System.out.println("Instument: " + testSong.getInstrument()); 
		System.out.println("Rating: " + testSong.getRating());
		//System.out.println("Measures: " + testSong.getMeasures());
    }
}
