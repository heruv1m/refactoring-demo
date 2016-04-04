package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by student on 04.04.2016.
 */
public class CustomerTest {
    @Test
    public void testCustomerRegular(){
        String movieTitle = "mov-title";
        String movieTitle2 = "mov-title2";
        PriceCodes ps = PriceCodes.Regular;
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(m, days);
//        c.addRental(r);
        c.addRental(r);
        String result = c.Statement();
        System.out.println(result);
       String[] resultRows =  result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));

    }
}
