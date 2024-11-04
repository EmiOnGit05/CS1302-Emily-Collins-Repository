package edu.westga.cs1302.project2.view;

import java.io.IOException;
import java.util.Comparator;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.TypeComparator;
import edu.westga.cs1302.project2.utilities.RecipeStringConverter;
import edu.westga.cs1302.project2.model.RecipeFileWriter;
import edu.westga.cs1302.project2.model.NameComparator;
import edu.westga.cs1302.project2.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private ComboBox<String> ingredientType;
	@FXML
	private ListView<Ingredient> ingredientsList;
	@FXML
	private TextField ingredientName;
	@FXML
	private ComboBox<Comparator<Ingredient>> sortByComboBox;

	@FXML
	private Label sortByLabel;
	@FXML
	private Label recipeLabel;

	@FXML
	private ListView<Ingredient> recipeListView;
	@FXML
	private Button addIngredientsButton;

	@FXML
	private Button addRecipeButton;
	@FXML
	private TextField recipeNameTextField;

	@FXML
	private Label recipeTextLabel;

	@FXML
	void addIngredient(ActionEvent event) {
		try {
			this.ingredientsList.getItems().add(new Ingredient(this.ingredientName.getText(), this.ingredientType.getValue()));
			this.ingredientName.clear();
			this.ingredientType.getSelectionModel().clearSelection();
			this.changeOrder(event);
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add ingredient");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML 
	void addIngredientToRecipe(ActionEvent event) {
		if (this.ingredientsList.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("No ingredient is selected! Please select one and try again.");
			alert.showAndWait();
		} else {
			this.recipeListView.getItems().add(this.ingredientsList.getSelectionModel().getSelectedItem());
		}
		
	}

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
			this.changeOrder(event);
		}
	}
	
	@FXML
	void addRecipe(ActionEvent event) {
		try {
			Recipe recipe = new Recipe(this.recipeListView.getItems(), this.recipeNameTextField.getText());
			String recipeString = RecipeStringConverter.recipeConverter(recipe);
			RecipeFileWriter writer = new RecipeFileWriter();
			writer.saveRecipe(recipeString);
			this.recipeListView.getItems().clear();
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Recipe added!");
			alert.showAndWait();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to create/add recipe");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		} catch (IOException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to save recipe to file");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	void changeOrder(ActionEvent event) {
		this.ingredientsList.getItems().sort(this.sortByComboBox.getValue());
	}

	@FXML
	void initialize() {
		this.ingredientType.getItems().add("Vegetable");
		this.ingredientType.getItems().add("Meat");
		this.ingredientType.getItems().add("Bread");
		this.ingredientType.getItems().add("Fruit");
		this.ingredientType.getItems().add("Spice");
		this.sortByComboBox.getItems().add(new TypeComparator());
		this.sortByComboBox.getItems().add(new NameComparator());
		this.sortByComboBox.setValue(this.sortByComboBox.getItems().get(0));

	}
}
