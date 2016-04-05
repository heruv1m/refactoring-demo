package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.api.StatmentReport;
import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.Movie;
import com.scrumtrek.simplestore.model.PriceCodes;
import com.scrumtrek.simplestore.model.Rental;
import org.json.JSONObject;

public final class JSONStatmentReport extends StatmentReport {


	public  static final String FOOTER = "footer";
	public  static final String HEADER = "header";
	public  static final String CUSTOMER_NAME = "customerName";
	public  static final String BODY = "body";
	public  static final String TITTLE = "tittle";
	public  static final String AMOUNT = "amount";
	public  static final String TOTAL_AMOUNT = "totalAmount";
	public  static final String RENTAL = "rental";
	public  static final String MOVIE = "movie";

	public JSONObject reportHeader(Customer customer) {
		JSONObject  header = new JSONObject();
		header.put (CUSTOMER_NAME,customer.getName());
		return  header;

	}

	public JSONObject reportBody(Customer customer) {
		Customer.CustomerReport cr = customer.report();

		JSONObject  body = new JSONObject();


		for (Rental.RentalReport rr: cr.getRentalReports()) {

			JSONObject rental = new JSONObject();

			for (Movie m: rr.getMovies()) {
				JSONObject  movie = new JSONObject();
				movie.put(TITTLE,m.getTitle());
				rental.append(MOVIE,movie);
			}

			rental.put(AMOUNT,rr.getRentalAmount());
			body.append(RENTAL, rental);

		}


		return body;
	}

	public JSONObject reportFooter(Customer customer) {
		Customer.CustomerReport cr = customer.report();

		JSONObject  footer = new JSONObject();
		footer.put (TOTAL_AMOUNT, cr.getTotalAmount());
		return footer;
	}

	@Override
	public String report(Customer customer) {

		return new JSONObject().put(HEADER,reportHeader(customer)).
				append(FOOTER,reportFooter(customer)).append(BODY,reportBody(customer)).toString();
	}

}
