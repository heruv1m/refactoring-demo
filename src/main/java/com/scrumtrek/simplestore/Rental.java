package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Rental {
	private List<MovieOrder> movieOrders = new ArrayList<>();
	private int daysPeriod;
	private double rentalAmount;

	public Rental(int daysPeriod) {
		this.daysPeriod = daysPeriod;
	}

	public List<MovieOrder> getMovieOrders() {
		return movieOrders;
	}

	public int getDaysRented() {
		return daysPeriod;
	}

	public void addMovie(MovieOrder m){
		movieOrders.add(m);
	}

	public void setRentalAmount(double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}
}

