package com.scrumtrek.simplestore;

/**
 * Created by student on 04.04.2016.
 */
public class MovieOrder {
    private Movie movie;
    private double amount;

    public MovieOrder(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
