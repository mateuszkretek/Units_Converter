package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;
import com.units_converter.model.exception.MismatchedValueException;

import java.io.FileNotFoundException;

/**
 * Class representing Command pattern
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public abstract class Command {
	/**
	 * {@link Supplier} class object storing all data needed for program
	 */
	protected Supplier supplier;

	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public Command(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Method for executing command content
	 *
	 * @throws MismatchedValueException if any value is mismatched
	 * @throws FileNotFoundException    if needed file was not found
	 */
	public abstract void execute() throws MismatchedValueException, FileNotFoundException;
}
