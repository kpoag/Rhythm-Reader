package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class flashcardsController implements Initializable {

    @FXML private GridPane grid_genre;
    @FXML private GridPane grid_instrument;
    @FXML private GridPane grid_skill;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add checks to ensure the GridPanes are not null
        if (grid_genre == null || grid_instrument == null || grid_skill == null) {
            System.err.println("One of the GridPanes is null!");
        } else {
            displayGenres();
            displayInstruments();
            displaySkillLevels();
        }
    }

    private void displayGenres() {
        String[] genres = {"POP", "R&B", "JAZZ"};
        for (int i = 0; i < genres.length; i++) {
            final String genre = genres[i];
            Button btn = createStyledButton(genre);
            grid_genre.add(btn, i, 0);
            btn.setOnAction(e -> handleCategoryClick("Genre", genre));
        }
    }

    private void displayInstruments() {
        String[] instruments = {"PIANO", "DRUMS", "FLUTE"};
        for (int i = 0; i < instruments.length; i++) {
            final String instrument = instruments[i];
            Button btn = createStyledButton(instrument);
            grid_instrument.add(btn, i, 0);
            btn.setOnAction(e -> handleCategoryClick("Instrument", instrument));
        }
    }

    private void displaySkillLevels() {
        String[] levels = {"BEGINNER", "INTERMEDIATE", "EXPERT"};
        for (int i = 0; i < levels.length; i++) {
            final String level = levels[i];
            Button btn = createStyledButton(level);
            grid_skill.add(btn, i, 0);
            btn.setOnAction(e -> handleCategoryClick("Skill Level", level));
        }
    }

    private Button createStyledButton(String label) {
        Button btn = new Button(label);
        btn.setMinSize(100, 60);
        btn.setFont(Font.font("Arial", 14));
        btn.getStyleClass().add("category-button");
        return btn;
    }

    private void handleCategoryClick(String categoryType, String categoryName) {
        System.out.println("Clicked " + categoryType + ": " + categoryName);
        try {
            loadNextScene(categoryType, categoryName);  // Transition to next scene
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNextScene(String categoryType, String categoryName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/flashcardsDisplay.fxml"));
        Scene scene = new Scene(loader.load());
        
        // Set the scene
        Stage stage = (Stage) grid_genre.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleButtonClick(javafx.event.ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        System.out.println("Button clicked: " + sourceButton.getText());
    }
}

