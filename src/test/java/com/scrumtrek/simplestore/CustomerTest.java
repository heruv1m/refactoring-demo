package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by student on 04.04.2016.
 */
public class CustomerTest {
    @Test
    public void testCustomerRegular(){
        String movieTitle = "mov-title";
/*//        PriceCodes ps = PriceCodes.Regular;
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(m, days);
        c.addRental(r);*/
        Customer c = createCustomer(PriceCodes.Regular, movieTitle);
        String result = c.Statement();
        System.out.println(result);
       String[] resultRows =  result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("15.5"));

    }

    @Test
    public void testCustomerChildren(){
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.Childrens, movieTitle);
        String result = c.Statement();
        System.out.println(result);
        String[] resultRows =  result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("12.0"));

    }

    @Test
    public void testCustomerNewRelease(){
        String movieTitle = "mov-title";
        Customer c = createCustomer(PriceCodes.NewRelease, movieTitle);
        String result = c.Statement();
        System.out.println(result);
        String[] resultRows =  result.split("\\n");
        assertTrue(resultRows[1].contains(movieTitle));
        assertTrue(resultRows[1].contains("33.0"));

    }

    @Test(expected = NullPointerException.class)
    public void testFailCustomerNewRelease(){
        String movieTitle = "mov-title";
        Customer c =
                createFailCustomer(PriceCodes.NewRelease, movieTitle);
         c.Statement();


    }

    public Customer createCustomer(PriceCodes ps, String movieTitle){

        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = "some-name";
        Customer c = new Customer(customerName);
        Rental r = new Rental(m, days);
        c.addRental(r);
        return c;
    }

    public Customer createFailCustomer(PriceCodes ps, String movieTitle){
        int days = 11;
        Movie m = new Movie(movieTitle, ps);
        String customerName = null;
        Customer c = new Customer(customerName);
        Rental r = null;
        c.addRental(r);
        return c;
    }
}
