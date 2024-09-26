package edu.westga.cs1302.emilycollinsproject1.test.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;

class TestDecreaseQuantity {

	@Test
	void testQuantityIsZero() {
		Food foodOne = new Food("Pizza", FoodType.BREAD);
		assertThrows(IllegalArgumentException.class, () -> {foodOne.decreaseQuantity();});
	}
	
	@Test
	void testDecreaseQuantity() {
		Food foodOne = new Food("Pizza", FoodType.BREAD);
		foodOne.setQuantity(3);
		foodOne.decreaseQuantity();
		assertEquals(2, foodOne.getQuantity());
	}

}
