package com.units_converter.model.converter;

import java.io.FileNotFoundException;

/**
 * Class responsible for conversion of time values
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class TimeConverter extends Converter {

	/**
	 * Constructor of {@link TimeConverter} class objects
	 *
	 * @throws FileNotFoundException if config file was not found
	 */
	public TimeConverter() throws FileNotFoundException {
		this.configFileName = "src/main/resources/com/units_converter/config/time_converter_config.txt";
		this.readConfig();
	}
}
