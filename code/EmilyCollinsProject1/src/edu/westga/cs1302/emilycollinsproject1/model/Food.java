package edu.westga.cs1302.emilycollinsproject1.model;

/**
 * Data class for a food object.
 * 
 * @author Emily Collins
 * @version Fall 2024
 */

public class Food {
	private String name;
	private FoodType type;

	/**
	 * Constructor for food object.
	 * 
	 * @param name the name of the food
	 * @param type the type of food it is
	 */
	public Food(String name, FoodType type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Getter for food name.
	 * 
	 * @return this.name - name of the food object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter for food type.
	 * 
	 * @return this.type - the type of the food object
	 */
	public FoodType getType() {
		return this.type;
	}
}
