package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 04/04/16.
 */
public class Customer {
    private String name;
    private long totalAmount;
    private long bonusPoints;

    public List<Rental> getRentals() {
        return rentals;
    }

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(long bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public void init() {

        for (Rental rental : rentals) {
            double rentalAmount = 0;
            List<MovieOrder> movies = rental.getMovieOrders();
            for (MovieOrder mOrder : movies) {
                double thisAmount = 0;
                Movie m = mOrder.getMovie();
                switch (m.getPriceCode()) {
                    case REGULAR:
                        thisAmount += 2;
                        if (rental.getDaysRented() > 2) {
                            thisAmount += (rental.getDaysRented() - 2) * 1.5;
                        }
                        break;

                    case NEWRELEASE:
                        thisAmount += rental.getDaysRented() * 3;
                        break;

                    case CHILDRENS:
                        thisAmount += 1.5;
                        if (rental.getDaysRented() > 3) {
                            thisAmount = (rental.getDaysRented() - 3) * 1.5;
                        }
                        break;
                }

                // Add frequent renter points
                bonusPoints++;

                // Add bonus for a two-day new-release rental
                if ((m.getPriceCode() == PriceCodes.NEWRELEASE) && (rental.getDaysRented() > 1)) {
                    bonusPoints++;
                }
                mOrder.setAmount(thisAmount);
                rentalAmount += thisAmount;
            }
            rental.setRentalAmount(rentalAmount);
            totalAmount += rentalAmount;

        }
    }
}

