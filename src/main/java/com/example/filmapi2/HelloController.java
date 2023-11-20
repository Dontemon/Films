package com.example.filmapi2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Console;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private TextField anchorPane;

    @FXML
    private Button randomFilm;

    @FXML
    private RadioButton radioButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button searchButton;
    @FXML
    private Label label;

    @FXML
    public void initialize() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://imdb-top-100-movies.p.rapidapi.com/"))
//                .header("X-RapidAPI-Key", "f011c0889bmsh6e844bf0fd6398cp1ee44bjsn295f0f5a70af")
//                .header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        JSONObject obj = new JSONObject(response.body());
        searchButton.setOnAction(event->{
            System.out.println("2");
            if(radioButton.isSelected()){
                String s1 = new String();
                System.out.println("3");
                for(int i = 0; i< 100; i++)
                {
                    s1 += String.valueOf(i)+"\n\n";
                    //System.out.println(s);
                }
                label.setText(s1);
                s1 = "";
            }
            else{
                String s2 = new String();
                System.out.println("4");
                for(int i = 0; i< 100; i++)
                {
                    s2 += String.valueOf(100 - i)+"\n\n";

                    //System.out.println(s);
                }
                label.setText(s2);
                s2 = "";
            }

           // film.Film(obj.get("title"),obj.get("id"),obj.get("description"),obj.get("rank"), obj.get("year"),
            //        obj.get("rating"), obj.get("imdb_link"), obj.get("image"), );

           // film_name.setText("hahaha");
//            film_name.setText(film.get_title()+ " \nранг: "+ film.get_Rank() + "\nДата выхода: "+ film.get_Released());
//            Image image;
//            image = new Image(film.get_Link());
//            imageView.setImage(image);
//            String s = film_name.getText();
//            try {
//                film2.film(1);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            film_name.setText(s + "\n\n\n" + film2.get_title()+ " \nранг: "+ film2.get_Rank() + "\nДата выхода: "+ film2.get_Released());
        });
        randomFilm.setOnAction(event -> {
            int rand = new Random().ints(1, 1, 101).findFirst().getAsInt();
            System.out.println(rand);
        });
    }
}

