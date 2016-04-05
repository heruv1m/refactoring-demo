package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.api.StatmentReport;
import com.scrumtrek.simplestore.model.Customer;
import com.scrumtrek.simplestore.model.Customer.CustomerReport;
import com.scrumtrek.simplestore.model.Rental;
import com.scrumtrek.simplestore.model.Rental.RentalReport;
import com.scrumtrek.simplestore.model.Movie;
import com.scrumtrek.simplestore.model.ReportType;
import org.json.JSONObject;

public final class StringStatmentReport extends StatmentReport {

    @Override
    public String report(Customer customer,  ReportType type) {


        StringBuilder sb = new StringBuilder();

        switch (type) {
            case FULL: {
                return sb.append(reportHeader(customer))
                        .append(reportBody(customer))
                        .append(reportFooter(customer)).toString();

            }
            case MEDIUM: {
                return sb.append(reportHeader(customer))
                        .append(reportMediumBody(customer))
                        .append(reportFooter(customer)).toString();

            }
            case SHORT: {
                return sb.append(reportHeader(customer))
                        .append(reportFooter(customer)).toString();
            }
            default:
                return "";
        }
    }

    public String reportHeader(Customer customer) {
        return "Rental record for " + customer.getName() + "\n";

    }

    public String reportBody(Customer customer) {
        Customer.CustomerReport cr = customer.report();

        String result = new String();

        for (Rental.RentalReport rr : cr.getRentalReports()) {
            result += "\t" + "rental for: " + rr.getRentalAmount() + "\n";
            for (Movie m : rr.getMovies()) {
                result += "\t\t" + m.getTitle() + "\n";
            }


        }
        return result;
    }

    public String reportMediumBody(Customer customer) {
        Customer.CustomerReport cr = customer.report();
        String result = new String();

        for (Rental.RentalReport rr : cr.getRentalReports()) {
            result += "\t" + "rental for: " + rr.getRentalAmount() + "\n";

        }
        return result;
    }

    public String reportFooter(Customer customer) {
        return "Amount owed is " + customer.report().getTotalAmount() + "\n";
    }

}
