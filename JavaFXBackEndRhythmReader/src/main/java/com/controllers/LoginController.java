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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {
    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_password;

    @FXML
    private Label label_error;

    @FXML
    private void buttonLogginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        RRFacade facade = RRFacade.getInstance();

        if (!facade.login(username, password)) {
            label_error.setText("Invalid username or password");
            label_error.styleProperty();
            return;
        }
        if (facade.getCurrentUser().isStudent()) {
            App.navigateTo("userDashboard");
        }
    }
    
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        App.navigateTo("launch");
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
}
