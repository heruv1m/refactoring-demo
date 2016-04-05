package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.report.JSONReport;
import com.scrumtrek.simplestore.report.SimpleReport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class CustomerTest {
    @Test
    public void testCustomerRegular() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.REGULAR, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));
    }

    @Test
    public void testCustomerRegularJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.REGULAR, movieTitle);
        c.init();
        JSONReport jsonReport = new JSONReport();
        String result = jsonReport.generateReport(c);
        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 15,\n" +
                "  \"bonusPoints\" : 1,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\",\n" +
                "        \"priceCode\" : \"REGULAR\"\n" +
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
        Customer c = createCustomer(PriceCodes.CHILDRENS, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));
    }

    @Test
    public void testCustomerChildrenJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.CHILDRENS, movieTitle);
        c.init();
        JSONReport jsonReport = new JSONReport();
        String result = jsonReport.generateReport(c);
        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 12,\n" +
                "  \"bonusPoints\" : 1,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\",\n" +
                "        \"priceCode\" : \"CHILDRENS\"\n" +
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
        Customer c = createCustomer(PriceCodes.NEWRELEASE, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("33.0"));
    }

    @Test
    public void testCustomerNewReleaseJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.NEWRELEASE, movieTitle);
        c.init();
        JSONReport json = new JSONReport();
        String result = json.generateReport(c);
        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 33,\n" +
                "  \"bonusPoints\" : 2,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\",\n" +
                "        \"priceCode\" : \"NEWRELEASE\"\n" +
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
        Customer c = createFailCustomer(PriceCodes.NEWRELEASE, movieTitle);
        SimpleReport simpleReport = new SimpleReport();
        simpleReport.generateReport(c);
    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewReleaseJSON() {
        String movieTitle = "mov-title";
        Customer c = createFailCustomer(PriceCodes.NEWRELEASE, movieTitle);
        JSONReport jsonReport = new JSONReport();
        jsonReport.generateReport(c);
    }

    @Test
    public void testFrequentRenterPointsNoBonus() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.NEWRELEASE, movieTitle);
        c.init();
        SimpleReport simpleReport = new SimpleReport();
        String result = simpleReport.generateReport(c);
        String[] resultRows = result.split("\\n");
        assertTrue(resultRows[3].contains("2"));
    }

    @Test
    public void testFrequentRenterPointsNoBonusJSON() {
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.NEWRELEASE, movieTitle);
        c.init();
        JSONReport jsonReport = new JSONReport();
        String result = jsonReport.generateReport(c);
        assertTrue(result.equals("{\n" +
                "  \"name\" : \"some-name\",\n" +
                "  \"totalAmount\" : 33,\n" +
                "  \"bonusPoints\" : 2,\n" +
                "  \"rentals\" : [ {\n" +
                "    \"movieOrders\" : [ {\n" +
                "      \"movie\" : {\n" +
                "        \"title\" : \"mov-title\",\n" +
                "        \"priceCode\" : \"NEWRELEASE\"\n" +
                "      },\n" +
                "      \"amount\" : 33.0\n" +
                "    } ],\n" +
                "    \"daysPeriod\" : 11,\n" +
                "    \"rentalAmount\" : 33.0,\n" +
                "    \"daysRented\" : 11\n" +
                "  } ]\n" +
                "}"));
    }

    private Customer createCustomer(PriceCodes ps, String movieTitle) {
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

    private Customer createFailCustomer(PriceCodes ps, String movieTitle) {
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
