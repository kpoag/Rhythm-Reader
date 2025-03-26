package com.model;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.pattern.Pattern;  
import org.jfugue.player.Player;  

import java.io.FileWriter;
import java.io.IOException;
import java.time.chrono.HijrahChronology;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.UUID;


/**
 * Represents a song with a title, artist, genre, difficulty, instrument,
 * rating, tempo, time signature, and a list of measures.
 * @author Jaylen & Kennedy
 */
public class Song {
    private String songID;
    private String songTitle;
    private String artist;
    private Genre genre;
    private DifficultyLevel difficulty;
    private String instrument;
    private double rating;
    private int tempo;
    private String timeSignature;
    private ArrayList<Measure> measures;

    /**
     * Constructs a Song with the specified details.
     *
     * @param songID        the song's unique ID
     * @param songTitle     the title of the song
     * @param artist        the artist of the song
     * @param genre         the genre of the song
     * @param difficulty    the difficulty level of the song
     * @param instrument    the instrument used for the song
     * @param rating        the rating of the song
     * @param tempo         the tempo (BPM) of the song
     * @param timeSignature the time signature of the song (e.g., "4/4")
     */
    public Song(String songID, String songTitle, String artist, Genre genre, 
    DifficultyLevel difficulty, String instrument, double rating, int tempo, String timeSignature) {
        this.songID = songID;
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        this.difficulty = difficulty;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
        this.instrument = instrument;
        this.rating = rating;
        this.measures = new ArrayList<>();
    }

    /**
     * Adds a measure to the song.
     *
     * @param measure measure to add
     * @return true if measure was added, false otherwise
     */
    public boolean addMeasure(Measure measure) {
        if (measure == null) return false;
        return measures.add(measure);
    }

    /**
     * Returns the song's unique ID.
     *
     * @return song ID
     */
    public String getSongID() {
        return songID;
    }
    
    /**
     * Sets the song's unique ID.
     *
     * @param songID new song ID
     * @return true if set successfully, false if songID is null
     */
    public boolean setSongID(String songID) {
        if (songID == null) return false;
        this.songID = songID;
        return true;   
    }
    
    /**
     * Returns the song's rating.
     *
     * @return rating
     */
    public double getRating() {
        return rating;
    }

     /**
      * Sets the song's rating.
      *
      * @param rating the new rating (must be between 0.0 and 10.0)
      * @return true or false depending on if the rating was set
      */
    public boolean setRating(double rating) {
        if (rating < 0.0 || rating > 10.0) {
            return false;
        }
        this.rating = rating;
        return true;
    }
    
    /**
     * Returns the song's tempo (BPM).
     *
     * @return tempo
     */
    public int getTempo() {
        return tempo;
    }
    
    /**
     * Sets the song's tempo (BPM).
     *
     * @param tempo new tempo (must be non-negative)
     * @return true if set successfully, false otherwise
     */

    public boolean setTempo(int tempo) {
        if (tempo < 0) return false;
        this.tempo = tempo;
        return true;
    }
    
    /**
     * Returns the song's time signature.
     *
     * @return time signature
     */
    public String getTimeSignature() {
        return timeSignature;
    }
    
    /**
     * Sets the song's time signature.
     *
     * @param timeSignature new time signature
     * @return true if set successfully, false if timeSignature is null
     */
    public boolean setTimeSignature(String timeSignature) {
        if (timeSignature == null) return false;
        this.timeSignature = timeSignature;
        return true;
    }
    
    /**
     * Changes the tempo of the measure.
     *
     * @param newTempo the new tempo (beats per minute) to set
     * @return the updated tempo
     */
    public int changeTempo(int newTempo) {
        if (newTempo > 0) {
            this.tempo = newTempo;
        }
        return this.tempo;
    }
    
    /**
     * Plays a song with metronome
     *
     * @return true if metronome is played, false otherwise
     */
    public boolean playWithMetronome() {
        // TO DO: Implement metronome functionality
        return true;
    }
    
    /**
     * Gets the song's title
     *
     * @return title of a song
     */
    public String getSongTitle() {
        return songTitle;
    }

    /**
     * Sets the song's title
     *
     * @return true or false if title is set
     */
    public boolean setSongTitle(String songTitle) {
        if (songTitle == null) return false;
        this.songTitle = songTitle;
        return true;    
    }
    
    /**
     * Gets the song's artist
     *
     * @return Artist of a song
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * Set's the song's artist 
     *
     * @return Artist of the song
     */
    public boolean setArtist(String artist) {
        if (artist == null) return false;
        this.artist = artist;
        return true;
    }
    
    /**
     * Gets the song's difficulty level
     *
     * @return difficulty of the song
     */
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
    
    /**
     * Sets the song's difficulty level
     *
     * @return true or false if difficulty is set
     */
    public boolean setDifficulty(DifficultyLevel difficulty) {
        if (difficulty == null) return false;
        this.difficulty = difficulty;
        return true;
    }
    
    /**
     * Gets the instrument used in the song
     *
     * @return instrument used in the song
     */
    public String getInstrument() {
        return instrument;
    }
    
    /**
     * Sets the instrument used in the song
     *
     * @return true or false if instrument is set
     */
    public boolean setInstrument(String instrument) {
        if (instrument == null) return false;
        this.instrument = instrument;
        return true;
    }
    
    /**
     * Gets the measure's in the song
     *
     * @return list of measures in the song
     */
    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    /**
     * Sets the measure's in the song
     *
     * @return true or false if measures are set
     */
    public boolean setMeasures(ArrayList<Measure> measures) {
        if (measures == null) return false;
        this.measures = measures;
        return true;
    }
    
    /**
     * Gets song genre
     *
     * @return genre of song
     */
    public Genre getGenre() {
        return genre;
    }
    
    /**
     * Sets song genre
     *
     * @return true or false if genre is set
     */
    public boolean setGenre(Genre genre) {
        if (genre == null) return false;
        this.genre = genre;
        return true;
    }
    
    /**
     * Plays the song with the current tempo setting.
     * 
     * @return true if the song was played successfully, false otherwise
     */
    public boolean playSong() {
        try {
            Player player = new Player();
            Pattern pattern = new Pattern();
            
            // Set the tempo
            pattern.setTempo(this.tempo);
            
            // Set the instrument
            if (instrument != null && !instrument.isEmpty()) {
                pattern.setInstrument(getInstrumentCode(instrument));
            }

            // Add a rest to start the pattern (JFugue cuts first note off)
            pattern.add("Rs32 ");
            
            // Add each measure's pattern
            for (Measure measure : measures) {
                if (measure != null) {
                    String measurePattern = measure.getJFuguePattern();
                    if (measurePattern != null && !measurePattern.isEmpty()) {
                        pattern.add(measurePattern);
                    }
                }
            }

            System.out.println("Playing " + songTitle + " with default tempo: " + tempo + " BPM");
            // Play the pattern using JFugue player
            player.play(pattern);
            return true;
        } catch (Exception e) {
            System.err.println("Error playing song: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Plays the song with a specified tempo.
     * 
     * @param customTempo tempo to use for playback (in BPM)
     * @return true if the song was played successfully, false otherwise
     */
    public boolean playSongWithTempo(int customTempo) {
        if (measures == null || measures.isEmpty()) {
            System.err.println("No measures to play.");
            return false;
        }

        if (customTempo <= 0) {
            System.err.println("Invalid tempo: " + customTempo + ". Using default tempo: " + this.tempo);
            return playSongWithTempo(this.tempo);
        }
        
        try {
            StringBuilder fullPattern = new StringBuilder();

            // Sets tempo in the pattern
            fullPattern.append("T").append(customTempo).append(" ");
            
            // Sets instrument in the pattern
            int instrumentCode = getInstrumentCode(instrument);
            fullPattern.append("I").append(instrumentCode).append(" ");
            
            
            // Add time signature if available
            if (timeSignature != null && !timeSignature.isEmpty()) {
                fullPattern.append("TIME:").append(timeSignature).append(" ");
            }
            
            // Append each measure's pattern to full pattern
            for (Measure measure : measures) {
                if (measure != null) {
                    String measurePattern = measure.getJFuguePattern();
                    if (measurePattern != null && !measurePattern.isEmpty()) {
                        fullPattern.append(measurePattern).append(" ");
                    }
                }
            }
            
            System.out.println("Playing " + songTitle + " with tempo: " + customTempo + " BPM");
        
            Player player = new Player();
            player.play(fullPattern.toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error playing song with custom tempo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    
    }
    
    /**
     * Creates a JFugue pattern for the song without playing it.
     * 
     * @param customTempo tempo to use for the pattern (in BPM)
     * @return JFugue pattern for the song
     */
    public Pattern createSongPattern(int customTempo) {
        Pattern pattern = new Pattern();
        
        // Use custom tempo if provided, otherwise use default tempo
        int tempoToUse = (customTempo > 0) ? customTempo : this.tempo;
        pattern.setTempo(tempoToUse);
        
        // Set the instrument
        if (instrument != null && !instrument.isEmpty()) {
            pattern.setInstrument(getInstrumentCode(instrument));
        }
        
        // Add each measure's pattern
        for (Measure measure : measures) {
            if (measure != null) {
                String measurePattern = measure.getJFuguePattern();
                if (measurePattern != null && !measurePattern.isEmpty()) {
                    pattern.add(measurePattern);
                }
            }
        }
        
        return pattern;
    }
    
    /**
     * Maps instrument names to JFugue instrument codes.
     * 
     * @param instrumentName name of the instrument
     * @return JFugue instrument code
     */
    private int getInstrumentCode(String instrumentName) {
        // Default to piano (0) if instrument not found
        if (instrumentName == null) return 0;
        
        switch (instrumentName.toLowerCase()) {
            case "piano": return 0;
            case "guitar": return 24;
            case "bass": return 32;
            case "violin": return 40;
            case "flute": return 73;
            case "trumpet": return 56;
            case "saxophone": return 65;
            case "drums": return 118;
            default: return 0;
        }
    }

    /** 
     * method thats ask user for info to create a song
     */
    private static Song createUserSong()
    {
        Scanner scanner= new Scanner(System.in);

        String songID = UUID.randomUUID().toString();
        System.out.println("Generated Song ID: " + songID);
        
        System.out.print("Enter song title: ");
        String songTitle = scanner.nextLine();

        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();

        Genre genre = Genre.POP;  
        DifficultyLevel difficulty = DifficultyLevel.BEGINNER;  
        String instrument = "piano";
        double rating = 5.0; 
        int tempo = 120;
        String timeSignature = "4/4";

        Song song= new Song(songID, songTitle, artist, genre,  difficulty, 
        instrument, rating, tempo, timeSignature);

        System.out.println("Now, let's add measures to the song.");
        while (true) {
            System.out.print("Do you want to add a measure? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
            
            System.out.print("Enter chords for measure separated by commas (if any, leave empty if none): ");
            String chordsInput = scanner.nextLine();
            List<Chords> chordsForMeasure = new ArrayList<>();
            if (!chordsInput.isEmpty()) {
    
                String[] chordStrings = chordsInput.split(",");
                for (String chordStr : chordStrings) {
                    String trimmedChordStr = chordStr.trim();
                    Note note= Note.fromString(trimmedChordStr);
                    if(note != null)
                    {
                        List<Note> defaultNotes = new ArrayList<Note>();
                        defaultNotes.add(note);
                        Notetype chordNoteType= note.getNoteType();
                        Chords chord = new Chords(defaultNotes, trimmedChordStr, "major", chordNoteType, false);
                        chordsForMeasure.add(chord);
                    }
                    else
                    {
                        System.out.println("Invalid note format: " + trimmedChordStr);
                    }
                    
                    
    }
}

            System.out.print("Enter beats per measure: ");
            String beats = scanner.nextLine();

            System.out.print("Enter dynamic markings: ");
            String dynamics = scanner.nextLine();
            
            Measure measure = new Measure(chordsForMeasure, beats , dynamics);
            song.addMeasure(measure);
        }
        return song;
    }

    private static final String SONG_FILE_NAME = "JavaFXBackEndRhythmReader/src/main/java/com/data/songs.json";

    /**
    * Converts the Song object to a JSON object.
    *
    * @return a JSONObject representing the song
    */
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject songJson = new JSONObject();
        songJson.put("songID", this.songID);
        songJson.put("songTitle", this.songTitle);
        songJson.put("artist", this.artist);
        songJson.put("genre", this.genre.toString()); 
        songJson.put("difficulty", this.difficulty.toString()); 
        songJson.put("instrument", this.instrument);
        songJson.put("rating", this.rating);
        songJson.put("tempo", this.tempo);
        songJson.put("timeSignature", this.timeSignature);

        // Convert measures to JSON array
        JSONArray measuresJson = new JSONArray();
        for (Measure measure : this.measures) {
            measuresJson.add(measure.toJSONObject()); 
        }
        songJson.put("measures", measuresJson);

        return songJson;
    }

     /**
     * Saves the song to a JSON file.
     *
     * @param fileName the name of the file to save the song to
     */
    public void saveToJson(String fileName) {
        JSONObject songJson = this.toJSONObject();

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(songJson.toJSONString());
            System.out.println("Successfully wrote song to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing song to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Song newSong = createUserSong();
        
        // print the song details or perform assertions to check if the song was created correctly
        System.out.println("Song Details:\n" +
                           "ID: " + newSong.getSongID() + "\n" +
                           "Title: " + newSong.getSongTitle() + "\n" +
                           "Artist: " + newSong.getArtist() + "\n" +
                           "Genre: " + newSong.getGenre() + "\n" +
                           "Difficulty: " + newSong.getDifficulty() + "\n" +
                           "Instrument: " + newSong.getInstrument() + "\n" +
                           "Rating: " + newSong.getRating() + "\n" +
                           "Tempo: " + newSong.getTempo() + "\n" +
                           "Time Signature: " + newSong.getTimeSignature() + "\n" +
                           "Measures: " + newSong.getMeasures());

        scanner.close();
    }
    




}