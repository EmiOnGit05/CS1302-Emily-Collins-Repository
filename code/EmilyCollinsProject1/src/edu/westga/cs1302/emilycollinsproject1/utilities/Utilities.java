package edu.westga.cs1302.emilycollinsproject1.utilities;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import javafx.collections.ObservableList;

public class Utilities {
	public static int findSum(ObservableList<Food> pantry) throws NullPointerException {
		int sum = 0;
		for (Food currFood : pantry) {
			sum = sum + currFood.getQuantity();
		}
		return sum;
	}
}
