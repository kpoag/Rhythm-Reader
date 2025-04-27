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

public class flashcardsController {

    @FXML private TextField searchField;
    @FXML private Button searchButton;
    @FXML private Button addFlashcardButton;
    @FXML private Button playButton;  // Button to simulate playing the flashcard with tempo
    @FXML private ListView<String> flashcardListView;
    @FXML private VBox flashcardDetailsContainer;
    @FXML private TextField tempoField;  // Field to input tempo

    private ObservableList<String> flashcardItems;
    private List<String> flashcardData;

    @FXML
    public void initialize() {
        // Example flashcard data
        flashcardData = new ArrayList<>();
        flashcardData.add("Question: What is Java? - Answer: A programming language");
        flashcardData.add("Question: What is the capital of France? - Answer: Paris");
        flashcardData.add("Question: What is 2 + 2? - Answer: 4");

        flashcardItems = FXCollections.observableArrayList(flashcardData);
        flashcardListView.setItems(flashcardItems);
    }

    @FXML
    void searchFlashcard(ActionEvent event) {
        String searchQuery = searchField.getText().toLowerCase();
        ObservableList<String> filteredFlashcards = FXCollections.observableArrayList();

        for (String flashcard : flashcardData) {
            if (flashcard.toLowerCase().contains(searchQuery)) {
                filteredFlashcards.add(flashcard);
            }
        }

        flashcardListView.setItems(filteredFlashcards);
    }

    @FXML
    void addFlashcard(ActionEvent event) {
        // Example of adding a new flashcard entry
        String newFlashcard = "Question: What is 5 + 5? - Answer: 10";
        flashcardData.add(newFlashcard);
        flashcardItems.add(newFlashcard);
    }

    @FXML
    void showFlashcardDetails(ActionEvent event) {
        String selectedFlashcard = flashcardListView.getSelectionModel().getSelectedItem();
        if (selectedFlashcard != null) {
            flashcardDetailsContainer.getChildren().clear();
            Label flashcardDetails = new Label("Details for: " + selectedFlashcard);
            flashcardDetailsContainer.getChildren().add(flashcardDetails);
        }
    }

    @FXML
    void playFlashcardWithTempo(ActionEvent event) {
        String selectedFlashcard = flashcardListView.getSelectionModel().getSelectedItem();
        if (selectedFlashcard != null) {
            // Extract question and answer from the selected flashcard
            String[] parts = selectedFlashcard.split(" - ");
            String question = parts[0];
            String answer = parts[1];

            // Get the tempo from the TextField, or use a default value if empty
            int tempo = 120;  // Default tempo
            try {
                tempo = Integer.parseInt(tempoField.getText());
            } catch (NumberFormatException e) {
                System.out.println("Invalid tempo input, using default: " + tempo);
            }

            // Simulate "playing" the flashcard with the tempo (outputting to console)
            System.out.println("Showing flashcard with question: '" + question + "' at tempo " + tempo);
            System.out.println("Answer: " + answer);
        }
    }
}
