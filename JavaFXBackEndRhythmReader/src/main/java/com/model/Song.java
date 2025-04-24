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

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


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
    public static Song createUserSong(User user, Scanner scanner)
    {
        //Scanner scanner= new Scanner(System.in);

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
             
                Song newSong = createUserSong(loggedInUser, scanner);
                
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
        
            
public void playSongAsync(Runnable onComplete) {
    new Thread(() -> {
        try {
            playSong();
            if (onComplete != null) {
                Platform.runLater(onComplete);
            }
        } catch (Exception e) {
            System.err.println("Error playing song: " + e.getMessage());
            e.printStackTrace();
        }
    }).start();
}



 public void renderSheetMusic(VBox container) {
        System.out.println("Displaying sheet music for: " + this.songTitle);
        
        if (container == null) {
            System.err.println("Sheet music container is null!");
            return;
        }
        
        container.getChildren().clear();
        
        Label titleLabel = new Label(this.songTitle);
        titleLabel.getStyleClass().add("song-title");
        
        Label artistLabel = new Label("By " + this.artist);
        artistLabel.getStyleClass().add("song-artist");
        
        Label infoLabel = new Label(String.format("Tempo: %d BPM | Time Signature: %s", 
            this.tempo, this.timeSignature));
        infoLabel.getStyleClass().add("song-info");
        
        container.getChildren().addAll(titleLabel, artistLabel, infoLabel);
        
        if (this.measures == null || this.measures.isEmpty()) {
            Label noMeasuresLabel = new Label("No sheet music available for this song");
            noMeasuresLabel.getStyleClass().add("no-measures");
            container.getChildren().add(noMeasuresLabel);
            System.out.println("No measures found for song: " + this.songTitle);
            return;
        }
        
        VBox staffContainer = new VBox(20);
        staffContainer.getStyleClass().add("staff-container");
        staffContainer.setAlignment(Pos.CENTER);
        
        for (int staffStart = 0; staffStart < this.measures.size(); staffStart += 4) {
            Canvas staffCanvas = new Canvas(600, 150);
            staffCanvas.getStyleClass().add("staff-canvas");
            
            drawStaff(staffCanvas, staffStart, Math.min(staffStart + 4, this.measures.size()));
            
            staffContainer.getChildren().add(staffCanvas);
        }
        
        container.getChildren().add(staffContainer);
    }
    
    private void drawStaff(Canvas canvas, int startIndex, int endIndex) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        
        double staffTop = 40;
        double lineSpacing = 10;
        
        for (int i = 0; i < 5; i++) {
            double y = staffTop + i * lineSpacing;
            gc.strokeLine(30, y, canvas.getWidth() - 30, y);
        }
        
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gc.fillText("𝄞", 10, staffTop + 2 * lineSpacing); // Treble clef
        
        String timeSignature = this.measures.get(0).getBeats();
        if (timeSignature != null && !timeSignature.isEmpty()) {
            gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            String[] parts = timeSignature.split("/");
            if (parts.length == 2) {
                gc.fillText(parts[0], 60, staffTop + 2 * lineSpacing - 5);
                gc.fillText(parts[1], 60, staffTop + 3 * lineSpacing + 5);
            }
        }
        
        double measureStartX = 80;
        double measureWidth = (canvas.getWidth() - measureStartX - 30) / (endIndex - startIndex);
        
        for (int i = startIndex; i < endIndex; i++) {
            Measure measure = this.measures.get(i);
            double measureX = measureStartX + (i - startIndex) * measureWidth;
            
            gc.strokeLine(measureX, staffTop, measureX, staffTop + 4 * lineSpacing);
            
            drawMeasureNotes(gc, measure, measureX, measureWidth, staffTop, lineSpacing);
        }
        
        gc.strokeLine(measureStartX + (endIndex - startIndex) * measureWidth, 
                     staffTop, 
                     measureStartX + (endIndex - startIndex) * measureWidth, 
                     staffTop + 4 * lineSpacing);
    }
    
    private void drawMeasureNotes(GraphicsContext gc, Measure measure, double measureX, double measureWidth, 
                                 double staffTop, double lineSpacing) {
        List<Chords> chords = measure.getChords();
        if (chords == null || chords.isEmpty()) {
            return;
        }
        
        double noteSpacing = measureWidth / (chords.size() + 1);
        
        for (int i = 0; i < chords.size(); i++) {
            Chords chord = chords.get(i);
            double noteX = measureX + (i + 1) * noteSpacing;
            
            if (chord.getNotes().isEmpty()) {
                continue;
            }
            
            if (chord.getNotes().size() == 1) {
                Note note = chord.getNotes().get(0);
                drawNote(gc, note, noteX, staffTop, lineSpacing, chord.getNotetype());
            } else {
                for (Note note : chord.getNotes()) {
                    drawNote(gc, note, noteX, staffTop, lineSpacing, chord.getNotetype());
                }
                
                double topNoteY = getNoteYPosition(chord.getNotes().get(0), staffTop, lineSpacing);
                double bottomNoteY = getNoteYPosition(chord.getNotes().get(chord.getNotes().size() - 1), staffTop, lineSpacing);
                gc.strokeLine(noteX - 6, topNoteY, noteX - 6, bottomNoteY);
            }
        }
    }
    
    private void drawNote(GraphicsContext gc, Note note, double x, double staffTop, double lineSpacing, Notetype noteType) {
        double y = getNoteYPosition(note, staffTop, lineSpacing);
        
        drawLedgerLines(gc, x, y, staffTop, lineSpacing);
        
        switch (noteType) {
            case WHOLE_NOTE:
                drawWholeNote(gc, x, y);
                break;
            case HALF_NOTE:
                drawHalfNote(gc, x, y);
                break;
            case QUARTER_NOTE:
                drawQuarterNote(gc, x, y);
                break;
            case EIGHTH_NOTE:
                drawEighthNote(gc, x, y);
                break;
            case SIXTEENTH_NOTE:
                drawSixteenthNote(gc, x, y);
                break;
            case DOTTED_EIGHTH_NOTE:
                drawEighthNote(gc, x, y);
                gc.fillOval(x + 12, y - 2, 4, 4);
                break;
            case WHOLE_REST:
            case HALF_REST:
            case QUARTER_REST:
                drawRest(gc, x, staffTop, lineSpacing, noteType);
                break;
            default:
                drawQuarterNote(gc, x, y); // Default to quarter note
        }
        
        if (note.getModifier() != null && !note.getModifier().isEmpty()) {
            drawAccidental(gc, x, y, note.getModifier());
        }
    }
    
    private double getNoteYPosition(Note note, double staffTop, double lineSpacing) {
        int octave = note.getOctave();
        String pitch = note.getPitch();
        
        int semitones = 0;
        
        semitones += (octave - 4) * 12;
        
        switch (pitch) {
            case "C": semitones += 0; break;
            case "D": semitones += 2; break;
            case "E": semitones += 4; break;
            case "F": semitones += 5; break;
            case "G": semitones += 7; break;
            case "A": semitones += 9; break;
            case "B": semitones += 11; break;
        }
        
        // Adjust for sharps and flats
        if (note.getModifier().equals("#")) {
            semitones += 1;
        } else if (note.getModifier().equals("b")) {
            semitones -= 1;
        }
        

        double steps = semitones / 2.0;
        
        return staffTop + 5 * lineSpacing - steps * (lineSpacing / 2);
    }
    
    private void drawLedgerLines(GraphicsContext gc, double x, double y, double staffTop, double lineSpacing) {
        if (y < staffTop - lineSpacing / 2) {
            for (double ly = staffTop - lineSpacing; ly >= y - lineSpacing / 2; ly -= lineSpacing) {
                gc.strokeLine(x - 10, ly, x + 10, ly);
            }
        }
        
        if (y > staffTop + 4 * lineSpacing + lineSpacing / 2) {
            for (double ly = staffTop + 5 * lineSpacing; ly <= y + lineSpacing / 2; ly += lineSpacing) {
                gc.strokeLine(x - 10, ly, x + 10, ly);
            }
        }
    }
    
    private void drawWholeNote(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.WHITE);
        gc.fillOval(x - 6, y - 4, 12, 8);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x - 6, y - 4, 12, 8);
    }
    
    private void drawHalfNote(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.WHITE);
        gc.fillOval(x - 6, y - 4, 12, 8);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x - 6, y - 4, 12, 8);
        
        gc.strokeLine(x + 6, y, x + 6, y - 30);
    }
    
    private void drawQuarterNote(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 6, y - 4, 12, 8);
        
        gc.strokeLine(x + 6, y, x + 6, y - 30);
    }
    
    private void drawEighthNote(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 6, y - 4, 12, 8);
        
        gc.strokeLine(x + 6, y, x + 6, y - 30);
        
        gc.beginPath();
        gc.moveTo(x + 6, y - 30);
        gc.bezierCurveTo(x + 6, y - 30, x + 20, y - 25, x + 20, y - 15);
        gc.stroke();
    }
    
    private void drawSixteenthNote(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.BLACK);
        gc.fillOval(x - 6, y - 4, 12, 8);
        
        gc.strokeLine(x + 6, y, x + 6, y - 30);
        
        gc.beginPath();
        gc.moveTo(x + 6, y - 30);
        gc.bezierCurveTo(x + 6, y - 30, x + 20, y - 25, x + 20, y - 15);
        gc.stroke();
        
        gc.beginPath();
        gc.moveTo(x + 6, y - 25);
        gc.bezierCurveTo(x + 6, y - 25, x + 20, y - 20, x + 20, y - 10);
        gc.stroke();
    }
    
    private void drawRest(GraphicsContext gc, double x, double staffTop, double lineSpacing, Notetype restType) {
        gc.setFill(Color.BLACK);
        
        switch (restType) {
            case WHOLE_REST:
                // Draw whole rest 
                gc.fillRect(x - 6, staffTop + lineSpacing - 3, 12, 3);
                break;
            case HALF_REST:
                // Draw half rest 
                gc.fillRect(x - 6, staffTop + 2 * lineSpacing, 12, 3);
                break;
            case QUARTER_REST:
                // Draw quarter rest symbol
                gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                gc.fillText("𝄽", x - 5, staffTop + 2 * lineSpacing + 5);
                break;
        }
    }
    
    private void drawAccidental(GraphicsContext gc, double x, double y, String modifier) {
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        if (modifier.equals("#")) {
            gc.fillText("♯", x - 15, y + 5);
        } else if (modifier.equals("b")) {
            gc.fillText("♭", x - 15, y + 5);
        }
    }
    
    private Player metronomePlayer;
    private volatile boolean isMetronomePlaying = false;
    private Thread metronomeThread;
    
    /**
     * Starts the metronome at the song's tempo.
     */
    public void startMetronome() {
        if (metronomePlayer == null) {
            metronomePlayer = new Player();
        }
        
        if (metronomeThread != null && metronomeThread.isAlive()) {
            return;
        }
        
        isMetronomePlaying = true;
        metronomeThread = new Thread(() -> {
            while (isMetronomePlaying) {
                try {
                    metronomePlayer.play("I[Woodblock] A5s");
                    
                    // Calculate delay based on tempo (beats per minute)
                    long delayMillis = (60_000 / tempo); // Convert BPM to milliseconds
                    
                    Thread.sleep(delayMillis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        metronomeThread.setDaemon(true);
        metronomeThread.start();
    }
    
    /**
     * Stops the metronome.
     */
    public void stopMetronome() {
        isMetronomePlaying = false;
        if (metronomeThread != null) {
            metronomeThread.interrupt();
            metronomeThread = null;
        }
    }
    
    /**
     * Plays the song with metronome.
     * 
     * @param onComplete Callback to run when the song finishes playing
     */
    public void playSongWithMetronome(Runnable onComplete) {
        startMetronome();
        
        new Thread(() -> {
            try {
                Thread.sleep(4 * (60_000 / tempo));
                
                playSong();
                
                stopMetronome();
                
                if (onComplete != null) {
                    Platform.runLater(onComplete);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }




}