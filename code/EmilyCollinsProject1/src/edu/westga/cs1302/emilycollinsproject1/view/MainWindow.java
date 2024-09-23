package edu.westga.cs1302.emilycollinsproject1.view;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private Label pantryLabel;
	
	@FXML
	private Label foodNameLabel;

	@FXML
	private Label foodTypeLabel;
	
	@FXML
	private ListView<Food> pantryListView;
	
	@FXML
	private ComboBox<FoodType> foodTypeComboBox;
	
	@FXML
	private TextField foodNameTextField;

	@FXML
	private Button addFoodButton;
}
