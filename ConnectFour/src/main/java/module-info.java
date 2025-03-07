module com.example.connectfour {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.connectfour to javafx.fxml;
    exports com.example.connectfour;
}