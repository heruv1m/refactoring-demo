package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.StringReport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class CustomerTest {
    @Test
    public void testCustomerRegular() {
        String movieTitle = "mov-title";
        PriceCodes ps = PriceCodes.Regular;
        int days = 11;

        Customer c = createCustomer(PriceCodes.Regular, movieTitle);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));

    }

    @Test
    public void testCustomerChildren() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.Childrens, movieTitle);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));

    }

    @Test
    public void testCustomerNewRelease() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.NewRelease, movieTitle);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("33.0"));

    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewRelease() {
        String movieTitle = "mov-title";
        Customer c =
                createFailCustomer(PriceCodes.NewRelease, movieTitle);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);


    }

    @Test
    public void testFrequentRenterPointsNoBonus() {
        String movieTitle = "mo         v-title";
        PriceCodes ps = PriceCodes.Regular;
        int days = 1;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
//        Rental r = new Rental(m, days);
        Customer c = createCustomer(PriceCodes.Regular, movieTitle);
//        c.addRental(r);
        StringReport stringReport = new StringReport();
        String result = stringReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[4].contains("2"));
    }

    public Customer createCustomer(PriceCodes ps, String movieTitle) {

        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
//        Rental r = new Rental(m, days);
//        c.addRental(r);
        return c;
    }

    public Customer createFailCustomer(PriceCodes ps, String movieTitle) {
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(days);
        MovieOrder movieOrder = new MovieOrder(m);
        r.addMovie(movieOrder);
        c.addRental(r);
        return c;
    }
}
