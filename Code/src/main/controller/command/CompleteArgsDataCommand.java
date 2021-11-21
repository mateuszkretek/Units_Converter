package main.controller.command;

import main.controller.UserInput;
import main.controller.container.Supplier;
import main.model.container.InputData;

/**
 * Class responsible for getting missing parameters from user
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class CompleteArgsDataCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public CompleteArgsDataCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		double buffer;
		UserInput userInput = new UserInput();
		InputData inputData = new InputData();
		try {
			buffer = Double.parseDouble(supplier.getArgs().get(1));
		} catch (NumberFormatException valueIsNotANumber) {
			supplier.getView().printExceptionMessage("Value is not a number");
			supplier.getArgs().clear();
			supplier.setCommandSuccess(false);
			return;
		}
		switch (supplier.getArgs().size()) {
			case 2:
				inputData.setData(buffer, userInput.readInputUnit(), userInput.readOutputUnit());
				break;
			case 3:
				inputData.setData(buffer, supplier.getArgs().get(2), userInput.readOutputUnit());
				break;
			case 4:
				inputData.setData(buffer, supplier.getArgs().get(2), supplier.getArgs().get(3));
				break;
		}
		supplier.setInputData(inputData);
		supplier.setCommandSuccess(true);
	}
}
