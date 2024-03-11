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
	@CsvSource({"999999, false", "1000000, true", "9999999, true",
	"10000000, false", "999999999, false", "1000000000, true",
	"9999999999, true", "10000000000, false"})
	void test(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.verifyNumber(number);
		
		assertEquals(expectedResult, result, "checking if number (" + number + ") was reported as valid");
	}
}
