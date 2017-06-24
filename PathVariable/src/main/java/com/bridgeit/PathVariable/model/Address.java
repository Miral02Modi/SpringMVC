package com.bridgeit.PathVariable.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	String street;
	String city;
	String state;
	long pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", State=" + state + ", pincode=" + pincode + "]";
	}
	
}
