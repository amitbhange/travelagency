package com.TravelAgency.TravelAgency.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PermanentAddress {

	@Id
	@GeneratedValue
	private int addessn;
	private int houseno;
    @NotNull
	private String street;
    @NotNull
    private String landmark;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String pin;
	public PermanentAddress(int houseno, String street, String landmark, String city, String state, String pin) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}


	
	
	
	public PermanentAddress() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getHouseno() {
		return houseno;
	}


	public void setHouseno(int hno) {
		this.houseno = hno;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}





	@Override
	public String toString() {
		return "PermanentAddress [houseno=" + houseno + ", street=" + street + ", landmark=" + landmark + ", city="
				+ city + ", state=" + state + ", pin=" + pin + "]";
	}

	
	
}
