package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.rhythmreader.*;

public class pianoController implements Initializable {

    @FXML
    void playC(ActionEvent event) {
        Music.playNote("C");
    }
    @FXML
    void playD(ActionEvent event) {
        Music.playNote("D");
    }
    @FXML
    void playE(ActionEvent event) {
        Music.playNote("E");
    }
    @FXML
    void playG(ActionEvent event) {
        Music.playNote("G");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
