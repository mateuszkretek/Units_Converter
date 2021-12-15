package com.units_converter.controller;

import com.units_converter.controller.command.*;
import com.units_converter.controller.container.ConverterType;
import com.units_converter.controller.container.Supplier;
import com.units_converter.model.exception.MismatchedValueException;

import java.io.FileNotFoundException;


/**
 * Main class in Controller package
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class ConversionController {

	/**
	 * Supplier class object, storing all data needed for program
	 */
	public final Supplier supplier;

	/**
	 * Command class object for handling commands
	 */
	private Command command;

	/**
	 * Default constructor for {@link ConversionController} class
	 */
	public ConversionController() {
		supplier = new Supplier();
	}

	/**
	 * Method which runs {@link CheckConfigCommand}
	 *
	 * @return true if command succeeded or false if failed
	 * @throws FileNotFoundException if file was not found
	 */
	public boolean checkConfig() throws FileNotFoundException {
		try {
			command = new CheckConfigCommand(supplier);
			command.execute();
		} catch (MismatchedValueException e) {
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Setter for converter type
	 *
	 * @param converterType enum storing converter type
	 */
	public void setConverterType(ConverterType converterType) {
		supplier.setConverterType(converterType);
	}

	/**
	 * Setter for input value
	 *
	 * @param inputValue double storing input value
	 * @return true if command succeeded or false if failed
	 */
	public boolean setInputValue(double inputValue) {
		try {
			command = new SetInputValueCommand(supplier, inputValue);
			command.execute();
		} catch (Exception e) {
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Setter for input unit
	 *
	 * @param inputUnit string storing input unit
	 * @return true if command succeeded or false if failed
	 */
	public boolean setInputUnit(String inputUnit) {
		try {
			command = new SetInputUnitCommand(supplier, inputUnit);
			command.execute();
		} catch (Exception e) {
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Setter for output unit
	 *
	 * @param outputUnit string storing output unit
	 * @return true if command succeeded or false if failed
	 */
	public boolean setOutputUnit(String outputUnit) {
		try {
			command = new SetOutputUnitCommand(supplier, outputUnit);
			command.execute();
		} catch (Exception e) {
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which converts value with {@link ConvertValueCommand}
	 *
	 * @return true if command succeeded or false if failed
	 * @throws MismatchedValueException if mismatching value is present
	 */
	public boolean convertValue() throws MismatchedValueException {
		try {
			command = new ConvertValueCommand(supplier);
			command.execute();
		} catch (FileNotFoundException e) {
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Getter for converted value
	 *
	 * @return true if command succeeded or false if failed
	 */
	public double printConvertedValue() {
		return supplier.getConvertedData().getConvertedValue();
	}
}
