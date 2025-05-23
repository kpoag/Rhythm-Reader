package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.RRFacade;
import com.rhythmreader.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class userDashboardController implements Initializable {
    @FXML
    private Label usernameLabel;

    


    @FXML
    private void onFlashcardsClicked(ActionEvent event) throws IOException {
        App.navigateTo("flashcards");
    }

    @FXML
    private void onPianoClicked(ActionEvent event) throws IOException {
        App.navigateTo("piano");
    }

    @FXML
    private void onComposeClicked(ActionEvent event) throws IOException {
        App.navigateTo("compose");
    }
    
    @FXML
    private void onLibraryClicked(ActionEvent event) throws IOException {
        App.navigateTo("library");
    }

    @FXML
    private void onFriendsClicked(ActionEvent event) throws IOException {
        App.navigateTo("friends");
    }
    
    @FXML
    void onProfileIconCLicked(MouseEvent event) throws IOException {
        App.navigateTo("profile");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String username = RRFacade.getInstance().getCurrentUser().getUserName();
        usernameLabel.setText(username);

    }
    
}
