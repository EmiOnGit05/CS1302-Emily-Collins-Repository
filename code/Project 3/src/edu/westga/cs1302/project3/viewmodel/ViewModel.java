package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerFile;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * ViewModel for the project.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class ViewModel {
	private TaskManager manager;
	private ListProperty<Task> taskList;
	private StringProperty taskTitle;
	private StringProperty taskDescription;
	private ObjectProperty<Task> selectedTask;
	
	/**
	 * Constructor for ViewModel.
	 * 
	 * @preconditions none
	 * @postcondition this.manager = new TaskManager() &&
	 * 	this.taskList = this.manager.getTaskList() &&
	 * 	this.taskTitle = new SimpleStringProperty() &&
	 * 	this.taskDescription = new SimpleStringProperty() &&
	 * 	this.selectedTask = new SimpleObjectProperty/Task/()
	 */
	public ViewModel() {
		this.manager = new TaskManager();
		Task taskOne = new Task("Clean the dishes", "Unloading the dishwasher and loading it again.");
		Task taskTwo = new Task("Do the laundry", "Switching over to the dryer, starting a new load, and putting away the finished load.");
		this.manager.add(taskOne);
		this.manager.add(taskTwo);
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTaskList()));
		this.taskTitle = new SimpleStringProperty();
		this.taskDescription = new SimpleStringProperty();
		this.selectedTask = new SimpleObjectProperty<Task>();
	}
	
	/**
	 * Adds a task to the list of tasks held by the manager.
	 * 
	 * @preconditions this.taskTitle.getValue() != null &&
	 * 	this.taskDescription.getValue() != null
	 * @postconditions this.manager.contains(task)
	 * @throws NullPointerException - If title or description is null
	 */
	public void addTask() {
		if (this.taskTitle.getValue() == null || this.taskDescription.getValue() == null) {
			throw new NullPointerException("Title and/or description cannot be null! Please enter text and try again.");
		}
		Task task = new Task(this.taskTitle.getValue(), this.taskDescription.getValue());
		this.manager.add(task);
		this.refresh();
	}
	
	/**
	 * Removes the selected task from the set.
	 * 
	 * @preconditions this.selectedTask.getValue() != null
	 * @postconditions !this.manager.contains(this.selectedTask.getValue())
	 */
	public void removeTask() {
		if (this.selectedTask.getValue() == null) {
			throw new NullPointerException("Please select a task to delete!");
		} else {
			this.manager.remove(this.selectedTask.getValue());
			this.refresh();
		}
		
	}
	
	/**
	 * Getter for currently selected task.
	 * @return this.selectedTask
	 */
	public ObjectProperty<Task> getSelectedTask() {
		return this.selectedTask;
	}
	
	/**
	 * Getter for task's title's text.
	 * @return this.taskTitle
	 */
	public StringProperty getTaskTitle() {
		return this.taskTitle;
	}
	
	/**
	 * Getter for task's description's text.
	 * @return this.taskDescription
	 */
	public StringProperty getTaskDescription() {
		return this.taskDescription;
	}
	
	/**
	 * Getter for task manager.
	 * @return this.manager
	 */
	public TaskManager getTaskManager() {
		return this.manager;
	}
	
	/**
	 * Getter for list of tasks.
	 * @return this.taskList
	 */
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}
	
	/**
	 * Saves data to a file through TaskManagerFile
	 * @precondition file != null
	 * @param file - The file being passed to save to
	 * @throws IOException - Throws if file is not found or invalid
	 * @throws NullPointerException - Throws if file is null
	 */
	public void saveData(File file) throws IOException {
		if (file == null) {
			throw new NullPointerException("File cannot be null!");
		}
		TaskManagerFile fileManager = new TaskManagerFile();
		fileManager.onFileSave(this.manager, file);
	}
	
	/**
	 * Loads data from a file to a new TaskManagerFile
	 * @param file - The file being passed to load from
	 * @throws FileNotFoundException - Throws if file is not found
	 * @throws IOException - Throws if another file error occurs
	 * @throws NullPointerException - Throws if file is null
	 */
	public void loadData(File file) throws FileNotFoundException, IOException {
		if (file == null) {
			throw new NullPointerException("File cannot be null!");
		}
		TaskManagerFile fileManager = new TaskManagerFile();
		this.taskList.addAll(fileManager.onFileLoad(file).getTaskList());
		this.refresh();
	}
	
	/**
	 * Refreshes to make sure that manager's list and the list property are synced up.
	 */
	public void refresh() {
		this.taskList.clear();
		this.taskList.addAll(this.manager.getTaskList());
	}
}
