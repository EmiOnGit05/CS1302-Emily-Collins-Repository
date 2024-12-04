package edu.westga.cs1302.project3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Window;


public class TaskManagerFile {
	
	public void onFileSave(TaskManager manager, File file) throws IOException {
		if (manager == null) {
			throw new NullPointerException("Task Manager cannot be null! Please try again.");
		} else {
			try (FileWriter writer = new FileWriter(file)) {
				for (Task currTask : manager.getTaskList().values()) {
					if (currTask != null) {
						writer.write(currTask.getTitle() + "," + currTask.getDescription() + System.lineSeparator());
					}
				}
			}
		}
	}

	public void onFileLoad(File file) throws FileNotFoundException, IOException {
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
				}
			}
		}
	}
}
