package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.*;

import java.util.List;

/**
 * Created by dmitry on 05/04/16.
 */
public abstract class AbstractReport {
    protected abstract String print(Customer customer);

    public String generate(Customer customer) {
        for (Rental rental : customer.getRentals()) {
            rental.setRentalAmount(0);
            List<MovieOrder> movieOrders = rental.getMovieOrders();
            for (MovieOrder movieOrder : movieOrders) {
                movieOrder.setAmount(0);
                Movie m = movieOrder.getMovie();
                switch (m.getPriceCode()) {
                    case REGULAR:
                        movieOrder.setAmount(movieOrder.getAmount() + 2);
                        if (rental.getDaysRented() > 2) {
                            movieOrder.setAmount(movieOrder.getAmount() + (rental.getDaysRented() - 2) * 1.5);
                        }
                        break;
                    case NEWRELEASE:
                        movieOrder.setAmount(movieOrder.getAmount() + rental.getDaysRented() * 3);
                        break;
                    case CHILDRENS:
                        movieOrder.setAmount(movieOrder.getAmount() + 1.5);
                        if (rental.getDaysRented() > 3) {
                            movieOrder.setAmount((rental.getDaysRented() - 3) * 1.5);
                        }
                        break;
                }
                rental.setRentalAmount(rental.getRentalAmount() + movieOrder.getAmount());
            }
            customer.setTotalAmount(customer.getTotalAmount() + rental.getRentalAmount());
        }
        return print(customer);
    }
}
