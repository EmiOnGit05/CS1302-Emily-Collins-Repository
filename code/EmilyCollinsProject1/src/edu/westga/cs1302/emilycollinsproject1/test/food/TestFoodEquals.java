package edu.westga.cs1302.emilycollinsproject1.test.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;

class TestFoodEquals {

	@Test
	void testFoodNull() {
		Food foodOne = new Food("Apple", FoodType.FRUIT);
		assertThrows(NullPointerException.class, () -> {foodOne.equals(null);});
	}
	
	@Test
	void testFoodNotEqual() {
		Food foodOne = new Food("Apple", FoodType.FRUIT);
		Food foodTwo = new Food("Apple", FoodType.DESSERT);
		assertEquals(false, foodOne.equals(foodTwo));
	}
	
	@Test
	void testFoodEquals() {
		Food foodOne = new Food("Apple", FoodType.FRUIT);
		Food foodTwo = new Food("Apple", FoodType.FRUIT);
		assertTrue(foodOne.equals(foodTwo));
	}

}
