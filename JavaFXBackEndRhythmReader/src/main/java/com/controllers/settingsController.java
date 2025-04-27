package com.controllers;

import java.io.IOException;

import com.model.RRFacade;
import com.rhythmreader.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;

public class settingsController {

    @FXML
    private ToggleButton darkModeToggle;

    @FXML
    private ImageView deleteAccountButton;

    @FXML
    private ToggleButton notificationToggle;

    @FXML
    private TextField profileBio;

    @FXML
    private ImageView resetAccountButton;

    @FXML
    void deleteAccountClicked(MouseEvent event) throws IOException {
        RRFacade facade = RRFacade.getInstance();
        facade.logout();
        System.out.println("User has deleted account");
        App.navigateTo("launch");
    }

    @FXML
    void handleDarkModeToggle(ActionEvent event) {
        if (darkModeToggle.isSelected()) {
            darkModeToggle.setText("ON");
            System.out.println("Dark Mode is on");
        }
        else {
            darkModeToggle.setText("OFF");
            System.out.println("Dark Mode is off");
        }
    }

    @FXML
    void handleNotificationToggle(ActionEvent event) {
        if (notificationToggle.isSelected()) {
            notificationToggle.setText("ON");
            System.out.println("Push Notification is on");
        } else {
            notificationToggle.setText("OFF");
            System.out.println("Push Notification is off");
        }
    }

    @FXML
    void onBackButtonClicked(MouseEvent event) throws IOException {
        App.navigateTo("profile");
    }

    @FXML
    void switchToProfile(TouchEvent event) throws IOException {
        App.navigateTo("profile");
    }

}
