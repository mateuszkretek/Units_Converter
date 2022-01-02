package com.model.converter;

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
		//this.configFileName = ".\\src\\main\\resources\\time_converter_config.txt";
		this.configFileName = "E:\\Projects\\Projects\\Units_Converter\\Units_Converter_Web_App\\Units_Converter\\src\\main\\resources\\time_converter_config.txt";
		this.readConfig();
	}
}
