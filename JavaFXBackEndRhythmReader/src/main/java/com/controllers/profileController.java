package com.controllers;

import java.io.IOException;

import com.model.RRFacade;
import com.model.User;
import com.rhythmreader.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class profileController {

    @FXML
    private Text editProfile;

    @FXML
    private Button editProfileButton;

    @FXML
    private Text emailAddress;

    @FXML
    private Text favorites;

    @FXML
    private Button favoritesButton;

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
    void switchToEditProfile(ActionEvent event) {
       // App.navigateTo(editProfile.fxml);
    }

    @FXML
    void switchToFavorites(ActionEvent event) {
        // App.navigateTo(favorites.fxml);
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
    }

}