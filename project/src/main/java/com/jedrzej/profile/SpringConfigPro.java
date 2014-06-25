package com.jedrzej.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jedrzej.model.CarDealer;

@Configuration
@Profile("production")
public class SpringConfigPro {

	
	@Bean
	  public CarDealer carDealer(){
	 
		CarDealer carDealer =  new CarDealer();
	    carDealer.setName("pro-carDealer");
	    carDealer.setAdress("pro-87-851 Boniewo");
	    carDealer.setDescription("pro-dsgakghLKGFghfw");
	    return carDealer;
	  }
}
