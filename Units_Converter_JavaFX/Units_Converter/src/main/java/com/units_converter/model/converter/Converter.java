package com.units_converter.model.converter;
import com.units_converter.model.container.ConvertedData;
import com.units_converter.model.container.InputData;
import com.units_converter.model.exception.MismatchedValueException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Parent class for all categories of converters
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
abstract public class Converter {
	/**
	 * String object storing config file name
	 */
	protected String configFileName;

	/**
	 * Map storing pairs of String and Double objects representing name of unit and multiplier for its conversion
	 */
	protected Map<String, Double> supportedUnitsCollection;

	/**
	 * Method which reads data from config files stored in resources.config package
	 *
	 * @throws FileNotFoundException if config file is missing
	 */
	protected void readConfig() throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(this.configFileName));
		while (fileScanner.hasNext()) {
			this.supportedUnitsCollection.put(fileScanner.next(), fileScanner.nextDouble());
		}
		fileScanner.close();
	}

	/**
	 * Method responsible for converting passed value
	 *
	 * @param inputData {@link InputData} object storing data needed for conversion
	 * @return {@link ConvertedData} object storing converted value and its unit
	 * @throws MismatchedValueException if input value cannot be converted
	 */
	public ConvertedData convertValue(InputData inputData) throws MismatchedValueException {
		double inputValue = inputData.getInputValue();
		if (inputValue < 0) {
			throw new MismatchedValueException("Value cannot be negative");
		}
		Double inputUnitMultiplier = supportedUnitsCollection.get(inputData.getInputUnit());
		Double outputUnitMultiplier = supportedUnitsCollection.get(inputData.getOutputUnit());
		double result;
		result = inputValue * inputUnitMultiplier / outputUnitMultiplier;
		return new ConvertedData(result, inputData.getOutputUnit());
	}

	/**
	 * Method for getting supported units list
	 *
	 * @return ArrayList containing supported units
	 */
	public ArrayList<String> getSupportedUnits() {
		return new ArrayList<>(supportedUnitsCollection.keySet());
	}
}
