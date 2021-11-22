package main.controller.command;

import main.controller.UserInput;
import main.controller.container.Supplier;
import main.model.container.InputData;

import java.util.InputMismatchException;

/**
 * Class responsible for reading input data passed by user
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class ReadInputDataCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public ReadInputDataCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		UserInput userInput = new UserInput();
		InputData inputData;

		do {
			try {
				inputData = userInput.readData();

			} catch (InputMismatchException valueIsNotNumeric) {
				supplier.getView().printExceptionMessage("Mismatched value, try again");
				continue;
			}
			break;
		} while (true);

		supplier.setInputData(inputData);
		supplier.setCommandSuccess(true);
	}
}
