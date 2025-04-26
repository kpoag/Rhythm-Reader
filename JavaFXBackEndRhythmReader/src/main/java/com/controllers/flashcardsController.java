package com.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class flashcardsController {

    @FXML
    private VBox flashcardsContainer;

    @FXML
    private TextField questionField;

    @FXML
    private TextField answerField;

    @FXML
    private void newButtonClick(ActionEvent event) {  // <-- must match the onAction in FXML
        String question = questionField.getText();
        String answer = answerField.getText();

        if (!question.isEmpty() && !answer.isEmpty()) {
            VBox card = new VBox();
            card.setSpacing(5);
            card.setStyle("-fx-padding: 10px; -fx-border-color: black; -fx-background-color: #f0f0f0;");

            Label questionLabel = new Label("Q: " + question);
            Label answerLabel = new Label("A: " + answer);

            card.getChildren().addAll(questionLabel, answerLabel);
            flashcardsContainer.getChildren().add(card);

            questionField.clear();
            answerField.clear();
        }
    }
}
