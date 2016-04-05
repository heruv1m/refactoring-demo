package com.scrumtrek.simplestore.price;

/**
 * Created by dmitry on 05/04/16.
 */
public class Regular extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        double result = 2;
        if (days > getNumber()) {
            result += (days - 2) * 1.5;
        }
        return result;
    }

    protected int getNumber() {
        return 2;
    }
}
