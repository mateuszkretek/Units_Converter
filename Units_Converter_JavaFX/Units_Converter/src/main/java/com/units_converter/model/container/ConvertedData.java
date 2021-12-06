package com.units_converter.model.container;

/**
 * Class for storing data after conversion
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class ConvertedData {
	/**
	 * Double object for storing numerical value after conversion
	 */
	private final Double convertedValue;

	/**
	 * String object for storing converted value unit
	 */
	private final String convertedValueUnit;

	/**
	 * Constructor for {@link ConvertedData} object
	 *
	 * @param convertedValue Double object for storing numerical value after conversion
	 * @param convertedValueUnit String object for storing converted value unit
	 */
	public ConvertedData(Double convertedValue, String convertedValueUnit) {
		this.convertedValue = convertedValue;
		this.convertedValueUnit = convertedValueUnit;
	}

	/**
	 * Method for getting converted value
	 *
	 * @return converted value
	 */
	public Double getConvertedValue() {
		return convertedValue;
	}

	/**
	 * Method for getting converted value unit
	 *
	 * @return converted value unit
	 */
	public String getConvertedValueUnit() {
		return convertedValueUnit;
	}
}
