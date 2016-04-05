package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.price.*;
import com.scrumtrek.simplestore.report.JSONReport;
import com.scrumtrek.simplestore.report.ReportType;
import com.scrumtrek.simplestore.report.SimpleReport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class CustomerTest {
    private String movieTitle;

    private SimpleReport simpleReport;
    private JSONReport jsonReport;
    private Customer customerRegular;
    private Customer customerChildren;
    private Customer customerNewRelease;
    private Customer customerXXX;

    @Before
    public void setUp() {
        movieTitle = "mov-title";
        customerRegular = createCustomer(new Regular(), movieTitle);
        customerChildren = createCustomer(new Children(), movieTitle);
        customerNewRelease = createCustomer(new NewRelease(), movieTitle);
        customerXXX = createCustomer(new XXX(), movieTitle);
        simpleReport = new SimpleReport();
        jsonReport = new JSONReport();
    }
    @Test
    public void testCustomerRegularPlainMax() {
        String result = simpleReport.generate(customerRegular, ReportType.MAX);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));
    }

//    @Test
//    public void testCustomerRegularPlainMedium() {
//        String result = simpleReport.generate(customerRegular, ReportType.MEDIUM);
//        String[] resultRows = result.split("\\n");
//        assertTrue(resultRows[0].contains(movieTitle));
//        assertTrue(resultRows[1].contains("15.5"));
//    }

    @Test
    public void testCustomerRegularPlainShort() {
        String result = simpleReport.generate(customerRegular, ReportType.SHORT);
        String[] resultRows = result.split("\\n");
        System.out.println(result);
        assertTrue(resultRows[0].contains("some-name"));
        assertTrue(resultRows[1].contains("15.5"));
    }

    @Test
    public void testCustomerRegularJSON() {

        String result = jsonReport.generate(customerRegular, ReportType.MAX);
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
    public void testCustomerChildrenPlain() {
        String result = simpleReport.generate(customerChildren, ReportType.MAX);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));
    }

    @Test
    public void testCustomerChildrenJSON() {
        String result = jsonReport.generate(customerChildren, ReportType.MAX);
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
    public void testCustomerNewReleasePlain() {
        String result = simpleReport.generate(customerNewRelease, ReportType.MAX);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("33.0"));
    }

    @Test
    public void testCustomerNewReleaseJSON() {
        String result = jsonReport.generate(customerNewRelease, ReportType.MAX);
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
    @Test
    public void testCustomerXXXPlain() {

        String movieTitle = "mov-title";
        Customer c = createCustomer(new XXX(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generate(c, ReportType.MAX);
        System.out.println(result);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));
    }

    @Test
    public void testCustomerXXXJSON() {
        String result = jsonReport.generate(customerXXX, ReportType.MAX);
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

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewRelease() {
        String movieTitle = "mov-title";
        Customer c = createFailCustomer(new NewRelease(), movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        simpleReport.generate(c, ReportType.MAX);
    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewReleaseJSON() {
        String movieTitle = "mov-title";
        Customer c = createFailCustomer(new NewRelease(), movieTitle);
        JSONReport jsonReport = new JSONReport();
        jsonReport.generate(c, ReportType.MAX);
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
