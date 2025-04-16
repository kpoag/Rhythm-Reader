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
        App.navigateTo("login");
    }

    @FXML
    private void onSignupClicked(ActionEvent event) throws IOException{
        App.navigateTo("createAccount");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
