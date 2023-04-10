package com.TravelAgency.TravelAgency.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
public class Customer {
	//change class name
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Please Enter the FirstName")
	private String firstName;
	@NotEmpty(message = "Please Enter the LastNme")
	private String lastName;
	@NotNull(message = "Please Enter the StartingLocation")
	private String startingLocation;
	@NotNull(message = "Please Enter the DestinationLocation")
	private String destinationLocation;
	@NotNull(message = "Please Enter LocationCovered")
	private String locationsCovered;
	@NotNull(message = "Please Enter the PakageName")
	private String packageName;
	@NotNull(message = "Please Enter the Cost")
	private Number cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private CommunicationAddress communicationAddress;
	
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	private String phone;
	@NotNull(message = "Please Enter the Note")
	private String notes;

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, @NotBlank(message = "Please Enter the FirstName") String firstName,
			@NotEmpty(message = "Please Enter the LastNme") String lastName,
			@NotNull(message = "Please Enter the StartingLocation") String startingLocation,
			@NotNull(message = "Please Enter the DestinationLocation") String destinationLocation,
			@NotNull(message = "Please Enter LocationCovered") String locationsCovered,
			@NotNull(message = "Please Enter the PakageName") String packageName,
			@NotNull(message = "Please Enter the Cost") Number cost, PermanentAddress permanentAddress,
			CommunicationAddress communicationAddress,
			@Size(min = 10, max = 10, message = "Phone number must be 10 digits") String phone,
			@NotNull(message = "Please Enter the Note") String notes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startingLocation = startingLocation;
		this.destinationLocation = destinationLocation;
		this.locationsCovered = locationsCovered;
		this.packageName = packageName;
		this.cost = cost;
		this.permanentAddress = permanentAddress;
		this.communicationAddress = communicationAddress;
		this.phone = phone;
		this.notes = notes;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String getFirstName() {
    	return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public String getLocationsCovered() {
		return locationsCovered;
	}

	public void setLocationsCovered(String locationsCovered) {
		this.locationsCovered = locationsCovered;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Number getCost() {
		return cost;
	}

	public void setCost(Number cost) {
        this.cost=cost;
	}

	public PermanentAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(PermanentAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public CommunicationAddress getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(CommunicationAddress communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getPhone() {
		return phone;
		
	}

	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
