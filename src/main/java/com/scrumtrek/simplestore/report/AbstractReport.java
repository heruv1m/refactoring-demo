package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.*;

import java.util.List;


public abstract class AbstractReport {
    protected abstract String print(Customer customer, ReportType type);

    /**
     *
     * Генерирует данные для отчета
     * @param customer
     * @return
     */
    public String generate(Customer customer, ReportType type) {
        for (Rental rental : customer.getRentals()) {
            rental.setRentalAmount(0);
            List<MovieOrder> movieOrders = rental.getMovieOrders();
            for (MovieOrder movieOrder : movieOrders) {
                movieOrder.setAmount(0);
                Movie m = movieOrder.getMovie();
                movieOrder.setAmount(m.getPriceCode().getAmount(rental.getDaysRented()));
                rental.setRentalAmount(rental.getRentalAmount() + movieOrder.getAmount());
            }
            customer.setTotalAmount(customer.getTotalAmount() + rental.getRentalAmount());
        }
        return print(customer, type);
    }

}
