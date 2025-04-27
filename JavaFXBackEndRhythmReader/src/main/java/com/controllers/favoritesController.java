package com.controllers;


import java.io.IOException;

import com.rhythmreader.App;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class favoritesController {
    @FXML
    private ImageView backButton;

    @FXML
    void backButtonClicked(MouseEvent event) throws IOException {
        App.navigateTo("profile");
    }    

}
