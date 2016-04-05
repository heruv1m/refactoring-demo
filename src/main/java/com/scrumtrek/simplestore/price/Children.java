package com.scrumtrek.simplestore.price;

/**
 * Created by dmitry on 05/04/16.
 */
public class Children extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        double result = 1.5;
        if (days > 3) {
            result = (days - 3) * 1.5;
        }
        return  result;
    }
}
