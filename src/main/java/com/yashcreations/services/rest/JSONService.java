package com.yashcreations.services.rest;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
//http://localhost:8080/RESTfulExample/rest/application.wadl
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yashcreations.services.jsm.customer.dao.CustomerDAO;
import com.yashcreations.services.jsm.customer.dao.model.Customer;
import com.yashcreations.services.jsm.customer.dao.model.CustomerArrayWrapper;


@Path("jobs/scheduling")
public class JSONService {

	@javax.ws.rs.core.Context
	ServletContext context;

	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
	}

	@GET
	@Path("/retrievecustomerById/{customerid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer retrievecustomerById(@PathParam("customerid") String customerid) {
		System.out.println("##########################This is Called###########################");
		CustomerDAO customerSimpleDAO = (CustomerDAO) applicationContext.getBean("customerSimpleDAO");
		Customer customer = customerSimpleDAO.getCustomer(customerid);
		return customer;
	}

	@POST
	@Path("/customer/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addCustomer(Customer customer) {
		CustomerDAO customerSimpleDAO = (CustomerDAO) applicationContext.getBean("customerSimpleDAO");
		System.out.println("Customer :::::" + customer.getName());
		try{
		customerSimpleDAO.insert(customer);
		customer.getOperationStaus().setStatus("SUCCESS");
		customer.getOperationStaus().setCode("0000");
		customer.getOperationStaus().setMessage("Operation Completed Successfully");
		return Response.status(201).entity(customer).build();
		}catch(Exception ex){
			customer.getOperationStaus().setStatus("FAILED");
			customer.getOperationStaus().setCode("SQL001");
			customer.getOperationStaus().setMessage(ex.getMessage());
			return Response.status(400).entity(customer).build();
		}
	}
	
	@POST
	@Path("/customers/")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer[] retrieveCustomersForInarray(@QueryParam("customersarray") CustomerArrayWrapper customersarray) {
		CustomerDAO customerSimpleDAO = (CustomerDAO) applicationContext.getBean("customerSimpleDAO");
		System.out.println("Customer ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + customersarray.getCustomerArray()[0].getName());
		//System.out.println("Custmer Id :::" +  customer.getCustId());
		Customer[] customers = new Customer[2];
		customers[0] = customerSimpleDAO.getCustomer("4");
		customers[1] = customerSimpleDAO.getCustomer("2");
		return customers;
	}
}