package com.example.filmapi2;

import java.util.ArrayList;
import java.util.Random;

public class Films {
    private ArrayList<Film> films;
    private int quantity;

    public Films() //конструктор по умолчанию
    {
        this.films = new ArrayList<Film>();
        this.quantity = 0;
    }

    public Films(ArrayList<Film> films, int quantity) //конструктор с двумя параметрами
    {
        this.films = films;
        this.quantity = quantity;
    }

    public ArrayList<Film> getListFilms() {
        return films;
    } //геттер списка фильмов
    public int getQuantity() {
        return quantity;
    } //геттер количтества фильмов в списке
    public Film RandomFilm()  //получить случайный фильм
    {
        int rand = new Random().ints(1, 1, 100).findFirst().getAsInt();
        this.films.get(rand);
        return this.films.get(rand);
    }
    public ArrayList<Film> searchByTitle(String searchedTitle)  // поиск фильма по названию
    {
        ArrayList<Film> searchedFilms = new ArrayList<Film>();

        for (int i = 0; i < this.films.size(); i++) // идём по фильмам во всём списке
        {
            if (this.films.get(i).getTitle().toLowerCase().contains(searchedTitle.toLowerCase())) {
                searchedFilms.add(this.films.get(i));
            }
        }
        return searchedFilms;
    }
    public ArrayList<Film> chooseGanre(String ganre)  //поиск фильма по жанру
    {
        ArrayList<Film> searchedFilms = new ArrayList<Film>();
        for (int i = 0; i < this.films.size(); i++) {
            for (int j = 0; j < this.films.get(i).getGanre().size(); j++) {
                if (this.films.get(i).getGanre().get(j).equalsIgnoreCase(ganre)) {
                    searchedFilms.add(this.films.get(i));
                }
            }
        }
        return searchedFilms;
    }
}