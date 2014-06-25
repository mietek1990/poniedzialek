package com.jedrzej.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	private int id;
	private String model;
	private String description;
	private String  mark;
	private String mileage;
	private int years;
	@ManyToOne
	@JoinColumn(name = "cardealer_id")
	private CarDealer carDealer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	public CarDealer getCarDealer() {
		return carDealer;
	}
	public void setCarDealer(CarDealer carDealer) {
		this.carDealer = carDealer;
	}
	

}
