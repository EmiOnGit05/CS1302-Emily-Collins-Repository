package edu.westga.cs1302.project3.model;

/**
 * Class for Task.
 * 
 * @author - Emi Collins
 * @version Fall 2024
 */
public class Task {
	private String title;
	private String description;
	
	/**
	 * Constructor for Task.
	 * 
	 * @param title - Title of task
	 * @param description - Description of the task
	 * @throws IllegalArgumentException - If title or description is null/empty
	 * @precondition title != null && description != null && !title.isEmpty() && !description.isEmpty()
	 */
	public Task(String title, String description) {
		if (title == null || description == null) {
			throw new IllegalArgumentException("Title and/or description cannot be null!");
		}
		if (title.isEmpty() || description.isEmpty()) {
			throw new IllegalArgumentException("Title and/or description cannot be empty!");
		}
	}
	
	/**
	 * Getter for title.
	 * 
	 * @return this.title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Getter for description.
	 * 
	 * @return this.description
	 */
	public String getDescription() {
		return this.description;
	}
}
