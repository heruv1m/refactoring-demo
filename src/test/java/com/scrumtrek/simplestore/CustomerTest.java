package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.price.*;
import com.scrumtrek.simplestore.report.JSONReport;
import com.scrumtrek.simplestore.report.SimpleReport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class CustomerTest {
    @Test
    public void testCustomerRegular() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(new Regular(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generate(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));
    }

    @Test
    public void testCustomerRegularJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(new Regular(), movieTitle);
        JSONReport jsonReport = new JSONReport();
        String result = jsonReport.generate(c);
        System.out.println("result = " + result);

        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 15.5,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\"\n" +
                "      },\n" +
                "      \"amount\" : 15.5\n" +
                "    } ],\n" +
                "    \"daysPeriod\" : 11,\n" +
                "    \"rentalAmount\" : 15.5,\n" +
                "    \"daysRented\" : 11\n" +
                "  } ]\n" +
                "}"));
    }

    @Test
    public void testCustomerChildren() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(new Children(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generate(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));
    }

    @Test
    public void testCustomerChildrenJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(new Children(), movieTitle);
        c.setTotalAmount(c.getTotalAmount());
        JSONReport jsonReport = new JSONReport();
        String result = jsonReport.generate(c);
        System.out.println("result = " + result);
        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 12.0,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\"\n" +
                "      },\n" +
                "      \"amount\" : 12.0\n" +
                "    } ],\n" +
                "    \"daysPeriod\" : 11,\n" +
                "    \"rentalAmount\" : 12.0,\n" +
                "    \"daysRented\" : 11\n" +
                "  } ]\n" +
                "}"));
    }

    @Test
    public void testCustomerNewRelease() {

        String movieTitle = "mov-title";
        Customer c = createCustomer(new NewRelease(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generate(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("33.0"));
    }

    @Test
    public void testCustomerXXX() {

        String movieTitle = "mov-title";
        Customer c = createCustomer(new XXX(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generate(c);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));
    }

    @Test
    public void testCustomerNewReleaseJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(new NewRelease(), movieTitle);
        JSONReport json = new JSONReport();
        String result = json.generate(c);
        System.out.println("result = " + result);

        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 33.0,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\"\n" +
                "      },\n" +
                "      \"amount\" : 33.0\n" +
                "    } ],\n" +
                "    \"daysPeriod\" : 11,\n" +
                "    \"rentalAmount\" : 33.0,\n" +
                "    \"daysRented\" : 11\n" +
                "  } ]\n" +
                "}"));
    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewRelease() {
        String movieTitle = "mov-title";
        Customer c = createFailCustomer(new NewRelease(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        simpleReport.generate(c);
    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewReleaseJSON() {
        String movieTitle = "mov-title";
        Customer c = createFailCustomer(new NewRelease(), movieTitle);
        JSONReport jsonReport = new JSONReport();
        jsonReport.generate(c);
    }

    private Customer createCustomer(AbstractPriceCode ps, String movieTitle) {
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(days);
        MovieOrder mo = new MovieOrder(m);
        r.addMovie(mo);
        r.setRentalAmount(r.getRentalAmount());
        r.setDaysPeriod(r.getDaysPeriod());
        c.addRental(r);
        return c;
    }

    private Customer createFailCustomer(AbstractPriceCode ps, String movieTitle) {
        Movie m = new Movie(movieTitle, ps);
        m.setPriceCode(m.getPriceCode());
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = null;
        MovieOrder movieOrder = new MovieOrder(m);
        movieOrder.setMovie(movieOrder.getMovie());
        r.addMovie(movieOrder);
        c.addRental(r);
        return c;
    }
}
