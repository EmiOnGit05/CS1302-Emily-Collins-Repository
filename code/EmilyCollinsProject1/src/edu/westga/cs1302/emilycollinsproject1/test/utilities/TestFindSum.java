package edu.westga.cs1302.emilycollinsproject1.test.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;
import edu.westga.cs1302.emilycollinsproject1.utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class TestFindSum {

	@Test
	void testNullList() {
		assertThrows(NullPointerException.class, () -> {
			Utilities.findSum(null);
		});
	}
	
	@Test
	void testEmptyPantry() {
		ObservableList<Food> pantry = FXCollections.observableArrayList();
		assertEquals(0, Utilities.findSum(pantry));
	}
	
	@Test
	void testOneFood() {
		Food foodOne = new Food("Apple", FoodType.FRUIT);
		foodOne.setQuantity(4);
		ObservableList<Food> pantry = FXCollections.observableArrayList();
		pantry.add(foodOne);
		assertEquals(4, Utilities.findSum(pantry));
	}
	
	@Test
	void testMultipleFoods() {
		Food foodOne = new Food("Apple", FoodType.FRUIT);
		Food foodTwo = new Food("Pizza", FoodType.BREAD);
		Food foodThree = new Food("Beef", FoodType.MEAT);
		foodOne.setQuantity(4);
		foodTwo.setQuantity(6);
		foodThree.setQuantity(5);
		ObservableList<Food> pantry = FXCollections.observableArrayList();
		pantry.add(foodOne);
		pantry.add(foodTwo);
		pantry.add(foodThree);
		assertEquals(15, Utilities.findSum(pantry));
	}

}
