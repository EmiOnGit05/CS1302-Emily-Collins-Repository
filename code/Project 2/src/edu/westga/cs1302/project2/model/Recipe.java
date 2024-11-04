package edu.westga.cs1302.project2.model;

import java.util.List;

/**
 * Class for holding a recipe.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class Recipe {
	private List<Ingredient> ingredients;
	private String recipeName;
	
	/**
	 * Constructor for recipe.
	 * 
	 * @param ingredients - list of ingredients in the recipe
	 * @param recipeName - name of the recipe
	 * @throws IllegalArgumentException - if ingredients or recipeName is null
	 */
	public Recipe(List<Ingredient> ingredients, String recipeName) {
		if (ingredients == null || ingredients.isEmpty()) {
			throw new IllegalArgumentException("List of ingredients cannot be missing! Please add ingredients to the recipe.");
		}
		if (recipeName == null || recipeName.isEmpty() || recipeName.isBlank()) {
			throw new IllegalArgumentException("Name of recipe cannot be missing! Please enter a name for the recipe.");
		}
		this.ingredients = ingredients;
		this.recipeName = recipeName;
	}
	
	/**
	 * Returns the list of ingredients.
	 * 
	 * @return this.ingredients - ingredients in the recipe
	 */
	public List<Ingredient> getIngredients() {
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
