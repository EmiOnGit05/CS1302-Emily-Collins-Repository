package edu.westga.cs1302.emilycollinsproject1.model;

/**
 * Data class for a food object.
 * 
 * @author Emily Collins
 * @version Fall 2024
 */

public class Food {
	private final String name;
	private final FoodType type;
	private int quantity;

	/**
	 * Constructor for food object.
	 * 
	 * @precondition name != null && type != null
	 * @postcondition this.name = name && this.type = type && this.quantity = 0
	 * @param name the name of the food
	 * @param type the type of food it is
	 * @throws IllegalArgumentException if name or type is null
	 */
	public Food(String name, FoodType type) {
		if (name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
		if (type == null) {
			throw new IllegalArgumentException("Type cannot be empty!");
		}
		this.name = name;
		this.type = type;
		this.quantity = 0;
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
	
	/**
	 * Getter for quantity.
	 * 
	 * @return this.quantity - the quantity of this food in the pantry
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Setter for quantity.
	 * 
	 * @precondition quantity > 0
	 * @postcondition this.quantity = quantity
	 * @param quantity the quantity to set the food to
	 * @throws IllegalArgumentException if quantity < 0
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity must be above 0!");
		}
		this.quantity = quantity;
	}
	
	/**
	 * Adds one value to food's quantity.
	 * 
	 * @precondition none
	 * @postcondition this.quantity += 1
	 */
	
	public void increaseQuantity() {
		this.quantity += 1;
	}
	
	/**
	 * Decreases one value from food's quantity.
	 * 
	 * @precondition this.quantity > 0
	 * @postcondition this.quantity -= 1
	 * @throws IllegalArgumentException if quantity <= 0
	 */
	public void decreaseQuantity() {
		if (this.quantity > 0) {
			this.quantity -= 1;
		} else {
			throw new IllegalArgumentException("Quantity cannot go below 0!");
		}
	}
	
	/**
	 * Checks if a food object is equal by comparing name and type.
	 * 
	 * @precondition none (null checked in constructor)
	 * @postcondition none
	 * @param food - the food object being compared
	 * @return true if object is equal, false if not
	 */
	public boolean equals(Food food) {
		if (this.name.equals(food.getName()) && (this.type.equals(food.getType()))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.name + " - " + Integer.toString(this.quantity);
	}
}
