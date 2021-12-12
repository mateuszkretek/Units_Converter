package com.units_converter.tests;

import com.units_converter.model.container.ConvertedData;
import com.units_converter.model.container.InputData;

/**
 * Class storing parameters for tests
 *
 * @author Mateusz Kretek
 * @version 1.0
 */
public class ParametersContainer {
	/**
	 * Object storing input data
	 */
	public InputData inputData;

	/**
	 * Object storing converted data
	 */
	public ConvertedData convertedData;

	/**
	 * Default constructor
	 *
	 * @param inputValue  input value
	 * @param inputUnit   input value unit
	 * @param outputValue output value
	 * @param outputUnit  output value unit
	 */
	public ParametersContainer(Double inputValue, String inputUnit, Double outputValue, String outputUnit) {
		inputData = new InputData(inputValue, inputUnit, outputUnit);
		convertedData = new ConvertedData(outputValue, outputUnit);
	}
}
