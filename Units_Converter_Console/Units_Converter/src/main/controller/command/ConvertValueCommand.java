package main.controller.command;

import main.controller.container.Supplier;
import main.model.container.ConvertedData;
import main.model.exception.MismatchedValueException;
import main.view.UserInterface;

/**
 * Class responsible for converting value
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class ConvertValueCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public ConvertValueCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		ConvertedData convertedData;
		try {
			convertedData = supplier.getConverterCollection().get(supplier.getConverterType()).convertValue(supplier.getInputData());
		} catch (MismatchedValueException mismatchedValueException) {
			UserInterface view = supplier.getView();
			view.printExceptionMessage(mismatchedValueException.getMessage() + "program will shut down");
			supplier.setCommandSuccess(false);
			return;
		}
		supplier.setConvertedData(convertedData);
		supplier.setCommandSuccess(true);
	}
}
