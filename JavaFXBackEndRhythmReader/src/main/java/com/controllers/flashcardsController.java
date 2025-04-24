package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class flashcardsController {

    @FXML private GridPane grid_genre;
    @FXML private GridPane grid_instrument;
    @FXML private GridPane grid_skill;

    @FXML private VBox flashcardsVBox; // VBox to hold the flashcards content dynamically

    private String categoryType;
    private String categoryName;

    // Initial setup: populate the grids with genre, instrument, skill buttons
    public void initialize() {
        displayGenres();
        displayInstruments();
        displaySkillLevels();
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

    // Handle category selection and display corresponding flashcards
    private void handleCategoryClick(String categoryType, String categoryName) {
        this.categoryType = categoryType;
        this.categoryName = categoryName;
        System.out.println("Clicked " + categoryType + ": " + categoryName);
        
        // Update the layout with flashcards or category information
        updateFlashcardsContent(categoryType, categoryName);
    }

    // Update the VBox with content based on the selected category
    private void updateFlashcardsContent(String categoryType, String categoryName) {
        // Clear previous content
        flashcardsVBox.getChildren().clear();

        // Create and add category label to the VBox
        Label categoryLabel = new Label("Category: " + categoryType + " - " + categoryName);
        flashcardsVBox.getChildren().add(categoryLabel);

        // Optionally, add more flashcard content or buttons dynamically based on the category
        Label flashcardDemo = new Label("Here are the flashcards for: " + categoryType + " - " + categoryName);
        flashcardsVBox.getChildren().add(flashcardDemo);
        
        // For example, add a few flashcards
        for (int i = 1; i <= 3; i++) {
            Label flashcard = new Label("Flashcard " + i + " for " + categoryType + " - " + categoryName);
            flashcardsVBox.getChildren().add(flashcard);
        }
    }
}
