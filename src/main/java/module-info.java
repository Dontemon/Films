module com.example.filmapi2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires org.json;

    opens com.example.filmapi2 to javafx.fxml;
    exports com.example.filmapi2;
}