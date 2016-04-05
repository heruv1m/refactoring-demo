package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.price.AbstractPriceCode;
import org.codehaus.jackson.annotate.JsonIgnore;

public class Movie {
    private String title;

    @JsonIgnore
    private AbstractPriceCode priceCode;


    public Movie(String title, AbstractPriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public AbstractPriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(AbstractPriceCode value) {
        priceCode = value;
    }

    public String getTitle() {
        return title;
    }
}

