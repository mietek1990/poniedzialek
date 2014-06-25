package com.jedrzej.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jedrzej.model.CarDealer;

@Configuration
@Profile("development")
public class SpringConfigDev {
	
	@Bean
	  public CarDealer carDealer(){
	 
		CarDealer carDealer =  new CarDealer();
	    carDealer.setName("dev-carDealer");
	    carDealer.setAdress("dev-87-851 Boniewo");
	    carDealer.setDescription("dev-dsgakghLKGFghfw");
	    return carDealer;
	  }
}
