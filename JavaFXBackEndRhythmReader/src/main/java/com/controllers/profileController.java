package com.controllers;

import java.io.IOException;

import com.model.RRFacade;
import com.model.User;
import com.rhythmreader.App;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class profileController {

    @FXML
    private Text emailAddress;

    @FXML
    private Text favorites;

    @FXML
    private ImageView favoritesButton;

    @FXML
    private Text firstName;

    @FXML
    private Text lastName;

    @FXML
    private ImageView profileImage;

    @FXML
    private Text settings;

    @FXML
    private ImageView settingsButton;

    @FXML
    private Text username;

    @FXML
    void favoritesButtonClicked(MouseEvent event) throws IOException {
        App.navigateTo("favorites");

    }

    @FXML
    void settingsButtonClicked(MouseEvent event) throws IOException {
        App.navigateTo("settings");
    }

    @FXML
    private void initialize() {
        RRFacade facade = RRFacade.getInstance();
        User currUser = facade.getCurrentUser();
        username.setText(currUser.getUserName());
        firstName.setText(currUser.getFirstName());
        lastName.setText(currUser.getLastName());
        emailAddress.setText(currUser.getEmail());
    }

}