package com.jedrzej.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car_dealer")
public class CarDealer {
	
	private int id;
	private String name;
	private String adress;
	private String description;
	
	@OneToMany(targetEntity=Car.class, mappedBy="car_dealer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Car> listCar;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List <Car> getListCar() {
		return listCar;
	}
	public void setListCar(List <Car> listCar) {
		this.listCar = listCar;
	}

}
