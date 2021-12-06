package com.units_converter.tests.model;

import com.units_converter.model.converter.Converter;
import com.units_converter.model.converter.TimeConverter;
import com.units_converter.model.exception.MismatchedValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing Time Converter
 *
 * @author Mateusz Kretek
 * @version 1.0
 */
public class TimeConverterTest {
	/**
	 * {@link Converter} class object storing converter for testing
	 */
	private Converter converter;

	/**
	 * Stream of standard condition parameters for test
	 *
	 * @return Stream of standard condition parameters for test
	 */
	static Stream<ParametersContainer> standardConditionsParametersProvider() {
		return Stream.of(
				new ParametersContainer(1.0, "h", 60.0, "min")
		);
	}

	/**
	 * Stream of border condition parameters for test
	 *
	 * @return Stream of border condition parameters for test
	 */
	static Stream<ParametersContainer> borderConditionsParametersProvider() {
		return Stream.of(
				new ParametersContainer(-1.0, "h", 0.0, "min")
		);
	}

	/**
	 * Method creating setting up new converter before each test
	 */
	@BeforeEach
	public void setUp() {
		try {
			converter = new TimeConverter();
		} catch (FileNotFoundException error) {
			fail("Config file not found");
		}
	}

	/**
	 * Method testing converter in standard conditions
	 *
	 * @param params parameters for test
	 */
	@ParameterizedTest
	@MethodSource("standardConditionsParametersProvider")
	public void testStandardConditionsConverting(ParametersContainer params) {
		try {
			assertEquals(
					converter.convertValue(params.inputData).getConvertedValue(),
					params.convertedData.getConvertedValue(),
					0.01,
					"failed");
		} catch (MismatchedValueException mismatchedValueException) {
			fail("Values are positive");
		}
	}

	/**
	 * Method testing converter in border conditions
	 *
	 * @param params parameters for test
	 */
	@ParameterizedTest
	@MethodSource("borderConditionsParametersProvider")
	public void testBorderConditionsConverting(ParametersContainer params) {
		try {
			converter.convertValue(params.inputData);
			fail("An exception should be thrown when input value is negative");
		} catch (MismatchedValueException mismatchedValueException) {
			assertNotNull(mismatchedValueException);
		}
	}
}
