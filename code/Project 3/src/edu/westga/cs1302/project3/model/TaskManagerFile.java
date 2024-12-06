package edu.westga.cs1302.project3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class for TaskManagerFile.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class TaskManagerFile {
	
	/**
	 * Saves tasks to a file.
	 * 
	 * @param manager - the manager holding the tasks
	 * @param file - the file the tasks are being saved to
	 * @throws IOException - thrown if there is a file error
	 * @throws NullPointerException - thrown if manager is null
	 */
	public void onFileSave(TaskManager manager, File file) throws IOException {
		if (manager == null) {
			throw new NullPointerException("Task Manager cannot be null! Please try again.");
		} else {
			try (FileWriter writer = new FileWriter(file)) {
				for (Task currTask : manager.getTaskList()) {
					if (currTask != null) {
						writer.write(currTask.getTitle() + "," + currTask.getDescription() + System.lineSeparator());
					}
				}
			}
		}
	}

	/**
	 * Loads tasks from a file.
	 * 
	 * @param file - file loading tasks from
	 * @return TaskManager - new task manager with tasks from file
	 * @throws FileNotFoundException - thrown if file is not found
	 * @throws IOException - thrown if other error with file occurs
	 */
	public TaskManager onFileLoad(File file) throws FileNotFoundException, IOException {
		try (Scanner reader = new Scanner(file)) {
			TaskManager manager = new TaskManager();
			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String baseLine = reader.nextLine();
				String strippedLine = baseLine.strip();
				String[] parts = strippedLine.split(",");
				try {
					String title = parts[0];
					String description = parts[1];
					Task task = new Task(title, description);
					manager.add(task);
				} catch (NullPointerException nullError) {
					throw new IOException("Unable to create task, either title or description empty! Error on line "
							+ lineNumber + " : " + strippedLine);
				} catch (IndexOutOfBoundsException exception) {
					throw new IOException("Index out of bounds! Please try a different file!");
				}
			}
			return manager;
		}
	}
}
