package br.com.marcio.model.pojo;

import java.io.Serializable;

public class Adress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String street;
	private int number;
	private String neighborhood;
	private String City;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
}
