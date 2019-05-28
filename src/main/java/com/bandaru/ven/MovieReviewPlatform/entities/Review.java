package com.bandaru.ven.MovieReviewPlatform.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Review implements Serializable {
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Id
    String user;
    @Id
    String name;
    int rating;

    public Review(String a , String b , int c)
    {
        user= a;
        name=b;
        rating=c;
    }

    public Review()
    {

    }
}
