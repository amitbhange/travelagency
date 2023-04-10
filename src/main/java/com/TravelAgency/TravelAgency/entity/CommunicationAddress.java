package com.TravelAgency.TravelAgency.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CommunicationAddress {
	
	@Id
	@GeneratedValue
	private int addessn;
	private int houseno;
	@NotNull
	private String street;
	@NotNull
	private String landmark;

	
	public CommunicationAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CommunicationAddress(int houseno, String street, String landmark) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.landmark = landmark;
	}


	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
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


	@Override
	public String toString() {
		return "CommunicationAddress [houseno=" + houseno + ", street=" + street + ", landmark=" + landmark + "]";
	}
	
	
	
}
