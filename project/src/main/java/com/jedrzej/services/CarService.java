package com.jedrzej.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jedrzej.dao.CarDAO;
import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;

@Component
public class CarService {
	
	@Autowired
	private CarDAO carDAO;
	
	public void addCar(Car car) throws IOException {
		carDAO.addCar(car);
	}
	
	public List<Car> listCar(String nameCarDealer) {
		return carDAO.listCar(nameCarDealer);
	}
	
	public CarDealer findCarDealer(String nameCarDealer) {
		return carDAO.findCarDealer(nameCarDealer);
	}
	
	public Car findCar(int idCar) {
		return carDAO.findCar(idCar);
	}
	
	public void updateCar(Car car) {
		carDAO.updateCar(car);
	}
	
	public void deleteCar(String nameCar) {
		carDAO.deleteCar(nameCar);
	}
}
