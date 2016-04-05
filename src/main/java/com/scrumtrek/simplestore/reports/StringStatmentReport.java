package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.api.StatmentReport;
import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.Customer.CustomerReport;
import com.scrumtrek.simplestore.model.Rental.RentalReport;
import com.scrumtrek.simplestore.model.Movie;

public final class StringStatmentReport extends StatmentReport {

    @Override
    public String report(Customer customer) {
        this.totalAmount = 0;

        String result = "Rental record for " + customer.getName() + "\n";
        
        CustomerReport reportData = customer.report();

        for (RentalReport rentalRep: reportData.getRentalReports()) {
            result += "\t" + "rental for: " + rentalRep.getRentalAmount() + "\n";
            for (Movie movie : rentalRep.getMovies()) {
                result += "\t\t" + movie.getTitle() + "\n";
            }
        }
        // Add footer lines
        result += "Amount owed is " + reportData.getTotalAmount() + "\n";
        return result;
    }

}
