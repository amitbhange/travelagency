package com.TravelAgency.TravelAgency.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TravelAgency.TravelAgency.dao.customerRepository;
import com.TravelAgency.TravelAgency.entity.Customer;
import com.TravelAgency.TravelAgency.entity.PermanentAddress;
import com.TravelAgency.TravelAgency.exception.CustomException;

@Service
public class customerServiceImpl implements customerService{
	@Autowired
	private customerRepository customerRepository;
	
	//create Customer
	public Customer createcustomer(Customer customer) throws CustomException{
		try {
	          return customerRepository.save(customer);
	        
	    } catch ( Exception e) {
	        
	       throw new CustomException("Failed to save the customer");
    }
	}
	
    //create multiple customers
	@Override
	public List<Customer> createcustomers (List<Customer> customers) throws CustomException{
		try {
			return customerRepository.saveAll(customers);
		}catch(Exception e){
			throw new CustomException("Failed to save the multiple customers");
		}
	}
   //get customer by id 
	@Override
	public Customer getcustomerById(int id) throws CustomException{
		return customerRepository.findById(id).orElseThrow(() -> new CustomException("customer not found with id: " + id));
		
	}
	
    //get all customers
	@Override
	public List<Customer> getcustomers() throws CustomException{
		
		try {
		return customerRepository.findAll();
		}catch(Exception e) {
			throw new CustomException("Cannot get the List of Customers");
		}
	}

	//upadteCustomer
	@Override
	public Customer updatecustomer(int id,Customer customer)throws CustomException{
		Customer oldcustomer = customerRepository.findById(id)
		.orElseThrow(() -> new CustomException("customer not found with id amit: "+ id));
		oldcustomer.setFirstName(customer.getFirstName());
		oldcustomer.setLastName(customer.getLastName());
		oldcustomer.setStartingLocation(customer.getStartingLocation());
		oldcustomer.setDestinationLocation(customer.getDestinationLocation());
		oldcustomer.setLocationsCovered(customer.getLocationsCovered());
		oldcustomer.setPackageName(customer.getPackageName());
		oldcustomer.setCost(customer.getCost());
		oldcustomer.setPermanentAddress(customer.getPermanentAddress());
		//oldcustomer.setCommunicationAddress(customer.getCommunicationAddress());
		oldcustomer.setPhone(customer.getPhone());
		oldcustomer.setNotes(customer.getNotes());
		return customerRepository.save(oldcustomer);
	}
	
	//deleteCustomer
	@Override
	public String deletecustomerById(int id) throws CustomException{
		try {
	        this.customerRepository.deleteById(id);
	        return ("Customer Deleted with Id: "+id);
	    } catch ( Exception e) {
	        e.getSuppressed();
	    	throw new CustomException("Error: Customer with Id "+id+" is not present");
	    }
		 
	}
	

}
