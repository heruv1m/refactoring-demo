package com.scrumtrek.simplestore.model;

public class PriceCodesParams {
    private int days;
    private double price;
    private double coeff;
    private boolean isFreeDays;

    public PriceCodesParams(int days, double price, double coeff,
            boolean isFreeDays) {
        super();
        this.days = days;
        this.price = price;
        this.coeff = coeff;
        this.isFreeDays = isFreeDays;
    }

    public int getDays() {
        return days;
    }

    public double getPrice() {
        return price;
    }

    public double getCoeff() {
        return coeff;
    }

    public boolean isFreeDays() {
        return isFreeDays;
    }
    
    

}
