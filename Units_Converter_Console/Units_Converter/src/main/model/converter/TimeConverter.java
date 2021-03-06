package main.model.converter;

import java.io.FileNotFoundException;
import java.util.HashMap;

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
		this.configFileName = "src/resources/config/time_converter_config.txt";
		this.supportedUnitsCollection = new HashMap<>();
		this.readConfig();
	}
}
