package com.units_converter.view;

import com.units_converter.model.container.ConvertedData;

/**
 * Class representing system console output
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Console implements UserInterface {

	/**
	 * Default {@link Console} object constructor
	 */
	public Console() {
		super();
	}

	/**
	 * Method for printing converted data
	 *
	 * @param convertedData {@link ConvertedData} object storing converted data
	 */
	public void printResult(ConvertedData convertedData) {
		System.out.print("Result: ");
		System.out.println(convertedData.getConvertedValue() + " " + convertedData.getConvertedValueUnit() + "\n");
	}

	/**
	 * Method for printing exception message
	 *
	 * @param message exception message
	 */
	public void printExceptionMessage(String message) {
		System.out.println(message + "\n");
	}

	/**
	 * Method for printing program help
	 */
	@Override
	public void printHelp() {
		System.out.println("Help for Units Converter");
		System.out.println("Available parameters:\n" +
				"-r [value] [input unit] [output unit] run program with passed data\n" +
				"-h print help\n");
	}
}
