package com.scrumtrek.simplestore.price;

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
