package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

/**
 * Class responsible for printing help for user
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class PrintHelpCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public PrintHelpCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		supplier.getView().printHelp();
		supplier.getArgs().clear();
		supplier.setCommandSuccess(false);
	}
}
