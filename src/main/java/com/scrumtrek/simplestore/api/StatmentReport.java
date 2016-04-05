package com.scrumtrek.simplestore.api;

import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.ReportType;

/**
 * Абстрактный класс для репортов
 */
public abstract class StatmentReport {
	
	protected double totalAmount;
	
	protected int frequentRenterPoints;
	
    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    /**
     * Абстрактный метод для создания отчетов
     * @param customer
     * @param type
     * @return
     */
    public abstract String report(Customer customer, ReportType type);
}
