package com.TravelAgency.TravelAgency.service;

import java.util.List;

import com.TravelAgency.TravelAgency.entity.Customer;
import com.TravelAgency.TravelAgency.exception.CustomException;

public interface customerService {
	
	//create customer
	public Customer createcustomer(Customer customer) throws CustomException;
	
	//create multiple customer
	public List<Customer> createcustomers (List<Customer> customers)throws CustomException;
	
	//get customerById
	public Customer getcustomerById(int id) throws CustomException;
	
	//get all customer
	public List<Customer> getcustomers() throws CustomException;
	
	//update customer with id
	public Customer updatecustomer(int id,Customer customer) throws CustomException;
	
	//Delete customer with id
	public String deletecustomerById(int id)throws CustomException;

}
