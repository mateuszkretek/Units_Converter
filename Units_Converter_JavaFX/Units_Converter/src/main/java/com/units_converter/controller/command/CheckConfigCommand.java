package com.units_converter.controller.command;

import com.units_converter.controller.container.ConverterType;
import com.units_converter.controller.container.Supplier;
import com.units_converter.model.converter.Converter;
import com.units_converter.model.converter.LengthConverter;
import com.units_converter.model.converter.TimeConverter;
import com.units_converter.model.converter.WeightConverter;

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
	 *
	 * @throws FileNotFoundException if config file was not found
	 */
	@Override
	public void execute() throws FileNotFoundException {
		Map<ConverterType, ArrayList<String>> supportedUnitsCollection = new HashMap<>();
		Map<ConverterType, Converter> converterCollection = new HashMap<>();
		Converter converter;
//		try {
		converter = new LengthConverter();
		converterCollection.put(ConverterType.LENGTH, converter);
		supportedUnitsCollection.put(ConverterType.LENGTH, converter.getSupportedUnits());
		converter = new TimeConverter();
		converterCollection.put(ConverterType.TIME, converter);
		supportedUnitsCollection.put(ConverterType.TIME, converter.getSupportedUnits());
		converter = new WeightConverter();
		converterCollection.put(ConverterType.WEIGHT, converter);
		supportedUnitsCollection.put(ConverterType.WEIGHT, converter.getSupportedUnits());
/*		} catch (FileNotFoundException configFileNotFound) {
			supplier.getView().printExceptionMessage(configFileNotFound.getMessage() + "program will shut down");
			supplier.setCommandSuccess(false);
			return;
		}*/
		supplier.setConverterCollection(converterCollection);
		supplier.setSupportedUnitsCollection(supportedUnitsCollection);
		supplier.setCommandSuccess(true);
	}
}
