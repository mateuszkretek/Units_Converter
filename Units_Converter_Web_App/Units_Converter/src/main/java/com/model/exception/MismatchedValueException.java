package com.model.exception;

/**
 * Exception for not supported units
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class MismatchedValueException extends Exception {

	/**
	 * Default constructor for {@link MismatchedValueException} class object
	 *
	 * @param message exception message
	 */
	public MismatchedValueException(String message) {
		super(message);
	}
}
