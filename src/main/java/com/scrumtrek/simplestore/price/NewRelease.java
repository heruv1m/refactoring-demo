package com.scrumtrek.simplestore.price;


public class NewRelease extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        return days * 3;
    }
}
