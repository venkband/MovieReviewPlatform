package com.bandaru.ven.MovieReviewPlatform.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String user;
    int reviewed_movies;
    boolean flg_critic;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getReviewed_movies() {
        return reviewed_movies;
    }

    public void setReviewed_movies(int reviewed_movies) {
        this.reviewed_movies = reviewed_movies;
    }

    public boolean getFlg_critic() {
        return flg_critic;
    }

    public void setFlg_critic(boolean flg_critic) {
        this.flg_critic = flg_critic;
    }

    public User(String user)
    {
        this.user = user;
    }

    public User()
    {

    }
}
