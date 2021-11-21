package main.controller.command;

import main.controller.container.Supplier;
import main.controller.exception.MismatchedArgException;

import java.util.ArrayList;

/**
 * Class responsible for reading starting parameters
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class SetArgsCommand extends Command {
	private final ArrayList<String> args;

	//TODO for-each loop

	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 * @param args list of starting parameters
	 */
	public SetArgsCommand(Supplier supplier, String... args) {
		super(supplier);
		this.args = new ArrayList<>();
		for (String arg : args) {
			this.args.add(arg);
		}

	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		if (!args.isEmpty()) {
			try {
				if (args.get(0).equals("-r") || args.get(0).equals("-h")) {
					supplier.setArgs(args);
				} else {
					throw new MismatchedArgException("Mismatched argument, program will run with no arguments");
				}
			} catch (MismatchedArgException mismatchedArg) {
				supplier.getView().printExceptionMessage(mismatchedArg.getMessage());
				supplier.setCommandSuccess(false);
				return;
			}
			supplier.setCommandSuccess(true);
			return;
		}
		supplier.setArgs(new ArrayList<>());
		supplier.setCommandSuccess(false);
	}
}
