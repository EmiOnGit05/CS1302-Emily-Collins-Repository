package edu.westga.cs1302.emilycollinsproject1.utilities;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import javafx.collections.ObservableList;

/**
 * Class for holding Utilities.
 * 
 * @author Emily Collins
 * @version Fall 2024
 */
public class Utilities {
	/**
	 * Finds sum from all food item quantities in an observable list.
	 * @param pantry the list of food items to add quantities
	 * @return int the sum of all food quantities combined
	 * @throws NullPointerException thrown if pantry is null
	 */
	public static int findSum(ObservableList<Food> pantry) throws NullPointerException {
		int sum = 0;
		for (Food currFood : pantry) {
			sum = sum + currFood.getQuantity();
		}
		return sum;
	}
}
