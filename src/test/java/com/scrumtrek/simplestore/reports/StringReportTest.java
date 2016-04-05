package com.scrumtrek.simplestore.reports;

import java.util.ArrayList;
import java.util.List;

import com.scrumtrek.simplestore.model.ReportType;
import com.scrumtrek.simplestore.reports.AbstractReportTest;

import org.junit.Test;

import com.scrumtrek.simplestore.api.StatmentReport;
import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.Movie;
import com.scrumtrek.simplestore.model.Rental;
import com.scrumtrek.simplestore.model.Rental.RentalReport;
import com.scrumtrek.simplestore.reports.StringStatmentReport;

import static org.junit.Assert.*;


public class StringReportTest  extends AbstractReportTest {



    /**
     * Общий тест на все типы стоимостей фильмов
     */
    @Test
    public void testAddRental() {
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
        StatmentReport report = new StringStatmentReport();
        
        String statementReport = report.report(custMickeyMouse, ReportType.FULL);

        // Print the statement
        System.out.println(statementReport);

        assertNotNull(statementReport);
        
        assertTrue("Mickey Mouse wasn't mentioned", statementReport.contains(custMickeyMouse.getName()));
        
        assertTrue("Cinderella wasn't added to Rental", statementReport.contains(movCinderella.getTitle()));
        assertTrue("Star Wars wasn't added to Rental", statementReport.contains(movStarWars.getTitle()));
        assertTrue("Gladiator wasn't added to Rental", statementReport.contains(movGladiator.getTitle()));
        assertTrue("totalAmount must be 27", statementReport.contains("Amount owed is 27.0"));
}
    
    /**
     * 
     */
    @Test
    public void testChildRental() {
        custMickeyMouse = new Customer("Mickey Mouse");
        
        List<Movie> movies = new ArrayList<>();
        movies.add(movCinderella);
        //childrenPriceCodeParam
        Rental childRental = new Rental(movies, 5);
        custMickeyMouse.addRental(childRental);
        
        RentalReport repData = childRental.count();
        
        assertEquals("Amount for child rental for 5 days must be " + 3.0, 3.0, repData.getRentalAmount(), 0.001);
   }
}