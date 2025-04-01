module com.rhythmreader {
    requires javafx.controls;
    requires junit;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires junit;

    opens com.rhythmreader to javafx.fxml;
    exports com.rhythmreader;

    opens com.model to javafx.fxml;
    exports com.model;
}
