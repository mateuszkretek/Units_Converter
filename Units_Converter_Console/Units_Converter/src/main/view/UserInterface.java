package main.view;

import main.model.container.ConvertedData;

/**
 * Interface for all program outputs
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public interface UserInterface {
	/**
	 * Method for printing converted data
	 *
	 * @param convertedData converted data
	 */
	void printResult(ConvertedData convertedData);

	/**
	 * Method for printing exception message
	 *
	 * @param message exception message
	 */
	void printExceptionMessage(String message);

	/**
	 * Method for printing program help
	 */
	void printHelp();
}
