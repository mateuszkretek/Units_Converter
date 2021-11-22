package main.controller.command;

import main.controller.container.ConverterType;
import main.controller.container.Supplier;
import main.model.converter.Converter;
import main.model.converter.LengthConverter;
import main.model.converter.TimeConverter;
import main.model.converter.WeightConverter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for checking config files
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class CheckConfigCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public CheckConfigCommand(Supplier supplier) {
		super(supplier);
	}

	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		Map<ConverterType, ArrayList<String>> supportedUnitsCollection = new HashMap<>();
		Map<ConverterType, Converter> converterCollection = new HashMap<>();
		Converter converter;
		try {
			converter = new LengthConverter();
			converterCollection.put(ConverterType.LENGTH, converter);
			supportedUnitsCollection.put(ConverterType.LENGTH, converter.getSupportedUnits());
			converter = new TimeConverter();
			converterCollection.put(ConverterType.TIME, converter);
			supportedUnitsCollection.put(ConverterType.TIME, converter.getSupportedUnits());
			converter = new WeightConverter();
			converterCollection.put(ConverterType.WEIGHT, converter);
			supportedUnitsCollection.put(ConverterType.WEIGHT, converter.getSupportedUnits());
		} catch (FileNotFoundException configFileNotFound) {
			supplier.getView().printExceptionMessage(configFileNotFound.getMessage() + "program will shut down");
			supplier.setCommandSuccess(false);
			return;
		}
		supplier.setConverterCollection(converterCollection);
		supplier.setSupportedUnitsCollection(supportedUnitsCollection);
		supplier.setCommandSuccess(true);
	}
}
