package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import com.model.RRFacade;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class templateController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private StackPane contentArea;

    @FXML
    private Label appTitle;

    @FXML
    private Button homeButton;

    @FXML
    private Button libraryButton;

    @FXML
    private Button friendsButton;

    @FXML
    private Button playButton;

    @FXML
    private Button homeworkButton;


    @FXML
    private Button composeButton;

    @FXML
    private Button flashcardsButton;

    @FXML
    private Button profileButton;

    @FXML
    private ProgressBar loadingBar;

    private RRFacade facade;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = RRFacade.getInstance();

        try {
            loadContent("launch");
        } catch (IOException e) {
            System.err.println("Error loading launch.fxml: " + e.getMessage());
        }

    }
    public void updateNavigationVisibility() {
        boolean isLoggedIn = facade.isUserLoggedIn();
        
        homeButton.setVisible(isLoggedIn);
        homeButton.setManaged(isLoggedIn);

    }

    public void loadContent(String fxml) throws IOException {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/rhythmreader/" + fxml + ".fxml"));
            Parent content = loader.load();
            
            // Clear existing content and add new content
            contentArea.getChildren().clear();
            contentArea.getChildren().add(content);

            updateNavigationVisibility();
            
        } catch (IOException e) {
            System.err.println("Error loading " + fxml + ".fxml: " + e.getMessage());
            throw e;
        }
    }


    @FXML
    private void navigateToHome() throws IOException {
        loadContent("userDashboard");
    }

    @FXML
    private void navigateToHomework() throws IOException {
        loadContent("homework");
    }

    @FXML
    private void navigateToLibrary() throws IOException {
        loadContent("Library");
    }

    @FXML
    private void navigateToFlashcards() throws IOException {
        loadContent("flashcards");
    }

    @FXML
    private void navigateToCompose() throws IOException {
        loadContent("compose");
    }

    @FXML
    private void navigateToPlay() throws IOException {
        loadContent("play");
    }

    @FXML
    private void navigateToProfile() throws IOException {
        loadContent("profile");
    }

    @FXML
    private void navigateToFriends() throws IOException {
        loadContent("friends");
    }



}


    

