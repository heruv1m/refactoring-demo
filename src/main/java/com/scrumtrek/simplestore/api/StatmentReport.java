package com.scrumtrek.simplestore.api;

import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.ReportType;

public abstract class StatmentReport {
	
	protected double totalAmount;
	
	protected int frequentRenterPoints;
	
    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public abstract String report(Customer customer, ReportType type);
}
