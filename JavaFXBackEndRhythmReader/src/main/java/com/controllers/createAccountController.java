package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.RRFacade;
import com.rhythmreader.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class createAccountController implements Initializable {


    @FXML
    private TextField txt_firstName;
    
    @FXML
    private TextField txt_lastName;
    
    @FXML
    private TextField txt_email;
    
    @FXML
    private TextField txt_username;
    
    @FXML
    private PasswordField txt_password;
    
    @FXML
    private RadioButton rb_regular;
    
    @FXML
    private RadioButton rb_teacher;
    
    @FXML
    private ToggleGroup accountTypeGroup;
    
    @FXML
    private Label label_error;
    
    @FXML
    private Button signUpButton;
    
    @FXML
    private Button backButton;
    

    private RRFacade facade;


    @FXML
    private void onBackClicked(ActionEvent event) throws IOException {
        App.navigateTo("launch");
    }

    @FXML
    private void onSignUpClicked(ActionEvent event) {

        label_error.setText("");

        String firstName = txt_firstName.getText().trim();
        String lastName = txt_lastName.getText().trim();
        String email = txt_email.getText().trim();
        String username = txt_username.getText().trim();
        String password = txt_password.getText().trim();
        boolean regularUser = rb_regular.isSelected();

        if (password.length()<6) {
            label_error.setText("Password must be at least 6 characters long.");
            return;
        }

        try {
            boolean success = facade.createAccount(username, firstName, lastName, email, password, regularUser);
            
            if (success) {
                if(regularUser == true) {
                    App.navigateTo("userDashboard");
                } else {
                    App.navigateTo("teacherDashboard");
                }
                
            } else {
                label_error.setText("Failed to create account. Username or email may already exist.");
            }
        } catch (Exception e) {
            label_error.setText("Error: " + e.getMessage());
        }
        
        //Clear the fields after sign up attempt
        txt_firstName.clear();
        txt_lastName.clear();
        txt_email.clear();
        txt_username.clear();
        txt_password.clear();
        rb_regular.setSelected(true);
    }

        
    

  







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facade = RRFacade.getInstance();
    }
    
}
