package com.scrumtrek.simplestore.model;

public class Movie {
    private String title;
    private PriceCodesParams priceCode;

    public Movie(String title, PriceCodesParams priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCodesParams getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCodesParams value) {
        priceCode = value;
    }

    public String getTitle() {
        return title;
    }
}
