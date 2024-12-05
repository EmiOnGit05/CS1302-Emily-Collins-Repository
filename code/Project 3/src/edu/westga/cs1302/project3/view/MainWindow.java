package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
    private Button addTaskButton;

    @FXML
    private Button removeTaskButton;

    @FXML
    private ListView<Task> taskListView;
    
    private ViewModel vm;
    
    @FXML
    public void initialize() {
    	this.vm = new ViewModel();
    	// this.bindToViewModel();
    	this.taskListView.setItems(this.vm.getTaskList());
    }

//	private void bindToViewModel() {
//		this.taskListView.itemsProperty().bind(this.vm.getTaskList());
//	}
}
