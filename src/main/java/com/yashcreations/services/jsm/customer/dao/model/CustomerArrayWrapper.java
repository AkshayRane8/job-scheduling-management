package com.yashcreations.services.jsm.customer.dao.model;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.WebApplicationException;

import org.codehaus.jackson.map.ObjectMapper;

public class CustomerArrayWrapper implements Serializable {
	private Customer[] customerArray;

	public Customer[] getCustomerArray() {
		return customerArray;
	}

	public void setCustomerArray(Customer[] customerArray) {
		this.customerArray = customerArray;
	}

	public static CustomerArrayWrapper fromString(String jsonRepresentation) {
		ObjectMapper mapper = new ObjectMapper(); // Jackson's JSON marshaller
		CustomerArrayWrapper o = null;
		try {
			o = mapper.readValue(jsonRepresentation, CustomerArrayWrapper.class);
		} catch (IOException e) {
			throw new WebApplicationException();
		}
		return o;
	}
}
