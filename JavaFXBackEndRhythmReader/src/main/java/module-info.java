module com.rhythmreader {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires javafx.graphics;

    opens com.rhythmreader to javafx.fxml;
    exports com.rhythmreader;

    opens com.model to javafx.fxml;
    exports com.model;

    opens com.controllers to javafx.fxml;
    exports com.controllers;
}
