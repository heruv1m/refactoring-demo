package com.scrumtrek.simplestore.price;

/**
 * Created by dmitry on 05/04/16.
 */
public class NewRelease extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        return days * 3;
    }
}
