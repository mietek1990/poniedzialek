package com.jedrzej.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jedrzej.dao.CarDealerDAO;
import com.jedrzej.model.CarDealer;

@Component
public class CarDealerService {
	
	@Autowired
	private CarDealerDAO carDealerDAO;
	
	public void addCarDealer(CarDealer carDealer) throws IOException {
		carDealerDAO.addCarDealer(carDealer);
	}
	
	public List<CarDealer> listCarDealear(){
		return carDealerDAO.listCarDealear();
	}
	
	public CarDealer findCarDealer(String nameCarDealer) {
		return carDealerDAO.findCarDealer(nameCarDealer);
	}
	
	public void modifyCarDealer(CarDealer carDealer) {
		carDealerDAO.modifyCarDealer(carDealer);
	}
	
	public void deleteCarDealer(String nameCarDealer) {
		carDealerDAO.deleteCarDealer(nameCarDealer);
	}
}
