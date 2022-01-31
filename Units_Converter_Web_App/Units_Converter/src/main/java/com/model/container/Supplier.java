package com.model.container;

import com.model.container.ConverterType;
import com.model.converter.Converter;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class storing data needed for proper program functioning
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Supplier {

	/**
	 * Map storing list of supported units and converters for them
	 */
	private Map<ConverterType, ArrayList<String>> supportedUnitsCollection;

	/**
	 * Map storing converters and enum type describing their type
	 */
	private Map<ConverterType, Converter> converterCollection;

	/**
	 * {@link ConverterType} object storing type of current conversion
	 */
	private ConverterType converterType;

	/**
	 * Default constructor
	 */
	public Supplier() {
		super();
	}

	/**
	 * Getter for list of supported units
	 *
	 * @return list of supported units
	 */
	public Map<ConverterType, ArrayList<String>> getSupportedUnitsCollection() {
		return supportedUnitsCollection;
	}

	/**
	 * Setter for list of supported units
	 *
	 * @param supportedUnitsCollection list of supported units
	 */
	public void setSupportedUnitsCollection(Map<ConverterType, ArrayList<String>> supportedUnitsCollection) {
		this.supportedUnitsCollection = supportedUnitsCollection;
	}

	/**
	 * Getter for converter type
	 *
	 * @return {@link ConverterType} object storing converter type for current conversion
	 */
	public ConverterType getConverterType() {
		return converterType;
	}

	/**
	 * Setter for converter type
	 *
	 * @param converterType {@link ConverterType} object storing converter type for current conversion
	 */
	public void setConverterType(ConverterType converterType) {
		this.converterType = converterType;
	}

	/**
	 * Getter for map of converters and their types
	 *
	 * @return map of converters and their types
	 */
	public Map<ConverterType, Converter> getConverterCollection() {
		return converterCollection;
	}

	/**
	 * Setter for map of converters and their types
	 *
	 * @param converterCollection map of converters and their types
	 */
	public void setConverterCollection(Map<ConverterType, Converter> converterCollection) {
		this.converterCollection = converterCollection;
	}
}
