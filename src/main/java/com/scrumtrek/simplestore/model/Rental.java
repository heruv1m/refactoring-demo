package com.scrumtrek.simplestore.model;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private List<Movie> movies;
    private int daysRented;

    public Rental(List<Movie> movies, int daysRented) {
        this.movies = new ArrayList<>();
        this.movies.addAll(movies);
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public RentalReport count() {
        int totalAmount = 0;

        for (Movie movie : movies) {
            double thisAmount = 0;

            // Determine amounts for each line
            PriceCodesParams priceCodeParams = movie.getPriceCode();

            int moreRentDays = this.daysRented - priceCodeParams.getDays();
            if (moreRentDays > 0) {
                thisAmount += moreRentDays * priceCodeParams.getCoeff();
            }
            if (!priceCodeParams.isFreeDays() && priceCodeParams.getDays() > 0) {
                thisAmount += priceCodeParams.getPrice();
            }

            totalAmount += thisAmount;
        }
        return new RentalReport(totalAmount, movies);
    }

    public class RentalReport {
        private double rentalAmount;
        private List<Movie> movies;
        
        public RentalReport(double rentalAmount, List<Movie> movies) {
            super();
            this.rentalAmount = rentalAmount;
            this.movies = movies;
        }

        public double getRentalAmount() {
            return rentalAmount;
        }

        public List<Movie> getMovies() {
            return movies;
        }
    }
}
