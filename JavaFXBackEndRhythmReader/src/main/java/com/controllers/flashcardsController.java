package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class flashcardsController {

    @FXML private Label flashcardLabel;
    @FXML private Button nextButton;
    @FXML private Button showAnswerButton;
    @FXML private ComboBox<String> categorySelector;

    private List<String> flashcards;
    private int currentIndex = 0;
    private boolean showingAnswer = false;

    @FXML
    public void initialize() {
        flashcards = new ArrayList<>();

        // Adding music-related flashcards as you asked
        flashcards.add("Question: Who is known as the 'King of Pop'? - Answer: Michael Jackson");
        flashcards.add("Question: Which instrument has 88 keys? - Answer: Piano");
        flashcards.add("Question: What genre is Taylor Swift mainly known for? - Answer: Pop/Country");

        // Adding original sample flashcards
        flashcards.add("Question: What is Java? - Answer: A programming language");
        flashcards.add("Question: What is the capital of France? - Answer: Paris");
        flashcards.add("Question: What is 2 + 2? - Answer: 4");

        flashcardLabel.setText("Welcome to Flashcards!");

        // Fill category selector (optional future expansion)
        categorySelector.setItems(FXCollections.observableArrayList("Music", "Programming", "General Knowledge"));
    }

    @FXML
    private void nextFlashcard(ActionEvent event) {
        if (flashcards.isEmpty()) {
            flashcardLabel.setText("No flashcards available.");
            return;
        }
        showingAnswer = false;
        currentIndex = (currentIndex + 1) % flashcards.size();
        String currentFlashcard = flashcards.get(currentIndex);
        String question = currentFlashcard.split(" - ")[0];
        flashcardLabel.setText(question);
    }

    @FXML
    private void showAnswer(ActionEvent event) {
        if (flashcards.isEmpty()) {
            flashcardLabel.setText("No flashcards available.");
            return;
        }
        if (!showingAnswer) {
            String currentFlashcard = flashcards.get(currentIndex);
            String answer = currentFlashcard.split(" - ")[1];
            flashcardLabel.setText(answer);
            showingAnswer = true;
        } else {
            String currentFlashcard = flashcards.get(currentIndex);
            String question = currentFlashcard.split(" - ")[0];
            flashcardLabel.setText(question);
            showingAnswer = false;
        }
    }
}
