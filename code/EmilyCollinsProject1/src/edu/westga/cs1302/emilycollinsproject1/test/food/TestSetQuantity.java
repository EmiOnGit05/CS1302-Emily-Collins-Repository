package edu.westga.cs1302.emilycollinsproject1.test.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;

class TestSetQuantity {

	@Test
	void testQuantityLessThanZero() {
		Food foodOne = new Food("Basil", FoodType.INGREDIENT);
		assertThrows(IllegalArgumentException.class, () -> {foodOne.setQuantity(-1);});
	}
	
	@Test
	void testQuantityIsZero() {
		Food foodOne = new Food("Basil", FoodType.INGREDIENT);
		foodOne.setQuantity(0);
		assertEquals(0, foodOne.getQuantity());
	}
	
	@Test
	void testQuantityAboveZero() {
		Food foodOne = new Food("Basil", FoodType.INGREDIENT);
		foodOne.setQuantity(57);
		assertEquals(57, foodOne.getQuantity());
	}

}
