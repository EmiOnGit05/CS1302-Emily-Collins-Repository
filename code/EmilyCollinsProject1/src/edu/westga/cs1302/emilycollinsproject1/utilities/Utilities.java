package edu.westga.cs1302.emilycollinsproject1.utilities;

import edu.westga.cs1302.emilycollinsproject1.model.Food;

public class Utilities {
	public static int findSum(Food[] pantry) throws NullPointerException {
		int sum = 0;
		for (Food currFood : pantry) {
			sum = sum + currFood.getQuantity();
		}
		return sum;
	}
}
