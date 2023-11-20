package com.example.filmapi2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 425, 536);
        //FlowPane root2 = new FlowPane();
        stage.setTitle("Кино!");
        stage.setScene(new Scene(root, 1000,1000));
        stage.setResizable(false);
        stage.show();


//        for (int i = 1; i < 3;i++)
//        {
//            Film film = new Film();
//            film.film(i);
//            ImageView imageView;
//            imageView = new ImageView(film.get_Image());
//            root2.getChildren().addAll(imageView);
//            String name = film.get_title();
//            Text title = new Text(name);
//            root2.getChildren().addAll(title);
//        }


    }

    public static void main(String[] args) {
        launch();
    }
}