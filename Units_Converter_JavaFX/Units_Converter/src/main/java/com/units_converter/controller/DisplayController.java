package com.units_converter.controller;


import com.units_converter.controller.container.ConverterType;
import com.units_converter.model.exception.MismatchedValueException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {

	ConversionController conversionController;
	/*	@FXML
		private Button convertButton;*/
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
		//rootItem.isExpanded(true);
		ArrayList<TreeItem<String>> typesListTreeItems = new ArrayList<>();
		for (ConverterType type: ConverterType.values()) {
			typesListTreeItems.add(new TreeItem<>(type.toString()));
		}
		rootItem.getChildren().addAll(typesListTreeItems);
		ArrayList<TreeItem<String>> buffer = new ArrayList<>();

		for (int i = 0; i<rootItem.getChildren().size();i++) {
			for (String unit:this
					.conversionController
					.supplier
					.getSupportedUnitsCollection()
					.get(ConverterType.values()[i]))
			{
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

	@FXML
	private void inputUnitChosen() {
		conversionController.setInputUnit(inputValueUnit.getValue());
	}

	@FXML
	private void outputUnitChosen() {
		conversionController.setOutputUnit(convertedValueUnit.getValue());
	}

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
		}
	}
}
