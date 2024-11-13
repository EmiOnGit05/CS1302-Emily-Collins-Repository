package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * Compares two ingredients by type.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */

public class TypeComparator implements Comparator<Ingredient> {

	@Override
	public int compare(Ingredient ingOne, Ingredient ingTwo) {
		return ingOne.getType().compareTo(ingTwo.getType());
	}
	
	@Override
	public String toString() {
		return "Type";
	}

}