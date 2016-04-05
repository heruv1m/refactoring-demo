package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by dmitry on 04/04/16.
 */
public class JSONReport extends AbstractReport {
    @Override
    protected String print(Customer customer) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        return result;
    }
}