package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

import java.util.List;

/**
 * Created by dmitry on 04/04/16.
 */
public class SimpleReport extends AbstractReport {
    @Override
    protected String print(Customer customer) {
        final List<Rental> rentals = customer.getRentals();
        StringBuilder sb = new StringBuilder();
        sb.append("Rental record for ")
                .append(customer.getName())
                .append("\n");
        rentals.forEach(rental ->
                rental.getMovieOrders().forEach(movie ->
                        sb.append("\t")
                                .append(movie.getMovie().getTitle())
                                .append("\t")
                                .append(movie.getAmount())
                                .append("\n")));
        sb.append("Amount owed is ")
                .append(customer.getTotalAmount());
        return sb.toString();
    }
}