package main.controller;

import main.controller.command.*;
import main.controller.container.Supplier;
import main.view.Console;

/**
 * Main class in Controller package
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Controller {

	/**
	 * Supplier class object, storing all data needed for program
	 */
	private final Supplier supplier;

	/**
	 * Command class object for handling commands
	 */
	private Command command;

	/**
	 * Default constructor for {@link Controller} class
	 */
	public Controller() {
		supplier = new Supplier();
		supplier.setView(new Console());
	}

	/**
	 * Method which runs {@link CheckConfigCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean checkConfig() {
		command = new CheckConfigCommand(supplier);
		command.execute();
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which handles starting args with {@link SetArgsCommand}, {@link CompleteArgsDataCommand} and {@link PrintHelpCommand}
	 *
	 * @param args representing starting args for program
	 * @return true if commands succeeded or false if failed
	 */
	public boolean handleArgs(String... args) {
		command = new SetArgsCommand(supplier, args);
		command.execute();
		if (supplier.getCommandSuccess()) {
			if (supplier.getArgs().get(0).equals("-r")) {
				command = new CompleteArgsDataCommand(supplier);
			} else if (supplier.getArgs().get(0).equals("-h")) {
				command = new PrintHelpCommand(supplier);
			}
			command.execute();
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which reads input data passed by user with {@link ReadInputDataCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean getInputData() {
		if (supplier.getArgs().isEmpty()) {
			command = new ReadInputDataCommand(supplier);
			command.execute();
		}
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which detects category of unit for conversion with {@link DetectConverterTypeCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean detectConverterType() {
		command = new DetectConverterTypeCommand(supplier);
		command.execute();
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which converts value with {@link ConvertValueCommand}
	 *
	 * @return true if command succeeded or false if failed
	 */
	public boolean convertValue() {
		command = new ConvertValueCommand(supplier);
		command.execute();
		return supplier.getCommandSuccess();
	}

	/**
	 * Method which prints converted data with {@link PrintConvertedDataCommand}
	 */
	public void printConvertedData() {
		command = new PrintConvertedDataCommand(supplier);
		command.execute();
	}
}
