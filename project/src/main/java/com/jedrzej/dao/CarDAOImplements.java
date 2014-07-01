package com.jedrzej.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jedrzej.config.Logger;
import com.jedrzej.model.Car;
import com.jedrzej.model.CarDealer;


@Repository("CarDAOImplements")
public class CarDAOImplements implements CarDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	public CarDAOImplements(){
		Logger.log("CarDAOImplements utworzona");
	}

	public void addCar(Car car) {
		template.update("INSERT INTO car (mark,model,mileage,years,description,cardealer_id) VALUES (?,?,?,?,?,?)",car.getMark(), car.getModel(), car.getMileage(), car.getYears(), car.getDescription(), car.getCarDealer().getId());
	}

	public void deleteCar(String nameCar) {
		String [] tmp = nameCar.split(" ");		
		template.update("delete from car where id = ?", new Object[] {Integer.parseInt(tmp[2])});

	}

	@SuppressWarnings("rawtypes")
	public List<Car> listCar(String nameCarDealer) {
		List <Car> listCarName = new ArrayList<Car>();

		CarDealer carDealer = findCarDealer(nameCarDealer);

        String sql1 = "select * from car where cardealer_id = ?";
        List<Map<String, Object>> tmp = template.queryForList(sql1, new Object[] { carDealer.getId() });
        
        for (Map row : tmp) {
			Car car = new Car();
			car.setId(Integer.parseInt(String.valueOf(row.get("id"))));
			car.setMark(String.valueOf(row.get("mark")));
			car.setModel(String.valueOf(row.get("model")));
			car.setMileage(String.valueOf(row.get("mileage")));
			car.setYears(Integer.parseInt(String.valueOf(row.get("years"))));
			car.setDescription(String.valueOf(row.get("description")));
			car.setCarDealer(carDealer);
			
			listCarName.add(car);
		}
		
		return listCarName;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CarDealer findCarDealer(String nameCarDealer) {
		
		String sql = "select * from car_dealer where name=?";  
        CarDealer carDealer = (CarDealer) template.queryForObject(sql, new Object[] { nameCarDealer }, new BeanPropertyRowMapper(CarDealer.class));
        return carDealer;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Car findCar(int idCar) {
		String sql = "select * from car where id=?";  
        Car car = (Car) template.queryForObject(sql, new Object[] { idCar }, new BeanPropertyRowMapper(Car.class));
        return car;
	}

	public void updateCar(Car car) {
		template.update("update car set mark = ?, model = ?, years = ?, mileage = ?, description=?, cardealer_id=? where id = ?", new Object[] {car.getMark(), car.getModel(), car.getYears(), car.getMileage(), car.getDescription(), car.getCarDealer().getId(), car.getId()});
	}

}
