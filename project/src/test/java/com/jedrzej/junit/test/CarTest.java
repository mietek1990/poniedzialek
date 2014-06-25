package com.jedrzej.junit.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.jedrzej.model.Car;

public class CarTest extends TestCase{
	
	private Car car;

	@Before
	public void setUp() {
		car = new Car();
		car.setMark("TEST MARK");
		car.setModel("TEST MODEL");
		car.setDescription("TEST DESCRIPTION");
		car.setMileage("TEST MILEAGE");
		car.setYears(2000);
	}

	@Test
	public void testCar() {
		assertNotNull(car);
	}
	
	@Test
	public void testGetMark() {
		assertTrue(car.getMark().equals("TEST MARK"));
	}
	
	@Test
	public void testGetModel() {
		assertEquals("TEST MODEL", "TEST MODEL", car.getModel());
	}
	
	@Test
	public void testGetDescription() {
		assertTrue(car.getDescription().equals("TEST DESCRIPTION"));
	}
	
	@Test
	public void testGetMileage() {
		assertTrue(car.getMileage().equals("TEST MILEAGE"));
	}
	
	@Test
	public void testGetYears() {
		assertEquals("TEST YEARS", 2000, car.getYears());
	}

}
