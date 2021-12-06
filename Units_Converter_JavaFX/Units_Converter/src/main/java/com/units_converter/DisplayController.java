package com.units_converter;


import com.units_converter.controller.ConversionController;
import com.units_converter.controller.container.ConverterType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {

	@FXML
	private Button convertButton;
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

	ConversionController conversionController;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		converterTypeComboBox.setItems(FXCollections.observableArrayList(ConverterType.values()));

		conversionController = new ConversionController();
		conversionController.checkConfig();
		/*if (controller.checkConfig()) {
			if (controller.detectConverterType())
				if (controller.convertValue())
					controller.printConvertedData();
		}*/
		//test();
	}

	@FXML
	private void converterTypeChosen(){
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
	private void inputUnitChosen(){
		conversionController.setInputUnit(inputValueUnit.getValue());
	}

	@FXML
	private void outputUnitChosen(){
		conversionController.setOutputUnit(convertedValueUnit.getValue());
	}

	@FXML
	private void convertValue(){
		conversionController.setInputValue(Double.parseDouble(inputValue.getText()));
		conversionController.convertValue();
		convertedValue.setText(String.valueOf(conversionController.printConvertedValue()));
	}

}

/*		switch (converterType){
			case LENGTH:
				break;
			case TIME:
				break;
			case WEIGHT:
				break;
		}*/