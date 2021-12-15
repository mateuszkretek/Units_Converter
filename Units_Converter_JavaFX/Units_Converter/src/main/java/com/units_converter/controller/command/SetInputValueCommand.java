package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

/**
 * Class responsible for setting input value
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class SetInputValueCommand extends Command {
	double inputValue;

	/**
	 * Default constructor
	 *
	 * @param supplier   {@link Supplier} class object representing container for whole program
	 * @param inputValue double containing input value
	 */
	public SetInputValueCommand(Supplier supplier, double inputValue) {
		super(supplier);
		this.inputValue = inputValue;
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		supplier.setInputValue(inputValue);
		supplier.setCommandSuccess(true);
	}
}
