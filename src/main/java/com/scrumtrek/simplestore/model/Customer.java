package com.scrumtrek.simplestore.model;

import java.util.ArrayList;
import java.util.List;

import com.scrumtrek.simplestore.model.Rental.RentalReport;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }
    
    /**
     * Расчитывает полный отчет по задолжности кастомера
     * */
    public CustomerReport report() {
        double totalAmount = 0;
        CustomerReport customerRep = new CustomerReport();
        
        for (Rental rental : rentals) {
            Rental.RentalReport rentalRep = rental.count();
            customerRep.addRental(rentalRep);
            totalAmount += rentalRep.getRentalAmount();
        }

        customerRep.setTotalAmount(totalAmount);
        
        return customerRep;
    }

    public class CustomerReport {
        private double totalAmount;
        private List<Rental.RentalReport> rentalReports;
        
        public CustomerReport() {
            this.rentalReports = new ArrayList<>();
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public List<Rental.RentalReport> getRentalReports() {
            return rentalReports;
        }
        
        public boolean addRental(Rental.RentalReport rentalRep) {
            return rentalReports.add(rentalRep);
        }
    }
}
