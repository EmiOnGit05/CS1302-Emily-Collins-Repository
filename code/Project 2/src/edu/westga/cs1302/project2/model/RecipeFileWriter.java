package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Writes a recipe to the end of a file.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class RecipeFileWriter {
	public static final String DATA_FILE = "data.txt";
	
	/**
	 * Writes a recipe to the end of a file if it does not already exist.
	 * @param recipe - recipe to write
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public void saveRecipe(String recipe) throws IOException, IllegalStateException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			if (!this.duplicateRecipe(recipe)) {
				writer.append(recipe.toString());
			} else {
				throw new IllegalStateException("Duplicate recipe already in file!");
			}
		}
	}
	
	private boolean duplicateRecipe(String recipe) throws IOException {
		File input = new File(DATA_FILE);
		try (Scanner reader = new Scanner(input)) {
			String name = recipe.split(System.lineSeparator())[0];
			while (reader.hasNextLine()) {
				if (reader.nextLine().equals(name)) {
					return true;
				}
				reader.nextLine();
			}
			return false;
		}
	}

}
