package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/**
 * Class for holding a recipe.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class Recipe {
	private ArrayList<Ingredient> ingredients;
	private String recipeName;
	
	/**
	 * Constructor for recipe.
	 * 
	 * @param ingredients - list of ingredients in the recipe
	 * @param recipeName - name of the recipe
	 * @throws IllegalArgumentException - if ingredients or recipeName is null
	 */
	public Recipe(ArrayList<Ingredient> ingredients, String recipeName) {
		if (ingredients == null) {
			throw new IllegalArgumentException("List of ingredients cannot be missing!");
		}
		if (recipeName == null) {
			throw new IllegalArgumentException("Name of recipe cannot be null!");
		}
		this.ingredients = ingredients;
		this.recipeName = recipeName;
	}
	
	/**
	 * Returns the list of ingredients.
	 * 
	 * @return this.ingredients - ingredients in the recipe
	 */
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	
	/**
	 * Returns the name of the recipe.
	 * 
	 * @return this.recipeName - name of the recipe
	 */
	public String getName() {
		return this.recipeName;
	}

}
