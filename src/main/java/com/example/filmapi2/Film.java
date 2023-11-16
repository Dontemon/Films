package com.example.filmapi2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Vector;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Film {
    String id;
    String title, link, image;
    int rank;
    int released;
    double rating;
    Vector<String> ganre;
    Vector<String> writers;
    void film(int index) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-top-100-movies.p.rapidapi.com/top"+ index))
                .header("X-RapidAPI-Key", "f011c0889bmsh6e844bf0fd6398cp1ee44bjsn295f0f5a70af")
                .header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject obj = new JSONObject(response.body());
        //System.out.println(obj.get("rank"));
        String str = obj.get("rank").toString();
        rank = Integer.parseInt(str);
        System.out.println(rank);
        str = obj.get("id").toString();
        id = str;
        title = obj.get("title").toString();
        link = obj.get("imdb_link").toString();
        image = obj.get("thumbnail").toString();
        str = obj.get("rating").toString();
        rating = Double.parseDouble(str);
        str = obj.get("year").toString();
        released = Integer.parseInt(str);

    };
    String get_title(){return title;};
    int get_Rank(){return rank;}
    double get_Rating(){return rating;}
    int get_Released(){return released;}
    String get_Link(){return link;}
    String get_Image(){return image;};
    //Vector<String> get_Ganre(){};
}

