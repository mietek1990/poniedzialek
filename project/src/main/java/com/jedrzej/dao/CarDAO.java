package com.jedrzej.dao;

import java.util.List;

import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;

public interface CarDAO {
	
	public void addCar(Car car);
	public void deleteCar(String nameCar);
	public List<Car> listCar(String nameCarDealer);
	public CarDealer findCarDealer(String nameCarDealer);
	public Car findCar(int idCar);
	public void updateCar(Car car);

}
