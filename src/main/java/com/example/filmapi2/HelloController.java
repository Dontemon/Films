package com.example.filmapi2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.Iterator;


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
    public void initialize() throws IOException, InterruptedException, ParseException {
                HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-top-100-movies.p.rapidapi.com/"))
                .header("X-RapidAPI-Key", "6fd86251efmsh620214799af6924p10c65cjsnba280e4b4145")
                .header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Object obj = new JSONParser().parse(json);
        JSONArray jsonArray = (JSONArray)obj; //получаем массив данных из пришедшего ответа от сервера
        Films listFilms = new Films(); //создаем объект для хранения списка фильмов
        for (Object film : jsonArray) //парсим массив на объекты
        {
            JSONObject jsonFilm = (JSONObject) film; //достаем массив жанров
            JSONArray ganre = (JSONArray) jsonFilm.get("genre");
            ArrayList<String> listGanre = new ArrayList<String>();
            for (int i = 0; i < ganre.size(); i++) {
                listGanre.add((String)ganre.get(i));
            }
            //создаем объект Фильм с данными из апи
            Film newFilm = new Film((String)jsonFilm.get("title"), (String)jsonFilm.get("id"), (String)jsonFilm.get("description"), (long)jsonFilm.get("rank"), (long)jsonFilm.get("year"), (String)jsonFilm.get("rating"), (String)jsonFilm.get("imdb_link"), (String)jsonFilm.get("image"), listGanre);
            listFilms.getListFilms().add(newFilm); //добавляем этот фильм в список фильмов
        }

            searchButton.setOnAction(event->{
            System.out.println("2");
            String searchField = anchorPane.getText();
            int height = 40;
            int height2 = 5;
            ArrayList<Film> searchedFilms = new ArrayList<Film>();
            searchedFilms = listFilms.searchByTitle(searchField);

            if(radioButton.isSelected()){
                String s1 = new String();
                //System.out.println("3");
                for(int i = 0; i < searchedFilms.size(); i++)
                {
                   // s1 += "Фильм " + (i + 1) + "\n";
                    s1 += "ID: " + searchedFilms.get(i).getId() + "\n";
                    s1 += "Название: " + searchedFilms.get(i).getTitle()+ "\n";
                    s1 += "Описание: " + searchedFilms.get(i).getDescription()+ "\n";
                    s1 += "Ранг: " + searchedFilms.get(i).getRank()+ "\n";
                    s1 += "Год релиза: " + searchedFilms.get(i).getReleased()+ "\n";
                    s1 += "Ссылка: " + searchedFilms.get(i).getLink()+ "\n";
                    s1 += "Картинка: " + searchedFilms.get(i).getImage()+ "\n";
                    s1 += "Рейтинг: " + searchedFilms.get(i).getRating()+ "\n";
                    s1 += "Жанры: ";
                    for (int j = 0; j < searchedFilms.get(i).getGanre().size(); j++)
                    {
                       s1 += searchedFilms.get(i).getGanre().get(j)+", ";
                    }
                    s1 += "\n\n\n";
                    label.resize(1000,height);
                    height2+=5;
                    height+=40;
                    //System.out.println(s);
                }
                label.setText(s1);
                s1 = "";
            }
            else{
                String s2 = new String();
                System.out.println("4");
                for(int i = searchedFilms.size() - 1; i > 0; i--)
                {
                   // s2 += "Фильм " + (i + 1) + "\n";
                    s2 += "ID: " + searchedFilms.get(i).getId() + "\n";
                    s2 += "Название: " + searchedFilms.get(i).getTitle()+ "\n";
                    s2 += "Описание: " + searchedFilms.get(i).getDescription()+ "\n";
                    s2 += "Ранг: " + searchedFilms.get(i).getRank()+ "\n";
                    s2 += "Год релиза: " + searchedFilms.get(i).getReleased()+ "\n";
                    s2 += "Ссылка: " + searchedFilms.get(i).getLink()+ "\n";
                    s2 += "Картинка: " + searchedFilms.get(i).getImage()+ "\n";
                    s2 += "Рейтинг: " + searchedFilms.get(i).getRating()+ "\n";
                    s2 += "Жанры: ";
                    for (int j = 0; j < searchedFilms.get(i).getGanre().size(); j++)
                    {
                        s2 += searchedFilms.get(i).getGanre().get(j) + ", ";
                    }
                    s2 += "\n\n\n";
                    label.resize(1000,height);
                    height2+=5;
                    height+=40;
                    //System.out.println(s);
                }
                label.setText(s2);
                s2 = "";
            }
        });
        randomFilm.setOnAction(event -> {
            Film randFilm = new Film();
            randFilm = listFilms.RandomFilm();
            String s3 = "";
            s3 += "ID: " + randFilm.getId() + "\n";
            s3 += "Название: " + randFilm.getTitle()+ "\n";
            s3 += "Описание: " + randFilm.getDescription()+ "\n";
            s3 += "Ранг: " + randFilm.getRank()+ "\n";
            s3 += "Год релиза: " + randFilm.getReleased()+ "\n";
            s3 += "Ссылка: " + randFilm.getLink()+ "\n";
            s3 += "Картинка: " + randFilm.getImage()+ "\n";
            s3 += "Рейтинг: " + randFilm.getRating()+ "\n";
            s3 += "Жанры: ";
            for (int j = 0; j < randFilm.getGanre().size(); j++)
            {
                s3 += randFilm.getGanre().get(j) + ", ";
            }
            label.setText(s3);
            s3 = "";
        });
    }
}

