

import static org.junit.Assert.*;
import models.Property;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Coordinates;

public class PropertyTest {
	
	Coordinates coord = new Coordinates(1,1);
	Property property = new Property("Boardwalk", 1, 20, 600, coord);
	
	@Test
	public void getTest() {
		assertEquals(1, property.getID());
		assertEquals(20, property.getRentalPrice());
		assertEquals(600, property.getPurchasePrice());
		assertEquals("Boardwalk", property.getName());
	}

}
