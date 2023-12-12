module com.example.filmapi3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires json.simple;


    opens com.example.filmapi3 to javafx.fxml;
    exports com.example.filmapi3;
}