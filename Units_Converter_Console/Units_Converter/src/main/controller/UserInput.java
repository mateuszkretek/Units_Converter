package main.controller;

import main.model.container.InputData;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for reading input data passed by User
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class UserInput {

	/**
	 * Method reading value to convert, input and output values units
	 *
	 * @return {@link InputData object containing all read data}
	 * @throws InputMismatchException if user tries to pass text as numerical value
	 */
	public InputData readData() throws InputMismatchException {
		Double inputValue = this.readInputValue();
		String inputUnit = this.readInputUnit();
		String outputUnit = this.readOutputUnit();
		return new InputData(inputValue, inputUnit, outputUnit);
	}

	/**
	 * Method reading value to convert
	 *
	 * @return double type object
	 */
	public Double readInputValue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pass input value");
		return scanner.nextDouble();
	}

	/**
	 * Method reading input value unit
	 *
	 * @return String type object
	 */
	public String readInputUnit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pass input unit");
		return scanner.next();
	}

	/**
	 * Method reading output value unit
	 *
	 * @return String type object
	 */
	public String readOutputUnit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pass output unit");
		return scanner.next();
	}
}
