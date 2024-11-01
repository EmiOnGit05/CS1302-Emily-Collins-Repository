package edu.westga.cs1302.project2.utilities;

import edu.westga.cs1302.project2.model.Recipe;

/**
 * Class that converts recipes to string format.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class RecipeStringConverter {
	
	/**
	 * Converts a given recipe to string.
	 * @param recipe - the recipe being converted
	 * @return result - converted string of result
	 * @throws IllegalArgumentException - if recipe is null
	 */
	public static String recipeConverter(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("Must include a valid recipe!");
		}
		String result = recipe.getName() + System.lineSeparator();
		for (int index = 0; index < recipe.getIngredients().size(); index++) {
			result += recipe.getIngredients().get(index) + ",";
		}
		return result;
	}
}
