package com.rhythmreader;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> origin/main
import java.util.UUID;

import com.model.RRFacade;
import com.controllers.templateController;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static templateController TemplateController;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("template.fxml"));
        Parent root = loader.load();
        TemplateController = loader.getController(); 

        scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Rhythm Reader");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                RRFacade.getInstance().logout();
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void navigateTo(String fxml) throws IOException {
        if (TemplateController != null) {
            TemplateController.updateNavigationVisibility();
            TemplateController.loadContent(fxml);
        }
    }

<<<<<<< HEAD
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/rhythmreader/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
=======
>>>>>>> origin/main

    public static void main(String[] args) {
        launch();

    }

}