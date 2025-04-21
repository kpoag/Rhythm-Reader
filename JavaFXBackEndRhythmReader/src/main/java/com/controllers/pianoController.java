package com.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.model.Song;
import com.model.DataLoader;
import org.jfugue.player.Player;
import java.util.ArrayList;

public class pianoController implements Initializable {
    @FXML private ComboBox<String> songSelector;
    @FXML private Slider tempoSlider;
    @FXML private VBox sheetMusicContainer;
    
    private ArrayList<Song> songs;
    private Player player;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize JFugue player
        player = new Player();
        
        // Load available songs
        songs = DataLoader.loadSongs();
        
        // Populate song selector
        for (Song song : songs) {
            songSelector.getItems().add(song.getSongTitle());
        }
        
        // Set default tempo
        tempoSlider.setValue(120);
    }
    
    @FXML
    void playSong(ActionEvent event) {
        String selectedSong = songSelector.getValue();
        if (selectedSong != null) {
            for (Song song : songs) {
                if (song.getSongTitle().equals(selectedSong)) {
                    song.setTempo((int) tempoSlider.getValue());
                    displaySheetMusic(song);
                    song.playSong();
                    break;
                }
            }
        }
    }
    
    private void displaySheetMusic(Song song) {
        sheetMusicContainer.getChildren().clear();
        
        Label titleLabel = new Label(song.getSongTitle());
        titleLabel.getStyleClass().add("song-title");
        Label artistLabel = new Label("By " + song.getArtist());
        artistLabel.getStyleClass().add("song-artist");
        
        sheetMusicContainer.getChildren().addAll(titleLabel, artistLabel);
        
        song.getMeasures().forEach(measure -> {
            Label measureLabel = new Label(measure.getJFuguePattern());
            measureLabel.getStyleClass().add("measure");
            sheetMusicContainer.getChildren().add(measureLabel);
        });
    }
    
    // Octave 2 (F2 to B2)
    @FXML void playF2(ActionEvent event) { playNote("F2q"); }
    @FXML void playF2Sharp(ActionEvent event) { playNote("F#2q"); }
    @FXML void playG2(ActionEvent event) { playNote("G2q"); }
    @FXML void playG2Sharp(ActionEvent event) { playNote("G#2q"); }
    @FXML void playA2(ActionEvent event) { playNote("A2q"); }
    @FXML void playA2Sharp(ActionEvent event) { playNote("A#2q"); }
    @FXML void playB2(ActionEvent event) { playNote("B2q"); }
    
    // First Octave (C3 to B3)
    @FXML void playC3(ActionEvent event) { playNote("C3q"); }
    @FXML void playC3Sharp(ActionEvent event) { playNote("C#3q"); }
    @FXML void playD3(ActionEvent event) { playNote("D3q"); }
    @FXML void playD3Sharp(ActionEvent event) { playNote("D#3q"); }
    @FXML void playE3(ActionEvent event) { playNote("E3q"); }
    @FXML void playF3(ActionEvent event) { playNote("F3q"); }
    @FXML void playF3Sharp(ActionEvent event) { playNote("F#3q"); }
    @FXML void playG3(ActionEvent event) { playNote("G3q"); }
    @FXML void playG3Sharp(ActionEvent event) { playNote("G#3q"); }
    @FXML void playA3(ActionEvent event) { playNote("A3q"); }
    @FXML void playA3Sharp(ActionEvent event) { playNote("A#3q"); }
    @FXML void playB3(ActionEvent event) { playNote("B3q"); }
    
    // Second Octave (C4 to B4)
    @FXML void playC4(ActionEvent event) { playNote("C4q"); }
    @FXML void playC4Sharp(ActionEvent event) { playNote("C#4q"); }
    @FXML void playD4(ActionEvent event) { playNote("D4q"); }
    @FXML void playD4Sharp(ActionEvent event) { playNote("D#4q"); }
    @FXML void playE4(ActionEvent event) { playNote("E4q"); }
    @FXML void playF4(ActionEvent event) { playNote("F4q"); }
    @FXML void playF4Sharp(ActionEvent event) { playNote("F#4q"); }
    @FXML void playG4(ActionEvent event) { playNote("G4q"); }
    @FXML void playG4Sharp(ActionEvent event) { playNote("G#4q"); }
    @FXML void playA4(ActionEvent event) { playNote("A4q"); }
    @FXML void playA4Sharp(ActionEvent event) { playNote("A#4q"); }
    @FXML void playB4(ActionEvent event) { playNote("B4q"); }
    
    // Third Octave (C5 to B5)
    @FXML void playC5(ActionEvent event) { playNote("C5q"); }
    @FXML void playC5Sharp(ActionEvent event) { playNote("C#5q"); }
    @FXML void playD5(ActionEvent event) { playNote("D5q"); }
    @FXML void playD5Sharp(ActionEvent event) { playNote("D#5q"); }
    @FXML void playE5(ActionEvent event) { playNote("E5q"); }
    @FXML void playF5(ActionEvent event) { playNote("F5q"); }
    @FXML void playF5Sharp(ActionEvent event) { playNote("F#5q"); }
    @FXML void playG5(ActionEvent event) { playNote("G5q"); }
    @FXML void playG5Sharp(ActionEvent event) { playNote("G#5q"); }
    @FXML void playA5(ActionEvent event) { playNote("A5q"); }
    @FXML void playA5Sharp(ActionEvent event) { playNote("A#5q"); }
    @FXML void playB5(ActionEvent event) { playNote("B5q"); }
    
    // Fourth Octave (Partial: C6 to B6)
    @FXML void playC6(ActionEvent event) { playNote("C6q"); }
    @FXML void playC6Sharp(ActionEvent event) { playNote("C#6q"); }
    @FXML void playD6(ActionEvent event) { playNote("D6q"); }
    @FXML void playD6Sharp(ActionEvent event) { playNote("D#6q"); }
    @FXML void playE6(ActionEvent event) { playNote("E6q"); }
    @FXML void playF6(ActionEvent event) { playNote("F6q"); }
    @FXML void playF6Sharp(ActionEvent event) { playNote("F#6q"); }
    @FXML void playA6(ActionEvent event) { playNote("A6q"); }
    @FXML void playA6Sharp(ActionEvent event) { playNote("A#6q"); }
    @FXML void playB6(ActionEvent event) { playNote("B6q"); }
    
    // Helper method to play notes using JFugue
    private void playNote(String note) {
        try {
            player.play("I[Piano] " + note);
        } catch (Exception e) {
            System.err.println("Error playing note: " + e.getMessage());
        }
    }
}
