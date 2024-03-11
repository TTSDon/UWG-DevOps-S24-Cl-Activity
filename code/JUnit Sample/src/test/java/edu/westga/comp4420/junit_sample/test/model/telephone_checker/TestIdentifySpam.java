package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	@ParameterizedTest
    @CsvSource({
		"9990000000, true",
		"9999999999, true",
		"9119999999, true",
        "9990000000, true",
        "9000000000, true", 
        "8880000000, true", 
        "8000000000, true", 
        "9110000000, true", 
        "4110000000, true", 
        "3210000000, false", 
        "9999999, false",
        "1000000000, false", 
        "1999999999, false",
    })
    void testIdentifySpam(long number, boolean expectedSpam) {
        TelephoneChecker checker = new TelephoneChecker();
        
        boolean isSpam = checker.identifySpam(number);
        
        assertEquals(expectedSpam, isSpam);
    }
	
	@Test
    void testIdentifySpamWithInvalidNumber() {
        TelephoneChecker checker = new TelephoneChecker();
        long invalidNumberLowBound = 999999999L;
		long invalidNumberHighBound = 10000000000L;
        
        assertThrows(IllegalArgumentException.class, () -> {
            checker.identifySpam(invalidNumberLowBound);
        });
		 assertThrows(IllegalArgumentException.class, () -> {
			checker.identifySpam(invalidNumberHighBound);
		}); 
    }
}
