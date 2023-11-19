package com.example.filmapi2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button button_start;

    @FXML
    private Label film_name;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() throws IOException, InterruptedException {
        button_start.setOnAction(event->{
            Film film = new Film();
            try {
                film.film(32);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           // film_name.setText("hahaha");
            film_name.setText(film.getTitle()+ " \nранг: "+ film.getRank() + "\nДата выхода: "+ film.getReleased());
        });


    }
}

