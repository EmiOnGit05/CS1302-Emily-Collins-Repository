package edu.westga.cs1302.emilycollinsproject1.test.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;

class TestFoodConstructor {

	@Test
	void testNameIsNull() {
		assertThrows(NullPointerException.class, () -> {
			new Food(null, FoodType.BREAD);
		});
	}
	
	@Test
	void testTypeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Food("Basil", null);
		});
	}
	
	@Test
	void testNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Food("", null);
		});
	}
	
	@Test
	void testCorrectConstructor() {
		Food foodOne = new Food("Basil", FoodType.INGREDIENT);
		assertEquals(FoodType.INGREDIENT, foodOne.getType());
		assertEquals("Basil", foodOne.getName());
	}

}
