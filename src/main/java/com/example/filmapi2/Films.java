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
        int rand = new Random().ints(1, 1, 11).findFirst().getAsInt();
        this.films.get(rand);

        return this.films.get(rand);
    }
}
