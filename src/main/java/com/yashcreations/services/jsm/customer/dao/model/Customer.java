package com.yashcreations.services.jsm.customer.dao.model;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.WebApplicationException;

import org.codehaus.jackson.map.ObjectMapper;

public class Customer implements Serializable 
{
	long custId;
	String name;
	int age;
	OperationStatus operationStaus;
	public OperationStatus getOperationStaus() {
		return operationStaus;
	}

	public void setOperationStaus(OperationStatus operationStaus) {
		this.operationStaus = operationStaus;
	}

	public Customer(){
		operationStaus=new OperationStatus();
	}

	public Customer(long custId, String name, int age) {
		this.custId = custId;
		this.name = name;
		this.age = age;
	}

	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [age=" + age + ", custId=" + custId + ", name=" + name
				+ "]";
	}
	/*public static Customer fromString(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
        Customer o= null;
        try {
                o = mapper.readValue(jsonRepresentation, Customer.class );
        } catch (IOException e) {
                 throw new WebApplicationException();
        }
        return o;
}*/
	/*public static Customer[] fromString(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
        Customer[] o= null;
        try {
                o = mapper.readValue(jsonRepresentation, Customer[].class );
        } catch (IOException e) {
                 throw new WebApplicationException();
        }
        return o;
}*/


}
