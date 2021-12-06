package main;

import main.controller.Controller;

/**
 * Main class of program
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Main {

	/**
	 * Main method of program
	 *
	 * @param args startup arguments for program
	 */
	public static void main(String... args) {
		Controller controller = new Controller();
		if (controller.checkConfig()) {
			if (!controller.handleArgs(args)) {
				controller.getInputData();
			}
			if (controller.detectConverterType())
				if (controller.convertValue())
					controller.printConvertedData();
		}
	}
}

