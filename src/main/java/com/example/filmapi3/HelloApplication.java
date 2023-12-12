package com.example.filmapi3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage.setTitle("Кино!");
            stage.setScene(new Scene(root, 1000, 1000));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e){
            System.out.println("У  вас нет доступа к API, проверьте ключ подключения");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        launch();
    }

}