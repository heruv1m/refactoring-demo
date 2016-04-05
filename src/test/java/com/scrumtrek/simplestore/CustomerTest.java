package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.SimpleReport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class CustomerTest {
    @Test
    public void testCustomerRegular() {
        String movieTitle = "mov-title";
        int days = 11;
        Customer c = createCustomer(PriceCodes.Regular, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));

    }

    @Test
    public void testCustomerChildren() {

        String movieTitle = "mov-title";
        int days = 11;
        Customer c = createCustomer(PriceCodes.Childrens, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));

    }

    @Test
    public void testCustomerNewRelease() {

        String movieTitle = "mov-title";
        int days = 11;
        Customer c = createCustomer(PriceCodes.NewRelease, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
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
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);

    }

    @Test
    public void testFrequentRenterPointsNoBonus() {
        String movieTitle = "mov-title";
        int days = 11;
        Customer c = createCustomer(PriceCodes.NewRelease, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[3].contains("2"));
    }

    public Customer createCustomer(PriceCodes ps, String movieTitle) {

        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(days);
        MovieOrder mo = new MovieOrder(m);
        r.addMovie(mo);
        c.addRental(r);
        return c;
    }

    public Customer createFailCustomer(PriceCodes ps, String movieTitle) {
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = null;
        MovieOrder movieOrder = new MovieOrder(m);
        r.addMovie(movieOrder);
        c.addRental(r);
        return c;
    }
}
