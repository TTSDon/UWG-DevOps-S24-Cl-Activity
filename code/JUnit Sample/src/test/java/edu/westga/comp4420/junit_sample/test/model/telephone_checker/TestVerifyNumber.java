package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestVerifyNumber {

	@ParameterizedTest
	@ValueSource(longs = {999999L})
	void testInvalidNumbers(long number) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.verifyNumber(number);
		
		assertFalse(result, "checking if number was reported as valid");
	}

	@ParameterizedTest
	@CsvSource({"999999, false"})
	void test(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.verifyNumber(number);
		
		assertEquals(expectedResult, result, "checking if number was reported as valid");
	}
}
