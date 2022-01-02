package com.model.converter;

import java.io.FileNotFoundException;

/**
 * Class responsible for conversion of length values
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class LengthConverter extends Converter {

	/**
	 * Constructor of {@link LengthConverter} class objects
	 *
	 * @throws FileNotFoundException if config file was not found
	 */
	public LengthConverter() throws FileNotFoundException {
		this.configFileName = "src/main/resources/com/units_converter/config/length_converter_config.txt";
		this.readConfig();
	}
}
