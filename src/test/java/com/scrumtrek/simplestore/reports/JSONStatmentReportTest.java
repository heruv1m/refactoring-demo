package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.api.StatmentReport;
import com.scrumtrek.simplestore.model.*;


import org.json.JSONArray;
import com.scrumtrek.simplestore.reports.JSONStatmentReport;

import org.json.JSONObject;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xpeh on 04.04.16.
 */
public class JSONStatmentReportTest extends  AbstractReportTest {


    @Test
    public void testPrintJSONReport() {

        // Create movies
        List<Movie> movies = new ArrayList<>();
        movies.add(movCinderella);
        movies.add(movStarWars);
        movies.add(movGladiator);
        movies.add(xxxMov);

        Rental rental = new Rental(movies, 5);


        custMickeyMouse = new Customer("Mickey Mouse");
        // Assign rentals to customers
        custMickeyMouse.addRental(rental);

        // Generate invoice
        JSONStatmentReport report = new JSONStatmentReport();

        String jsonReport = report.report(custMickeyMouse);

        // Print the statement
        System.out.println(jsonReport);

    }

    @Test
    public void testJSONReportFooterTotalAmount() {

        // Create movies
        List<Movie> movies = new ArrayList<>();
        movies.add(movCinderella);
        movies.add(movStarWars);
        movies.add(movGladiator);
        movies.add(xxxMov);

        Rental rental = new Rental(movies, 5);


        custMickeyMouse = new Customer("Mickey Mouse");
        // Assign rentals to customers
        custMickeyMouse.addRental(rental);

        // Generate invoice
        JSONStatmentReport report = new JSONStatmentReport();

        String jsonReport = report.report(custMickeyMouse);

        // Print the statement
        System.out.println(jsonReport);
        JSONObject json = new JSONStatmentReport().reportFooter(custMickeyMouse);

        Double totalAmount = json.getDouble(JSONStatmentReport.TOTAL_AMOUNT);
        System.out.println(totalAmount);
        assertEquals ("Total amount not equals", totalAmount,27.0,0.01);

    }

    @Test
    public void testJSONReportBodyAmount() {

        // Create movies
        List<Movie> movies = new ArrayList<>();
        movies.add(movCinderella);
        movies.add(movStarWars);
        movies.add(movGladiator);
        movies.add(xxxMov);

        Rental rental = new Rental(movies, 5);


        custMickeyMouse = new Customer("Mickey Mouse");
        // Assign rentals to customers
        custMickeyMouse.addRental(rental);

        // Generate invoice
        JSONStatmentReport report = new JSONStatmentReport();

        String jsonReport = report.report(custMickeyMouse);


        JSONObject json = new JSONStatmentReport().reportBody(custMickeyMouse);

        JSONArray array =  (JSONArray) json.get(JSONStatmentReport.RENTAL);

        Double amount = array.getJSONObject(0).getDouble(JSONStatmentReport.AMOUNT);

        assertEquals  ("Total amount not equals", amount,27.0,0.01);

    }

    @Test
    public void testJSONPrintReportTwoRental (){

        // Create movies
        List<Movie> movies = new ArrayList<>();
        movies.add(movCinderella);
        movies.add(movStarWars);


        Rental rental1 = new Rental(movies, 5);


        custMickeyMouse = new Customer("Mickey Mouse");

        // Create movies
        movies = new ArrayList<>();

        movies.add(xxxMov);

        Rental rental2 = new Rental(movies, 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);

        // Generate invoice
        JSONStatmentReport report = new JSONStatmentReport();

        String jsonReport = report.report(custMickeyMouse);

        // Print the statement
        System.out.println(jsonReport);

        JSONObject footer = new JSONStatmentReport().reportFooter(custMickeyMouse);

        Double totalAmount = footer.getDouble(JSONStatmentReport.TOTAL_AMOUNT);


        JSONObject body = new JSONStatmentReport().reportBody(custMickeyMouse);

        JSONArray array =  (JSONArray) body.get(JSONStatmentReport.RENTAL);

        Double amount1 = array.getJSONObject(0).getDouble(JSONStatmentReport.AMOUNT);


        Double amount2 = array.getJSONObject(1).getDouble(JSONStatmentReport.AMOUNT);

        assertEquals("Total account are not eqaul rental amounts", totalAmount, amount1 + amount2 , 0.01);







    }

}