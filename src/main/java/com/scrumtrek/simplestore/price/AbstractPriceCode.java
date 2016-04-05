package com.scrumtrek.simplestore.price;


public abstract class AbstractPriceCode {
    /**
     * Возвращает стоимость в зависимост от количества дней
     * @param days
     * @return
     */
    public abstract double getAmount(int days);
}
