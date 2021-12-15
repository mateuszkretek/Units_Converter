package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

/**
 * Class responsible for setting output unit
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class SetOutputUnitCommand extends Command {
	String outputUnit;

	/**
	 * @param supplier   {@link Supplier} class object representing container for whole program
	 * @param outputUnit String containing output value
	 */
	public SetOutputUnitCommand(Supplier supplier, String outputUnit) {
		super(supplier);
		this.outputUnit = outputUnit;
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		supplier.setOutputUnit(outputUnit);
		supplier.setCommandSuccess(true);
	}
}
