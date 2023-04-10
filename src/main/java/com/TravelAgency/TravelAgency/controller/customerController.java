package com.TravelAgency.TravelAgency.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.TravelAgency.TravelAgency.entity.Customer;
import com.TravelAgency.TravelAgency.exception.CustomException;
import com.TravelAgency.TravelAgency.service.customerService;
import com.TravelAgency.TravelAgency.service.customerServiceImpl;

@RestController
public class customerController {
	@Autowired
	private  customerService customerService;
	//sample endpoint
	@GetMapping("/home")
	public String home() {
		return "calling home";
	}
  
	//to save the new customer
	@PostMapping("/travelagency/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer addcustomer(@Valid @RequestBody Customer customer)throws CustomException {
		return customerService.createcustomer(customer);
	}

	//to save the multiple new customer
	@PostMapping("/travelagency/saveMultiple")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Customer> addcustomers(@RequestBody List<Customer> customers) throws CustomException{
	
		return customerService.createcustomers(customers);
	}

	//to get the customer using id
	@GetMapping("/travelagency/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer getcustomerById(@PathVariable int id) throws CustomException{
		return customerService.getcustomerById(id);
	}

	//to get the all customers
	@GetMapping("/travelagency")
	@ResponseStatus(code = HttpStatus.OK)
	public  List<Customer> getAllcustomers() throws CustomException {
		return customerService.getcustomers();
	}
	
	//to update the customer using id.
	@PutMapping("/travelagency/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer updatecustomer(@PathVariable int id,@RequestBody Customer customer) throws CustomException {
		return customerService.updatecustomer(id,customer);
	}

	//delete the customer using id
	
	//public ResponseEntity<HttpStatus> deletecustomer(@PathVariable int id) throws CustomException{
//		try {
//			ResponseEntity<HttpStatus> response=null;
//			this.customerService.deletecustomerById(id);
//			response= new ResponseEntity<>(HttpStatus.ACCEPTED);
//			HttpStatus i=response.getStatusCode();
//			System.out.println("Status code"+i);
//			return response;
//		}catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	@DeleteMapping("/travelagency/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
		public String deletecustomer(@PathVariable int id) throws CustomException{
	       return customerService.deletecustomerById(id);
    	}
}
	

