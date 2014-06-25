package com.jedrzej.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jedrzej.model.CarDealer;

@Repository("CarDealerDAOImplements")
public class CarDealerDAOImplements implements CarDealerDAO {

	@Autowired
	private JdbcTemplate template;
	
	public CarDealerDAOImplements(){
		System.out.println("CarDealerDAOImplements utworzona");
	}

	public void addCarDealer(CarDealer carDealer) {
		template.update("INSERT INTO car_dealer (name,adress,description) VALUES (?,?,?)", carDealer.getName(), carDealer.getAdress(), carDealer.getDescription());
	}

	@Override
	public void deleteCarDealer(String nameCarDealer) {
		
		CarDealer carDealer = findCarDealer(nameCarDealer);
		
		template.update("delete from car where cardealer_id = ?", new Object[] {carDealer.getId()});
		template.update("delete from car_dealer where id = ?", new Object[] {carDealer.getId()});
	}

	@SuppressWarnings("rawtypes")
	public List<CarDealer> listCarDealear() {
		
		List <CarDealer> listCarDealers = new ArrayList<CarDealer>();
		
		List<Map<String, Object>> tmp = template.queryForList("select * from car_dealer");

		for (Map row : tmp) {
			CarDealer carDealer = new CarDealer();
			carDealer.setId(Integer.parseInt(String.valueOf(row.get("id"))));
			carDealer.setName((String)row.get("name"));
			carDealer.setAdress((String)row.get("address"));
			carDealer.setDescription((String)row.get("description"));
			listCarDealers.add(carDealer);
		}

		return listCarDealers;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CarDealer findCarDealer(String nameCarDealer) {
		String sql = "select * from car_dealer where name=?";  
        CarDealer carDealer = (CarDealer) template.queryForObject(sql, new Object[] { nameCarDealer }, new BeanPropertyRowMapper(CarDealer.class));
        return carDealer;
	}

	public void modifyCarDealer(CarDealer carDealer) {
		template.update("update car_dealer set name = ?, description=?, adress=? where id = ?", new Object[] {carDealer.getName(), carDealer.getDescription(), carDealer.getAdress(), carDealer.getId()});
	}



}
