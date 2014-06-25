package com.jedrzej.junit.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.jedrzej.model.CarDealer;

public class CarDealerTest extends TestCase{
	
	private CarDealer carDealer;
	
	@Before
	public void setUp() {
		carDealer = new CarDealer();
		carDealer.setName("TEST NAME");
		carDealer.setAdress("TEST ADRESS");
		carDealer.setDescription("TEST DESCRIPTION");
	}


	@Test
	public void testCarDealer() {
		assertNotNull(carDealer);
	}
	
	@Test
	public void testGetAdress() {
		assertTrue(carDealer.getAdress().equals("TEST ADRESS"));
	}
	
	@Test
	public void testGetName() {
		assertEquals("TEST NAME", "TEST NAME", carDealer.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertTrue(carDealer.getDescription().equals("TEST DESCRIPTION"));
	}

}
