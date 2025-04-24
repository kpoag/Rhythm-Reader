package com.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class profileController implements Initializable {

    @FXML
    private AnchorPane launch_pane;

    @FXML
    private Label nameLabel;

    @FXML
    private Button editProfileButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("profileController initialized!");
    }

    @FXML
    private void handleEditProfile() {
        System.out.println("Profile clicked");
    }
    
}
