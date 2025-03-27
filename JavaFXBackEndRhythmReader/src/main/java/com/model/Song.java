package com.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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

            System.out.println("\n===========================================");
            System.out.println(songTitle.toUpperCase());
            System.out.println("By " + artist);
            System.out.println("Time Signature: " + timeSignature);
            System.out.println("Tempo: " + tempo + " BPM");
            System.out.println("===========================================\n");

            int beatsPerMeasure = 4; // Default to 4/4
            if (timeSignature != null && timeSignature.contains("/")) {
                String[] parts = timeSignature.split("/");
                if (parts.length == 2) {
                    try {
                        beatsPerMeasure = Integer.parseInt(parts[0]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid time signature format. Defaulting to 4/4.");
                }
            }
        }


            System.out.println("Sheet Music:");
            for (int i = 0; i < measures.size(); i++) {
                if (i % 4 == 0) {
                    System.out.println(); // New line for every 4 measures
                    System.out.print("| "); // Start of measure line
                }

                Measure measure = measures.get(i);
                if (measure != null) {
                String measurePattern = measure.getJFuguePattern();
                if (measurePattern != null && !measurePattern.isEmpty()) {
                    // Format and print measure content
                    String formattedMeasure = measurePattern.replace(" ", ", ");
                    System.out.print(formattedMeasure + " | ");
                    
                    pattern.add(measurePattern);
                }
            }
        }
            System.out.println("\n");
            
            // Set the tempo
            pattern.setTempo(this.tempo);
            
            // Set the instrument
            if (instrument != null && !instrument.isEmpty()) {
                pattern.setInstrument(getInstrumentCode(instrument));
            }

            // Add a rest to start the pattern (JFugue cuts first note off)
            pattern.add("Rs32 ");
            

            System.out.println("Now Playing...");
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
            System.out.println("\n===========================================");
            System.out.println(songTitle.toUpperCase());
            System.out.println("By " + artist);
            System.out.println("Time Signature: " + timeSignature);
            System.out.println("Tempo: " + customTempo + " BPM (Modified)");
            System.out.println("===========================================\n");

            int beatsPerMeasure = 4; // Default to 4/4
            if (timeSignature != null && timeSignature.contains("/")) {
                String[] parts = timeSignature.split("/");
                if (parts.length == 2) {
                    try {
                        beatsPerMeasure = Integer.parseInt(parts[0]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid time signature: " + timeSignature + ". Using default 4/4.");
                    }
                }
            }
        
            // Print measures in rows of 4
            StringBuilder fullPattern = new StringBuilder();
            fullPattern.append("T").append(customTempo).append(" ");
            fullPattern.append("I").append(getInstrumentCode(instrument)).append(" ");

            if (timeSignature != null && !timeSignature.isEmpty()) {
                fullPattern.append("TIME:").append(timeSignature).append(" ");
            }
        
            System.out.println("Sheet Music:");
            for (int i = 0; i < measures.size(); i++) {
                if (i % 4 == 0) {
                    System.out.println(); // New line for every 4 measures
                    System.out.print("| "); // Start of measure line
            }
            
            Measure measure = measures.get(i);
            if (measure != null) {
                String measurePattern = measure.getJFuguePattern();
                if (measurePattern != null && !measurePattern.isEmpty()) {
                    // Format and print measure content
                    String formattedMeasure = measurePattern.replace(" ", ", ");
                    System.out.print(formattedMeasure + " | ");
                    
                    fullPattern.append(measurePattern).append(" ");
                }
            }
        }
            System.out.println("\n");
            
            System.out.println("Now Playing...");
        
            Player player = new Player();
            player.play(fullPattern.toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error playing song with custom tempo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    
    }

    public boolean playSongWithTempo(int customTempo, String sheetMusicFile) {
        if (measures == null || measures.isEmpty()) {
            System.err.println("No measures to play.");
            return false;
        }
    
        if (customTempo <= 0) {
            System.err.println("Invalid tempo: " + customTempo + ". Using default tempo: " + this.tempo);
            return playSongWithTempo(this.tempo);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sheetMusicFile))) {
            writer.write("===========================================\n");
            writer.write(songTitle.toUpperCase() + "\n");
            writer.write("By " + artist + "\n");
            writer.write("Time Signature: " + timeSignature + "\n");
            writer.write("Tempo: " + customTempo + " BPM (Modified)\n");
            writer.write("===========================================\n\n");
    
            int beatsPerMeasure = 4; // Default to 4/4
            if (timeSignature != null && timeSignature.contains("/")) {
                String[] parts = timeSignature.split("/");
                if (parts.length == 2) {
                    try {
                        beatsPerMeasure = Integer.parseInt(parts[0]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid time signature: " + timeSignature + ". Using default 4/4.");
                    }
                }
            }
    
            // Print measures in rows of 4
            StringBuilder fullPattern = new StringBuilder();
            fullPattern.append("T").append(customTempo).append(" ");
            fullPattern.append("I").append(getInstrumentCode(instrument)).append(" ");
    
            if (timeSignature != null && !timeSignature.isEmpty()) {
                fullPattern.append("TIME:").append(timeSignature).append(" ");
            }
    
            writer.write("Sheet Music:\n");
            for (int i = 0; i < measures.size(); i++) {
                if (i % 4 == 0) {
                    writer.write("\n| ");
                }
                
                Measure measure = measures.get(i);
                if (measure != null) {
                    String measurePattern = measure.getJFuguePattern();
                    if (measurePattern != null && !measurePattern.isEmpty()) {
                        String formattedMeasure = measurePattern.replace(" ", ", ");
                        writer.write(formattedMeasure + " | ");
                        fullPattern.append(measurePattern).append(" ");
                    }
                }
            }
            writer.write("\n\n");
            
            System.out.println("Sheet Music exported to" + sheetMusicFile);
            
            System.out.println("Now Playing...");
            
            Player player = new Player();
            player.play(fullPattern.toString());
            return true;
        } catch (IOException e) {
            System.err.println("Error writing sheet music to file: " + e.getMessage());
            return false;
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
 * Checks if a song matches a given search query.
 * The search is case-insensitive and checks the song's title, artist, genre, and difficulty level.
 *
 * @param q the search query string
 * @return true if the song matches the query in any field, false otherwise
 */
public boolean matches(String q) {
    if (q == null || q.trim().isEmpty()) {
        return false;
    }
    q = q.toLowerCase().trim();

    if (songTitle != null && songTitle.toLowerCase().contains(q)) {
        return true;
    }

    if (artist != null && artist.toLowerCase().contains(q)) {
        return true;
    }

    if (genre != null && genre.toString().toLowerCase().contains(q)) {
        return true;
    }
    
    if(difficulty != null && difficulty.toString().contains(q)) {
        return true;
    }
    return false;
}

/**
 * Searches for songs in the database that match a given query.
 * Loads songs from DataLoader and filters them based on the search query.
 * The search is case-insensitive and looks for matches in title, artist, genre, and difficulty.
 *
 * @param q the search query string
 * @return ArrayList of Song objects that match the search query
 */
    public static ArrayList<Song> searchSongs(String q) {
        ArrayList<Song> results = new ArrayList<>();

        if (q == null || q.trim().isEmpty()) {
            return results;
        }
        ArrayList<Song> songs = DataLoader.loadSongs();
        System.out.println(songs);

        for (Song song : songs) {
            if (song.matches(q)) {
                results.add(song);
            }
        }
        return results;
    
    }

    /** 
     * method thats ask user for info to create a song
     */
    private static Song createUserSong(User user)
    {
        Scanner scanner= new Scanner(System.in);

        String songID = UUID.randomUUID().toString();
        System.out.println("Generated Song ID: " + songID);
        
        System.out.print("Enter song title: ");
        String songTitle = scanner.nextLine();

        //System.out.print("Enter artist: ");
        String artist = user.getUserName();
        
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
                    String jfuguePattern = measure.getJFuguePattern();
        
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
                songJson.put("tempo", this.tempo);
                songJson.put("timeSignature", this.timeSignature);
                songJson.put("instrument", this.instrument);
                songJson.put("rating", this.rating);
                songJson.put("difficulty", this.difficulty.toString()); 
                songJson.put("genre", this.genre.toString()); 
                //songJson.put("artist", this.artist);
                songJson.put("songTitle", this.songTitle);
                songJson.put("songID", this.songID);
        
                // Convert measures to JSON array
                JSONArray measuresJson = new JSONArray();
                for (Measure measure : this.measures) {
                    JSONArray measureNotesJson = new JSONArray();
                    List<Chords> chords = measure.getChords();
        
                    if (chords != null) {
                        for (Chords chord : chords) {
                            if (chord.isChord() && chord.getNotes().size() > 1) {
                                // For chords with multiple notes, create a nested array
                                JSONArray chordNotesJson = new JSONArray();
                                for (Note note : chord.getNotes()) {
                                    chordNotesJson.add(note.toString());
                                }
                                measureNotesJson.add(chordNotesJson);
                            } else {
                                // For single notes, add directly to the measure array
                                if (!chord.getNotes().isEmpty()) {
                                    measureNotesJson.add(chord.getNotes().get(0).toString());
                                }
                            }
                        }
                }
        
                measuresJson.add(measureNotesJson);
            }
            songJson.put("measures", measuresJson);
                
        
            return songJson;
            }
        
        /**
         * Saves the song to a JSON file with proper formatting.
         * Fix Overwriting issue
         * 
         * @param fileName the name of the file to save the song to
         */
        public void saveToJson(String fileName, User user) {
            //JSONObject songJson = this.toJSONObject();
        
            JSONParser parser = new JSONParser();
            JSONArray songList = new JSONArray();
        
            try (FileReader reader = new FileReader(fileName)) {
                Object obj = parser.parse(reader);
                if (obj instanceof JSONArray) {
                    songList = (JSONArray) obj;
                }
            } catch (IOException e) {
                // File doesn't exist or is empty, so start with a new JSON array
                System.out.println("Creating new JSON file.");
            } catch (ParseException e) {
                // File exists but is not valid JSON, so handle the error
                System.err.println("Error parsing existing JSON file: " + e.getMessage());
                System.err.println("Overwriting with new JSON data.");
            }
        
            String username= user.getUserName();
        
            JSONObject songJson = this.toJSONObject();
        
            songJson.put("artist", username);
        
            songList.add(songJson);
        
            // Add the new song to the JSON array
            //songList.add(this.toJSONObject());
        
            
        
            try (FileWriter file = new FileWriter(fileName)) {
                String jsonString = songList.toJSONString();
                // Add indentation and line breaks
                String prettyJson = formatJson(jsonString);
                // fix overwriting issue
                file.append(prettyJson);
                System.out.println("Successfully wrote song to " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing song to file: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
            /**
            * Formats JSON string with proper indentation and line breaks.
            *
            * @param jsonString the JSON string to format
            * @return formatted JSON string
             */
            private String formatJson(String jsonString) {
                StringBuilder formatted = new StringBuilder();
                int indentLevel = 0;
                boolean inQuotes = false;
            
                for (char c : jsonString.toCharArray()) {
                    switch (c) {
                        case '\"':
                        
                            inQuotes = !inQuotes;
                            formatted.append(c);
                            break;
                        
                        case '{':
                        case '[':
                            formatted.append(c);
                            if (!inQuotes) {
                                indentLevel++;
                                formatted.append("\n").append("    ".repeat(indentLevel));
                            }
                            break;
                        
                        case '}':
                        case ']':
                            if (!inQuotes) {
                                indentLevel--;
                                formatted.append("\n").append("    ".repeat(indentLevel));
                            }
                            formatted.append(c);
                            break;
                        
                        case ',':
                            formatted.append(c);
                            if (!inQuotes) {
                                formatted.append("\n").append("    ".repeat(indentLevel));
                            }
                            break;
                        
                        case ':':
                            formatted.append(c);
                            if (!inQuotes) {
                                formatted.append(" ");
                            }
                            break;
                        
                        default:
                            formatted.append(c);
                    }
                }
            
                return formatted.toString();
        }
        
        
            
        
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
        
                DataLoader dataLoader= new DataLoader();
        
                User loggedInUser= getLoggedInUser();
                 
                 
                if(loggedInUser == null)
                {
                    System.out.println("No user logged in.");
                    return;
                }
             
                Song newSong = createUserSong(loggedInUser);
                
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
                                   "Time Signature: " + newSong.getTimeSignature());
        
                scanner.close();
                                   
                System.out.println("\nMeasures:");
                ArrayList<Measure> measures = newSong.getMeasures();
                for (int i = 0; i < measures.size(); i++) {
                    System.out.println("Measure " + (i + 1) + ": " + measures.get(i).getJFuguePattern());
                }
                
                String fileName = SONG_FILE_NAME;
                
                newSong.saveToJson(fileName, loggedInUser);
                
                // Read back the file to verify its contents.
                System.out.println("Reading contents of " + fileName + ":");
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading the test file: " + e.getMessage());
                    e.printStackTrace();
                }
        
                
            }

            private static User getLoggedInUser() {
                
                return new User("testuser", "Test", "User", "test@example.com", "password", 0, new ArrayList<>(), new ArrayList<>());
            }
        
            
    




}