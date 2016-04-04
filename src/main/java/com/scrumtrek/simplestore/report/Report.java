package com.scrumtrek.simplestore.report;
import com.scrumtrek.simplestore.Customer;

/**
 * Created by dmitry on 04/04/16.
 */
public interface Report<T> {
    T generateReport(Customer customer);
}