package com.jedrzej.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car_dealer")
public class CarDealer {
	
	@NotNull
	private int id;
	@Size(min=1, max=25)
	private String name;
	@Size(min=8, max=20)
	private String adress;
	@Size(min=1, max=255)
	private String description;
	
	@OneToMany(targetEntity=Car.class, mappedBy="car_dealer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Car> listCar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

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
