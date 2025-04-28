package com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.Platform;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import com.model.*;

public class ComposerController implements Initializable {
    
    @FXML private TextField compositionTitleField;
    @FXML private ComboBox<String> timeSignatureSelector;
    @FXML private Slider tempoSlider;
    @FXML private Label tempoValueLabel;
    @FXML private VBox staffContainer;
    @FXML private Canvas staffCanvas;
    @FXML private Label statusLabel;
    @FXML private Label measureCountLabel;
    
    @FXML private ImageView wholeNoteImg;
    @FXML private ImageView halfNoteImg;
    @FXML private ImageView quarterNoteImg;
    @FXML private ImageView eighthNoteImg;
    @FXML private ImageView sixteenthNoteImg;
    @FXML private ImageView wholeRestImg;
    @FXML private ImageView halfRestImg;
    @FXML private ImageView quarterRestImg;
    @FXML private ImageView sharpImg;
    @FXML private ImageView flatImg;

    private RRFacade facade;
    private Song currentComposition;
    private List<Measure> measures;
    private List<PlacedNote> placedNotes = new ArrayList<>();
    private boolean eraseMode = false;
    
    // Class to represent a note placed on the staff
    private class PlacedNote {
        double x;
        double y;
        Notetype noteType;
        String pitch;
        String modifier;
        int octave;
        boolean isRest;
        
        public PlacedNote(double x, double y, Notetype noteType, String pitch, String modifier, int octave, boolean isRest) {
            this.x = x;
            this.y = y;
            this.noteType = noteType;
            this.pitch = pitch;
            this.modifier = modifier;
            this.octave = octave;
            this.isRest = isRest;
        }
        
        public Note toNote() {
            return new Note(modifier, pitch, noteType, false, "", octave, timeSignatureSelector.getValue());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = RRFacade.getInstance();
        
        // Set up tempo slider listener
        tempoSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int tempo = newVal.intValue();
            tempoValueLabel.setText(tempo + " BPM");
            if (currentComposition != null) {
                currentComposition.setTempo(tempo);
            }
        });
        
        initializeComposition();
        setupNoteImages();
        drawStaff();
    }
    
    private void initializeComposition() {
        // Create a new song with default values
        String songID = UUID.randomUUID().toString();
        String title = "New Composition";
        User currentUser = facade.getCurrentUser();
        String artist = (currentUser != null) ? currentUser.getUserName() : "User";
        
        currentComposition = new Song(songID, title, artist, Genre.CLASSICAL, 
                                    DifficultyLevel.BEGINNER, "Piano", 5.0, 
                                    (int) tempoSlider.getValue(), 
                                    timeSignatureSelector.getValue());
        measures = new ArrayList<>();
        
        // Add an initial empty measure
        Measure initialMeasure = new Measure(new ArrayList<>(), timeSignatureSelector.getValue(), "mf");
        measures.add(initialMeasure);
        currentComposition.setMeasures(new ArrayList<>(measures));
        
        compositionTitleField.setText(title);
    }
    
    private void setupNoteImages() {
        // Set user data for each image to identify it during drag operations
        wholeNoteImg.setUserData(Notetype.WHOLE_NOTE);
        halfNoteImg.setUserData(Notetype.HALF_NOTE);
        quarterNoteImg.setUserData(Notetype.QUARTER_NOTE);
        eighthNoteImg.setUserData(Notetype.EIGHTH_NOTE);
        sixteenthNoteImg.setUserData(Notetype.SIXTEENTH_NOTE);
        wholeRestImg.setUserData(Notetype.WHOLE_REST);
        halfRestImg.setUserData(Notetype.HALF_REST);
        quarterRestImg.setUserData(Notetype.QUARTER_REST);
        sharpImg.setUserData("#");
        flatImg.setUserData("b");
    }
    
    private void drawStaff() {
        GraphicsContext gc = staffCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, staffCanvas.getWidth(), staffCanvas.getHeight());
        
        // Draw staff lines
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        
        double staffTop = 40;
        double lineSpacing = 10;
        
        // Draw 5 staff lines
        for (int i = 0; i < 5; i++) {
            double y = staffTop + i * lineSpacing;
            gc.strokeLine(30, y, staffCanvas.getWidth() - 30, y);
        }
        
        // Draw treble clef
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gc.fillText("𝄞", 10, staffTop + 2 * lineSpacing);
        
        // Draw time signature
        String timeSignature = timeSignatureSelector.getValue();
        if (timeSignature != null && !timeSignature.isEmpty()) {
            gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            String[] parts = timeSignature.split("/");
            if (parts.length == 2) {
                gc.fillText(parts[0], 60, staffTop + 2 * lineSpacing - 5);
                gc.fillText(parts[1], 60, staffTop + 3 * lineSpacing + 5);
            }
        }
        
        // Draw measure lines
        double measureStartX = 80;
        double measureWidth = 150;
        for (int i = 0; i <= measures.size(); i++) {
            double x = measureStartX + i * measureWidth;
            gc.strokeLine(x, staffTop, x, staffTop + 4 * lineSpacing);
        }
        
        // Draw placed notes
        for (PlacedNote note : placedNotes) {
            drawNote(gc, note);
        }
        
        // Draw erase mode indicator if needed
        if (eraseMode) {
            gc.setStroke(Color.RED);
            gc.strokeRect(0, 0, staffCanvas.getWidth(), 5);
        }
        
        measureCountLabel.setText("Measures: " + measures.size());
    }
    
    private void drawNote(GraphicsContext gc, PlacedNote note) {
        if (note.isRest) {
            drawRest(gc, note);
            return;
        }
        
        double x = note.x;
        double y = note.y;
        
        // Draw ledger lines if needed
        drawLedgerLines(gc, x, y);
        
        // Draw the note based on its type
        switch (note.noteType) {
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
            default:
                drawQuarterNote(gc, x, y);
                break;
        }
        
        // Draw accidental if present
        if (note.modifier != null && !note.modifier.isEmpty()) {
            drawAccidental(gc, x, y, note.modifier);
        }
    }
    
    // Drawing methods adapted from Song.java
    private void drawLedgerLines(GraphicsContext gc, double x, double y) {
        double staffTop = 40;
        double lineSpacing = 10;
        
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
    
    private void drawRest(GraphicsContext gc, PlacedNote rest) {
        double x = rest.x;
        double staffTop = 40;
        double lineSpacing = 10;
        
        gc.setFill(Color.BLACK);
        
        switch (rest.noteType) {
            case WHOLE_REST:
                gc.fillRect(x - 6, staffTop + lineSpacing - 3, 12, 3);
                break;
            case HALF_REST:
                gc.fillRect(x - 6, staffTop + 2 * lineSpacing, 12, 3);
                break;
            case QUARTER_REST:
                gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                gc.fillText("𝄽", x - 5, staffTop + 2 * lineSpacing + 5);
                break;
            default:
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
    
    @FXML
    void handleDragStart(MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        Object userData = source.getUserData();
        
        if (userData == null) {
            return;
        }
        
        // Create drag content based on the type of element
        String dragData;
        if (userData instanceof Notetype) {
            Notetype type = (Notetype) userData;
            if (source.getStyleClass().contains("draggable-rest")) {
                dragData = "REST:" + type;
            } else {
                dragData = type.toString();
            }
        } else if (userData instanceof String) {
            dragData = "ACCIDENTAL:" + userData;
        } else {
            return;
        }
        
        // Start the drag operation
        Dragboard db = source.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.putString(dragData);
        db.setContent(content);
        
        event.consume();
    }
    
    @FXML
    void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY);
        }
        event.consume();
    }
    
    @FXML
    void handleDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        
        if (db.hasString()) {
            String data = db.getString();
            double x = event.getX();
            double y = event.getY();
            
            if (data.startsWith("REST:")) {
                // Handle rest placement
                String restTypeStr = data.substring(5);
                Notetype restType = Notetype.valueOf(restTypeStr);
                
                PlacedNote rest = new PlacedNote(x, y, restType, "R", "", 4, true);
                placedNotes.add(rest);
                success = true;
                
                statusLabel.setText("Rest placed: " + restTypeStr);
            } else if (data.startsWith("ACCIDENTAL:")) {
                // Handle accidental placement
                String accidental = data.substring(11);
                
                // Find the nearest note to apply the accidental
                PlacedNote nearestNote = findNearestNote(x, y);
                if (nearestNote != null && !nearestNote.isRest) {
                    nearestNote.modifier = accidental;
                    success = true;
                    statusLabel.setText("Accidental applied: " + accidental);
                } else {
                    statusLabel.setText("No note found to apply accidental");
                }
            } else {
                // Handle note placement
                Notetype noteType = Notetype.valueOf(data);
                
                // Calculate pitch and octave based on y position
                String[] pitchAndOctave = calculatePitchAndOctave(y);
                String pitch = pitchAndOctave[0];
                int octave = Integer.parseInt(pitchAndOctave[1]);
                
                PlacedNote note = new PlacedNote(x, y, noteType, pitch, "", octave, false);
                placedNotes.add(note);
                success = true;
                
                statusLabel.setText("Note placed: " + pitch + octave + " (" + noteType + ")");
            }
            
            // Redraw the staff with the new note
            drawStaff();
        }
        
        event.setDropCompleted(success);
        event.consume();
    }
    
    @FXML
    void handleStaffClick(MouseEvent event) {
        if (eraseMode) {
            // Find and remove the note closest to the click
            double x = event.getX();
            double y = event.getY();
            
            PlacedNote toRemove = findNearestNote(x, y);
            
            if (toRemove != null) {
                placedNotes.remove(toRemove);
                statusLabel.setText("Note removed");
                drawStaff();
            }
        }
    }
    
    private PlacedNote findNearestNote(double x, double y) {
        PlacedNote nearest = null;
        double minDistance = Double.MAX_VALUE;
        
        for (PlacedNote note : placedNotes) {
            double distance = Math.sqrt(Math.pow(note.x - x, 2) + Math.pow(note.y - y, 2));
            if (distance < minDistance && distance < 20) { // Within 20 pixels
                minDistance = distance;
                nearest = note;
            }
        }
        
        return nearest;
    }
    
    private String[] calculatePitchAndOctave(double y) {
        double staffTop = 40;
        double lineSpacing = 10;
        
        // Calculate the position relative to the staff
        double relativePosition = (y - staffTop) / lineSpacing;
        
        // Map the position to a pitch and octave
        String[] pitches = {"F", "E", "D", "C", "B", "A", "G", "F", "E", "D", "C"};
        int[] octaves = {5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4};
        
        int index = (int) Math.round(relativePosition);
        index = Math.max(0, Math.min(index, pitches.length - 1));
        
        return new String[]{pitches[index], String.valueOf(octaves[index])};
    }
    
    @FXML
    void addMeasure() {
        // Create a new empty measure
        Measure measure = new Measure(new ArrayList<>(), timeSignatureSelector.getValue(), "mf");
        measures.add(measure);
        
        // Update the current composition
        currentComposition.setMeasures(new ArrayList<>(measures));
        
        // Adjust canvas width if needed
        double requiredWidth = 80 + measures.size() * 150 + 30;
        if (requiredWidth > staffCanvas.getWidth()) {
            staffCanvas.setWidth(requiredWidth);
        }
        
        // Redraw the staff
        drawStaff();
        statusLabel.setText("Measure added");
    }
    
    @FXML
    void clearSelected() {
        // Clear all placed notes
        placedNotes.clear();
        drawStaff();
        statusLabel.setText("All notes cleared");
    }
    
    @FXML
    void toggleEraseMode() {
        eraseMode = !eraseMode;
        if (eraseMode) {
            statusLabel.setText("Erase mode activated - click notes to remove them");
        } else {
            statusLabel.setText("Erase mode deactivated");
        }
        drawStaff();
    }
    
    @FXML
    void saveComposition() {
        // Update the composition title
        String title = compositionTitleField.getText();
        if (title != null && !title.isEmpty()) {
            currentComposition.setSongTitle(title);
        }
        
        // Convert placed notes to measures
        convertPlacedNotesToMeasures();
        
        // Save the composition using the facade
        if (facade.getCurrentUser() != null) {
            facade.saveCurrentSong();
            statusLabel.setText("Composition saved: " + currentComposition.getSongTitle());
        } else {
            statusLabel.setText("Please log in to save your composition");
        }
    }
    
    @FXML
    void playComposition() {
        // Convert placed notes to measures first
        convertPlacedNotesToMeasures();
        
        // Update the composition with the current tempo
        currentComposition.setTempo((int) tempoSlider.getValue());
        
        // Play the composition using Song's playSongAsync method
        currentComposition.playSongAsync(() -> {
            Platform.runLater(() -> statusLabel.setText("Finished playing composition"));
        });
        
        statusLabel.setText("Playing composition...");
    }
    
    private void convertPlacedNotesToMeasures() {
        // Clear existing measures but keep the structure
        List<Measure> newMeasures = new ArrayList<>();
        for (int i = 0; i < measures.size(); i++) {
            newMeasures.add(new Measure(new ArrayList<>(), timeSignatureSelector.getValue(), "mf"));
        }
        
        // Group notes by measure based on x position
        double measureStartX = 80;
        double measureWidth = 150;
        
        // Assign each note to a measure
        for (PlacedNote note : placedNotes) {
            int measureIndex = (int) ((note.x - measureStartX) / measureWidth);
            if (measureIndex >= 0 && measureIndex < newMeasures.size()) {
                // Convert the placed note to a chord
                List<Note> notes = new ArrayList<>();
                notes.add(note.toNote());
                
                String chordName = note.isRest ? "" : note.pitch + note.modifier;
                Chords chord = new Chords(notes, chordName, "", note.noteType, false);
                
                // Add the chord to the measure
                Measure measure = newMeasures.get(measureIndex);
                List<Chords> chords = new ArrayList<>(measure.getChords());
                chords.add(chord);
                measure.setChords(chords);
            }
        }
        
        // Update the measures list and the composition
        measures = newMeasures;
        currentComposition.setMeasures(new ArrayList<>(measures));
    }
}
