package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class libraryController {

    @FXML private TextField searchField;
    @FXML private Button searchButton;
    @FXML private Button addMusicButton;
    @FXML private Button playButton;  // Button to play the song with tempo
    @FXML private ListView<String> musicListView;
    @FXML private VBox musicDetailsContainer;
    @FXML private TextField tempoField;  // Field to input tempo

    private ObservableList<String> musicItems;
    private List<String> musicData;

    @FXML
    public void initialize() {
        // Example music data
        musicData = new ArrayList<>();
        musicData.add("Shape of You - Ed Sheeran");
        musicData.add("Blinding Lights - The Weeknd");
        musicData.add("Rolling in the Deep - Adele");
        musicData.add("Levitating - Dua Lipa");
    musicData.add("Uptown Funk - Bruno Mars");
    musicData.add("Bad Guy - Billie Eilish");
    musicData.add("Happier Than Ever - Billie Eilish");
    musicData.add("Senorita - Shawn Mendes & Camila Cabello");
    musicData.add("Watermelon Sugar - Harry Styles");
    musicData.add("Old Town Road - Lil Nas X");
    musicData.add("Sunflower - Post Malone & Swae Lee");
    musicData.add("Perfect - Ed Sheeran");
    musicData.add("Dance Monkey - Tones and I");
    musicData.add("Lucid Dreams - Juice WRLD");
    musicData.add("Peaches - Justin Bieber");
    musicData.add("Don't Start Now - Dua Lipa");
    musicData.add("Savage Love - Jason Derulo");
    musicData.add("Memories - Maroon 5");
    musicData.add("Drivers License - Olivia Rodrigo");
    musicData.add("Good 4 U - Olivia Rodrigo");
    musicData.add("Stay - The Kid LAROI & Justin Bieber");
    musicData.add("As It Was - Harry Styles");
    musicData.add("Flowers - Miley Cyrus");
    musicData.add("Anti-Hero - Taylor Swift");
    musicData.add("Calm Down - Rema & Selena Gomez");
        
        musicItems = FXCollections.observableArrayList(musicData);
        musicListView.setItems(musicItems);
    }

    @FXML
    void searchMusic(ActionEvent event) {
        String searchQuery = searchField.getText().toLowerCase();
        ObservableList<String> filteredMusic = FXCollections.observableArrayList();

        for (String music : musicData) {
            if (music.toLowerCase().contains(searchQuery)) {
                filteredMusic.add(music);
            }
        }

        musicListView.setItems(filteredMusic);
    }

    @FXML
    void addMusic(ActionEvent event) {
        // Example of adding a new music entry
        String newMusic = "New Song - Artist Name";
        musicData.add(newMusic);
        musicItems.add(newMusic);
    }

    @FXML
    void showMusicDetails(ActionEvent event) {
        String selectedMusic = musicListView.getSelectionModel().getSelectedItem();
        if (selectedMusic != null) {
            musicDetailsContainer.getChildren().clear();
            Label musicDetails = new Label("Details for: " + selectedMusic);
            musicDetailsContainer.getChildren().add(musicDetails);
        }
    }

    @FXML
    void playMusicWithTempo(ActionEvent event) {
        String selectedMusic = musicListView.getSelectionModel().getSelectedItem();
        if (selectedMusic != null) {
            // Extract song name and artist from the selected music
            String[] parts = selectedMusic.split(" - ");
            String songName = parts[0];
            String artist = parts[1];

            // Get the tempo from the TextField, or use a default value if empty
            int tempo = 120;  // Default tempo
            try {
                tempo = Integer.parseInt(tempoField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Invalid tempo input, using default: " + tempo);
            }

            // Simulate playing the song at the specified tempo
            System.out.println("Playing " + songName + " by " + artist + " at tempo " + tempo);
        }
    }
}
