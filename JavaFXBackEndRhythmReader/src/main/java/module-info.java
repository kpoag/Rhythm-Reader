module com.rhythmreader {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.rhythmreader to javafx.fxml;
    exports com.rhythmreader;

    opens com.model to javafx.fxml;
    exports com.model;
}
