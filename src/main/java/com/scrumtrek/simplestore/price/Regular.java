package com.scrumtrek.simplestore.price;


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
