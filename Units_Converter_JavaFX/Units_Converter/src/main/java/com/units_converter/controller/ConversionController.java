package com.units_converter.controller;

import com.units_converter.controller.command.*;
import com.units_converter.controller.container.ConverterType;
import com.units_converter.controller.container.Supplier;
import com.units_converter.view.Console;


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
		supplier.setView(new Console());
	}

	/**
	 * Method which runs {@link CheckConfigCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean checkConfig() {
		command = new CheckConfigCommand(supplier);
		command.execute();
		return supplier.getCommandSuccess();
	}

	public void setConverterType(ConverterType converterType){
		supplier.setConverterType(converterType);
	}

	public boolean setInputValue(double inputValue) {
		command = new SetInputValueCommand(supplier, inputValue);
		command.execute();
		return supplier.getCommandSuccess();
	}


	public boolean setInputUnit(String inputUnit) {
		command = new SetInputUnitCommand(supplier, inputUnit);
		command.execute();
		return supplier.getCommandSuccess();
	}

	public boolean setOutputUnit(String outputUnit) {
		command = new SetOutputUnitCommand(supplier, outputUnit);
		command.execute();
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which converts value with {@link ConvertValueCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean convertValue() {
		command = new ConvertValueCommand(supplier);
		command.execute();
		return supplier.getCommandSuccess();
	}

	public double printConvertedValue(){
		return supplier.getConvertedData().getConvertedValue();
	}
}
