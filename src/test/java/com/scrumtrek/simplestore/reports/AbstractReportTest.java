package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.Movie;
import com.scrumtrek.simplestore.model.PriceCodesParams;
import com.scrumtrek.simplestore.model.Rental;

/**
 * Created by xpeh on 05.04.16.
 */
public abstract  class AbstractReportTest {


    protected PriceCodesParams childrenPriceCodeParam;
    protected PriceCodesParams regularPriceCodeParam;
    protected PriceCodesParams newReleasePriceCodeParam;
    protected PriceCodesParams xxxPriceCodeParam;

    protected Customer custMickeyMouse;

    protected  Movie movCinderella;
    protected  Movie movStarWars;
    protected  Movie movGladiator;
    protected  Movie xxxMov;


    @org.junit.Before
    public void setUp() throws Exception {

        childrenPriceCodeParam = new PriceCodesParams(3, 1.5, 1.5,true);
        regularPriceCodeParam = new PriceCodesParams(2, 2.0, 1.5,false);
        newReleasePriceCodeParam = new PriceCodesParams(0, 0, 3,false);
        xxxPriceCodeParam = new PriceCodesParams(4, 2.0, 1.5,false);

        movCinderella = new Movie("Cinderella", childrenPriceCodeParam);
        movStarWars = new Movie("Star Wars", regularPriceCodeParam);
        movGladiator = new Movie("Gladiator", newReleasePriceCodeParam);
        xxxMov = new Movie("XXX", xxxPriceCodeParam);
    }

}
