package com.TravelAgency.TravelAgency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.TravelAgency.TravelAgency.controller.customerController;
import com.TravelAgency.TravelAgency.dao.customerRepository;
import com.TravelAgency.TravelAgency.entity.CommunicationAddress;
import com.TravelAgency.TravelAgency.entity.Customer;
import com.TravelAgency.TravelAgency.entity.PermanentAddress;
import com.TravelAgency.TravelAgency.exception.CustomException;
import com.TravelAgency.TravelAgency.service.customerServiceImpl;

import java.util.List;


//@SpringBootTest(classes=TravelAgencyApplication.class)
class TravelAgencyApplicationTests {

    @InjectMocks
    private customerServiceImpl customerServiceimpl;
	
    @Mock
    private customerRepository customerrepository;
   
    @BeforeEach
    void setUp() {
        PermanentAddress permanentAddress = new PermanentAddress(1,"sad","water tank","karnaja","maharashtra","442203");
        CommunicationAddress comadd = new CommunicationAddress(1,"police nagar","water tank");
        Customer customer = new Customer(1,"amit","bhange","karanja","pune","washim","gold",5000,permanentAddress,comadd,"9999999999","please call be before the affival time");
        customerrepository.save(customer);
    }
    
    @Test
    void addUser() throws CustomException{
        PermanentAddress permanentAddress = new PermanentAddress(2,"sam","gandhi park","pune","maharashtra","411057");
        CommunicationAddress comunicationAddress = new CommunicationAddress(2,"golibar chowk","water tank");
        Customer customer = new Customer(2,"omkar","solunke","pune","mumbai","lonavla","silver",500,permanentAddress,comunicationAddress,"8888888888","send me the ticket to my whatsapp number");
        try {
        when(customerrepository.save(customer)).thenReturn(customer);
        assertEquals(customer, customerServiceimpl.createcustomer(customer));
        }catch(Exception e)
        {
        	e.printStackTrace();
        	throw new CustomException("Error: Equal data not found!");
        }
        }
    
  //Test Case for Get Single item
    @Test
    void getUser() throws CustomException 
    {
    	 // create a mock customer object
    	try {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPackageName("gold");
        when(customerrepository.findById(1)).thenReturn(Optional.of(customer));
        Customer actual = customerServiceimpl.getcustomerById(1);
       assertEquals(customer, actual);
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new CustomException("could not get the customer!");
    	}
    	}
    

  //Test Case for Put Items
    @Test
    void updateCustomer() throws CustomException 
    {
    	try {
    	
    	PermanentAddress permanentAddress = new PermanentAddress(1,"sam","gandhi park","pune","maharashtra","411057");
        CommunicationAddress communicationAddress = new CommunicationAddress(1,"golibar chowk","water tank");
      
        Customer cust = new Customer(1,"omkar","solunke","pune","mumbai","lonavla","silver",500,permanentAddress,communicationAddress,"1111111111","send me the ticket to my whatsapp number");
        customerServiceimpl.createcustomer(cust);
    	
    	Customer updatedcust = new Customer(1,"amit","Bhange","pune","mumbai","lonavla","silver",500,permanentAddress,communicationAddress,"1111111111","send me the ticket to my whatsapp number");
    //	customerServiceimpl.updatecustomer(1,updatedcust);
    	
    	//int id = updatedcust.getId();

    	assertEquals(1, updatedcust.getId());
    	assertEquals("amit", updatedcust.getFirstName());
    	assertEquals("Bhange", updatedcust.getLastName());
    	assertEquals("pune", updatedcust.getStartingLocation());
    	assertEquals("mumbai", updatedcust.getDestinationLocation());
    	assertEquals("lonavla", updatedcust.getLocationsCovered());
    	assertEquals("silver", updatedcust.getPackageName());
    	assertEquals(500, updatedcust.getCost());
    	assertEquals(permanentAddress, updatedcust.getPermanentAddress());
    	assertEquals(communicationAddress, updatedcust.getCommunicationAddress());
    	assertEquals("1111111111", updatedcust.getPhone());
    	assertEquals("send me the ticket to my whatsapp number", updatedcust.getNotes());
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new CustomException("hello");
    	}
    	}
    
  //Test Case for Delete Items
    @Test
    public void testDeletecustomerById() throws CustomException {
       try {
    	int id=2;
    	PermanentAddress permanentAddress = new PermanentAddress(1,"sam","gandhi park","pune","maharashtra","411057");
        CommunicationAddress communicationAddress = new CommunicationAddress(1,"golibar chowk","water tank");
        Customer cust = new Customer(id,"omkar","solunke","pune","mumbai","lonavla","silver",500,permanentAddress,communicationAddress,"1111111111","send me the ticket to my whatsapp number");
    	customerrepository.save(cust);
    	String actualMessage = customerServiceimpl.deletecustomerById(id);
    	assertEquals("Customer Deleted with Id: "+id, actualMessage);
       }catch(Exception e) {
    	   e.printStackTrace();
    	   throw new CustomException("could not delete the customer!");
       }
    	
    }
}
