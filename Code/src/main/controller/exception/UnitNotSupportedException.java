package main.controller.exception;

/**
 * Exception for not supported units
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class UnitNotSupportedException extends Exception {
	/**
	 * Default constructor for {@link UnitNotSupportedException} class object
	 *
	 * @param message exception message
	 */
	public UnitNotSupportedException(String message) {
		super(message);
	}
}
