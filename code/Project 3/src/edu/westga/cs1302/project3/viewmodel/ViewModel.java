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

public class ViewModel {
	private TaskManager manager;
	private ListProperty<Task> taskList;
	private StringProperty taskTitle;
	private StringProperty taskDescription;
	private ObjectProperty selectedTask;
	
	public ViewModel() {
		this.manager = new TaskManager();
		Task taskOne = new Task("Clean the dishes", "Unloading the dishwasher and loading it again.");
		Task taskTwo = new Task("Do the laundry", "Switching over to the dryer, starting a new load, and putting away the finished load.");
		this.manager.add(taskOne);
		this.manager.add(taskTwo);
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTaskList()));
		this.taskTitle = new SimpleStringProperty();
		this.taskDescription = new SimpleStringProperty();
		this.selectedTask = new SimpleObjectProperty();
	}
	
	public void addTask() {
		if (this.taskTitle.getValue() == null || this.taskDescription.getValue() == null) {
			throw new NullPointerException("Title and/or description cannot be null! Please enter text and try again.");
		}
		Task task = new Task(this.taskTitle.getValue(), this.taskDescription.getValue());
		this.taskList.add(task);
		this.refresh();
	}
	
	public void removeTask() {
		if (this.selectedTask.getValue() == null) {
			throw new NullPointerException("Please select a task to delete!");
		} else {
			this.taskList.remove(this.selectedTask.getValue());
			this.refresh();
		}
		
	}
	
	public ObjectProperty getSelectedTask() {
		return this.selectedTask;
	}
	
	public StringProperty getTaskTitle() {
		return this.taskTitle;
	}
	
	public StringProperty getTaskDescription() {
		return this.taskDescription;
	}
	
	public TaskManager getTaskManager() {
		return this.manager;
	}
	
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}
	
	public void saveData(File file) throws IOException {
		TaskManagerFile fileManager = new TaskManagerFile();
		fileManager.onFileSave(manager, file);
	}
	
	public void loadData(File file) throws FileNotFoundException, IOException {
		TaskManagerFile fileManager = new TaskManagerFile();
		this.taskList.addAll(fileManager.onFileLoad(file).getTaskList());
		this.refresh();
	}
	
	public void refresh() {
		this.manager.getTaskList().clear();
		this.manager.addAll(this.taskList);
	}
}
