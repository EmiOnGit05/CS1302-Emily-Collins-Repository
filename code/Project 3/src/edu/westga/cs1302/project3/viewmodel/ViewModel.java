package edu.westga.cs1302.project3.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerFile;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class ViewModel {
	private TaskManager manager;
	private ListProperty<Task> taskList;
	
	public ViewModel() {
		this.manager = new TaskManager();
		Task taskOne = new Task("Clean the dishes", "Unloading the dishwasher and loading it again.");
		Task taskTwo = new Task("Do the laundry", "Switching over to the dryer, starting a new load, and putting away the finished load.");
		this.manager.add(taskOne);
		this.manager.add(taskTwo);
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTaskList()));
	}
	
	public TaskManager getTaskManager() {
		return this.manager;
	}
	
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}
	
//	public void saveData(File file) throws IOException {
//		TaskManagerFile fileManager = new TaskManagerFile();
//		fileManager.onFileSave(manager, file);
//	}
	
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
