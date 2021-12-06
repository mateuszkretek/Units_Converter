package com.units_converter.model.converter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Class responsible for conversion of weight values
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class WeightConverter extends Converter {

	/**
	 * Constructor of {@link WeightConverter} class objects
	 *
	 * @throws FileNotFoundException if config file was not found
	 */
	public WeightConverter() throws FileNotFoundException {
		this.configFileName = "src/main/resources/com/units_converter/config/weight_converter_config.txt";
		this.supportedUnitsCollection = new HashMap<>();
		this.readConfig();
	}
}
