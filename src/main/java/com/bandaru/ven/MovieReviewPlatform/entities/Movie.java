package com.bandaru.ven.MovieReviewPlatform.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    String name;
    int year;
    String genre;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Movie(String name , int year,String genre)
    {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public Movie()
    {

    }
}
