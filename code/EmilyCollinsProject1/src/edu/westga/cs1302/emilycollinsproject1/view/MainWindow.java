package edu.westga.cs1302.emilycollinsproject1.view;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
	
	@FXML
    private Button decreaseQuantityButton;
	
	@FXML
    private Button increaseQuantityButton;
	
	@FXML
    private Label quantityLabel;

    @FXML
    private TextField quantityTextField;
    
    @FXML
    private Button editQuantityButton;
	
	/**
	 * Constructor for MainWindow.
	 * 
	 * @postcondition this.foodTypeComboBox is initialized
	 */
	public MainWindow() {
		this.foodTypeComboBox = new ComboBox<FoodType>();
		//this.foodTypeComboBox.setItems((FXCollections.observableArrayList(FoodType.values())));
	}
	
	/**
	 * Adds food object if not existing, otherwise adjusts quantity. 
	 * 
	 * @param event event that triggered method
	 */
	@FXML
	public void addFood(ActionEvent event) {
		try {
			Food food = new Food(this.foodNameTextField.getText(), this.foodTypeComboBox.getValue());
			if (this.checkFood(food) == -1) {
				food.increaseQuantity();
				this.pantryListView.getItems().add(food);
				System.out.println("Food added!");
				this.pantryListView.refresh();
			} else {
				this.pantryListView.getItems().get(this.checkFood(food)).increaseQuantity();
				this.pantryListView.refresh();
			}
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		}
	}
	
	@FXML
	public void setQuantity(ActionEvent event) {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().setQuantity(Integer.parseInt(this.quantityTextField.getText()));
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be null, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	@FXML 
	public void increaseQuantity() {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().increaseQuantity();
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be null, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	@FXML 
	public void decreaseQuantity() {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().decreaseQuantity();
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be null, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Initialize method
	 * 
	 */
	@FXML
	public void initialize() {
		this.foodTypeComboBox.setItems((FXCollections.observableArrayList(FoodType.values())));
	}
	
	private int checkFood(Food food) {
		for (Food currFood : this.pantryListView.getItems()) {
			if (currFood.equals(food)) {
				return this.pantryListView.getItems().indexOf(currFood);
			}
		}
		return -1;
	}
}
