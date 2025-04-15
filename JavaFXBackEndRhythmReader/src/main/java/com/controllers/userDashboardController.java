package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import com.rhythmreader.App;

public class userDashboardController implements Initializable {
    @FXML
    private void onFlashcardsClicked(MouseEvent event) throws IOException {
        App.setRoot("flashcards");
    }

    @FXML
    private void onPianoClicked(ActionEvent event) throws IOException {
        App.setRoot("piano");
    }

    @FXML
    private void onComposeClicked(ActionEvent event) throws IOException {
        App.setRoot("compose");
    }
    
    @FXML
    private void onLibraryClicked(ActionEvent event) throws IOException {
        App.setRoot("library");
    }

    @FXML
    private void onHomeworkClicked(ActionEvent event) throws IOException {
        App.setRoot("homework");
    }

    @FXML
    private void onFriendsClicked(ActionEvent event) throws IOException {
        App.setRoot("friends");
    }
    @FXML
    private void onProfileClicked(ActionEvent event) throws IOException {
        App.setRoot("profile");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
