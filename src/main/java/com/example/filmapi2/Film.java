package com.example.filmapi2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Vector;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Film {
    private String id;
    private String title;
    private String description;
    private long rank;
    private long yearReleased;
    private String rating;
    private String link;
    private String image;
    private ArrayList<String> ganre;

    public Film() {}
    public Film(String title, String id, String description, long rank, long yearReleased, String rating, String link, String image, ArrayList<String> ganre) {
        this.id = id;
        this.title = title;
        this.rank = rank;
        this.description = description;
        this.yearReleased = yearReleased;
        this.rating = rating;
        this.link = link;
        this.image = image;
        this.ganre = ganre;
    }
    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }
    public String getDescription() { return description; }
    public long getRank() {
        return rank;
    }
    public long getReleased() {
        return yearReleased;
    }
    public String getRating() {
        return rating;
    }
    public String getLink() {
        return link;
    }
    public String getImage() {
        return image;
    }
    public ArrayList<String> getGanre() {
        return ganre;
    }
}

