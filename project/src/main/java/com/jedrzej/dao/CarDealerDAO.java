package com.jedrzej.dao;

import java.util.List;

import com.jedrzej.model.CarDealer;

public interface CarDealerDAO {
	public void addCarDealer(CarDealer carDealer);
	public void deleteCarDealer(String nameCarDealer); 
	
	public List<CarDealer> listCarDealear();
	public CarDealer findCarDealer(String nameCarDealer);
	public void modifyCarDealer(CarDealer carDealer);

}
