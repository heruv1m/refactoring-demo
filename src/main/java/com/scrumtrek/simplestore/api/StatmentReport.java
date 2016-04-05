package com.scrumtrek.simplestore.api;

import com.scrumtrek.simplestore.model.Customer;

public abstract class StatmentReport {
	
	protected double totalAmount;
	
	protected int frequentRenterPoints;
	
	public abstract String report(Customer customer);

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
