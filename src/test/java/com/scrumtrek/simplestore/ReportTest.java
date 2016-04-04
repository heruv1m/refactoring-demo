package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.StringReport;
import org.junit.Test;

/**
 * Created by student on 04.04.2016.
 */
public class ReportTest {
    @Test
    public void testCustomer() {
        String movieTitle = "mo         v-title";
        PriceCodes ps = PriceCodes.Regular;

        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(days);
        MovieOrder movieOrder = new MovieOrder(m);
        r.addMovie(movieOrder);
        c.addRental(r);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);
        System.out.println(result);
    }
}
