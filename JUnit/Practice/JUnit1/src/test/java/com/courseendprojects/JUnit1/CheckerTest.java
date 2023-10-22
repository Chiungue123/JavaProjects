package com.courseendprojects.JUnit1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class) // Control order of tests
public class CheckerTest {
	
	Checker checker;

	@BeforeAll
	public void initialize() {
		checker = new Checker();
	}
	
	@Order(1)
	@ParameterizedTest(name="{index} - {0} is a Palindrome")
	@ValueSource(strings = {"12321", "pop", "racecar", "noon"})
	public void checkIfPalindrome(String word) {
		assertTrue(checker.isPalindrome(word));
	}
	
	@Order(2)
	@ParameterizedTest(name="{index} - {0} is a Palindrome")
	@ValueSource(strings = {"unit", "assert", "object", "class"})
	public void checkIfNotPalindrome(String word) {
		assertFalse(checker.isPalindrome(word));
	}
	
	// To get values from a file, use @CsvFileSource
	// Look at
	
}