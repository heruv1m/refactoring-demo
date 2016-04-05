package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double totalAmount;

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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

