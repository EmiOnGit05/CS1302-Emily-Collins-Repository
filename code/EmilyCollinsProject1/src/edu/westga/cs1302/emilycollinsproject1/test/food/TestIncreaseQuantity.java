package edu.westga.cs1302.emilycollinsproject1.test.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;

class TestIncreaseQuantity {

	@Test
	void testAddQuantity() {
		Food foodOne = new Food("Ice Cream", FoodType.DESSERT);
		foodOne.increaseQuantity();
		assertEquals(1, foodOne.getQuantity());
	}

}
