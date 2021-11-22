package main.controller.command;

import main.controller.container.Supplier;

/**
 * Class responsible for printing converted data
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class PrintConvertedDataCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public PrintConvertedDataCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		supplier.getView().printResult(supplier.getConvertedData());
		supplier.setCommandSuccess(true);
	}
}
