package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

/**
 * Class responsible for setting input unit
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class SetInputUnitCommand extends Command {
	String inputUnit;

	/**
	 * Default constructor
	 *
	 * @param supplier  {@link Supplier} class object representing container for whole program
	 * @param inputUnit String containing input unit
	 */
	public SetInputUnitCommand(Supplier supplier, String inputUnit) {
		super(supplier);
		this.inputUnit = inputUnit;
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		supplier.setInputUnit(inputUnit);
		supplier.setCommandSuccess(true);
	}
}

