package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.rhythmreader.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class launchController implements Initializable {

    @FXML
    private void onLoginButtonClicked(ActionEvent event) throws IOException{
        App.setRoot("login");
    }

    @FXML
    private void onSignupClicked(ActionEvent event) throws IOException{
        App.setRoot("signup");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
