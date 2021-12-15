package com.units_converter.controller;


import com.units_converter.controller.container.ConverterType;
import com.units_converter.model.exception.MismatchedValueException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Display controller
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class DisplayController implements Initializable {

	private ConversionController conversionController;
	@FXML
	private TextField inputValue;
	@FXML
	private TextField convertedValue;
	@FXML
	private ComboBox<ConverterType> converterTypeComboBox;
	@FXML
	private ComboBox<String> inputValueUnit;
	@FXML
	private ComboBox<String> convertedValueUnit;
	@FXML
	private TreeView<String> unitsTree;

	/**
	 * Method initializing view
	 *
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		converterTypeComboBox.setItems(FXCollections.observableArrayList(ConverterType.values()));
		conversionController = new ConversionController();
		try {
			conversionController.checkConfig();
		} catch (FileNotFoundException exception) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Config Error");
			alert.setHeaderText("Config file error");
			alert.setContentText(exception.getMessage());
			alert.showAndWait();
		}

		TreeItem<String> rootItem = new TreeItem<>("Supported Values");
		ArrayList<TreeItem<String>> typesListTreeItems = new ArrayList<>();
		for (ConverterType type : ConverterType.values()) {
			typesListTreeItems.add(new TreeItem<>(type.toString()));
		}
		rootItem.getChildren().addAll(typesListTreeItems);
		ArrayList<TreeItem<String>> buffer = new ArrayList<>();

		for (int i = 0; i < rootItem.getChildren().size(); i++) {
			for (String unit : this
					.conversionController
					.supplier
					.getSupportedUnitsCollection()
					.get(ConverterType.values()[i])) {
				buffer.add(new TreeItem<>(unit));
			}
			rootItem.getChildren()
					.get(i)
					.getChildren()
					.addAll(buffer);

			buffer.clear();
		}
		unitsTree.setRoot(rootItem);
	}

	/**
	 * Listener for choosing converter type
	 */
	@FXML
	private void converterTypeChosen() {
		ConverterType converterType = converterTypeComboBox.getValue();
		inputValueUnit.setItems(
				FXCollections.observableArrayList(
						conversionController.supplier.getSupportedUnitsCollection().get(converterType)));
		convertedValueUnit.setItems(
				FXCollections.observableArrayList(
						conversionController.supplier.getSupportedUnitsCollection().get(converterType)));
		conversionController.setConverterType(converterType);
	}

	/**
	 * Listener for choosing input unit
	 */
	@FXML
	private void inputUnitChosen() {
		conversionController.setInputUnit(inputValueUnit.getValue());
	}

	/**
	 * Listener for choosing output unit
	 */
	@FXML
	private void outputUnitChosen() {
		conversionController.setOutputUnit(convertedValueUnit.getValue());
	}

	/**
	 * Listener for convert value button
	 */
	@FXML
	private void convertValue() {
		try {
			conversionController.setInputValue(Double.parseDouble(inputValue.getText()));
			conversionController.convertValue();
			convertedValue.setText(String.valueOf(conversionController.printConvertedValue()));
		} catch (MismatchedValueException exception) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Conversion Error");
			alert.setHeaderText("Mismatched value for conversion");
			alert.setContentText(exception.getMessage());
			alert.showAndWait();
		} catch (NumberFormatException exception) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Conversion Error");
			alert.setHeaderText("Mismatched value for conversion");
			alert.setContentText("Value must be a number");
			alert.showAndWait();
		} catch (NullPointerException exception){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Conversion Error");
			alert.setHeaderText("Unit not chosen");
			alert.setContentText("You must choose unit");
			alert.showAndWait();
		}
	}
}
