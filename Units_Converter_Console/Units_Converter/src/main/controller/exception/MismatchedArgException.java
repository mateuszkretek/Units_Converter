package main.controller.exception;

/**
 * Exception for mismatched args
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class MismatchedArgException extends Exception {
	/**
	 * Default constructor for {@link MismatchedArgException} class object
	 *
	 * @param message exception message
	 */
	public MismatchedArgException(String message) {
		super(message);
	}
}