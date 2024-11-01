package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecipeFileWriter {
	public static final String DATA_FILE = "data.txt";
	
	public void saveRecipe(Recipe recipe) throws IOException, IllegalStateException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			if (!this.duplicateRecipe(recipe)) {
				writer.append(recipe.toString());
			} else {
				throw new IllegalStateException("Duplicate recipe already in file!");
			}
		}
	}
	
	private boolean duplicateRecipe(Recipe recipe) throws IOException {
		File input = new File(DATA_FILE);
		try (Scanner reader = new Scanner(input)) {
			String name = recipe.getName();
			while (reader.hasNextLine()) {
				if (reader.nextLine().equals(name)) {
					return true;
				}
				reader.nextLine();
			}
			return false;
		}
	}
	
	private int countLines() throws FileNotFoundException {
		int count = 0;
		File input = new File(DATA_FILE);
		try (Scanner reader = new Scanner(input)) {
			while (reader.hasNextLine()) {
				reader.nextLine();
				count++;
			}
		}
		return count;
	}

}
