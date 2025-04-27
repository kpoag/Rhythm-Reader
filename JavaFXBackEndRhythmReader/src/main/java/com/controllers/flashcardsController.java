package com.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class flashcardsController implements Initializable {

    @FXML private Label flashcardLabel;
    @FXML private Button nextButton;
    @FXML private Button showAnswerButton;
    @FXML private ComboBox<String> categorySelector;
    @FXML private VBox flashcardContainer;

    private List<String> flashcards;
    private int currentFlashcardIndex;
    private boolean showingAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize flashcards list
        flashcards = new ArrayList<>();
        flashcards.add("What is the capital of France?");
        flashcards.add("What is 2 + 2?");
        flashcards.add("Who wrote 'To Kill a Mockingbird'?");
        currentFlashcardIndex = 0;
        showingAnswer = false;
        
        // Set default flashcard
        flashcardLabel.setText(flashcards.get(currentFlashcardIndex));
        
        // Initialize categorySelector (this can be expanded with more categories)
        categorySelector.getItems().addAll("General Knowledge", "Math", "Literature");
    }

    @FXML
    void nextFlashcard(ActionEvent event) {
        if (currentFlashcardIndex < flashcards.size() - 1) {
            currentFlashcardIndex++;
        } else {
            currentFlashcardIndex = 0; // Loop back to the first card
        }
        flashcardLabel.setText(flashcards.get(currentFlashcardIndex));
        showingAnswer = false;
    }

    @FXML
    void showAnswer(ActionEvent event) {
        // Show the answer for the current flashcard
        if (!showingAnswer) {
            flashcardLabel.setText("The answer is: Paris"); // This would be dynamic based on the flashcard
            showingAnswer = true;
        } else {
            flashcardLabel.setText(flashcards.get(currentFlashcardIndex)); // Show the question again
            showingAnswer = false;
        }
    }

}
