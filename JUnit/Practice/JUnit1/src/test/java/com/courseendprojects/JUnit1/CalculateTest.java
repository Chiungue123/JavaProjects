package com.courseendprojects.JUnit1;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class CalculateTest {

	Calculate calculate;
	
	@BeforeAll
	public void initialize() {
		System.out.println("Initialize");
		calculate = new Calculate();
	}
	
	@Order(1)
	@ParameterizedTest(name="{index} - {0} price, ${1}% tax, ${2} friends, ${3} amount ")
	@CsvSource({
		"100.00, 10.00, 4, 27.50",
		"50.00, 20.00, 4, 15.00",
		"80.00, 5.00, 3, 28.00"
	})
	public void testSplitWithFriends(double price, double percentTax, int numFriends, double amount) {
		System.out.println("testSplitWithFriends");
		assertEquals(amount, calculate.splitWithFriends(price, percentTax, numFriends), 0.001); // Accept a tolerance of 0.001
	}
	
	@Order(2)
	@Test
	public void testInvalidSplitWithFriends(double price, double percentTax, int numFriends) {
		System.out.println("testInvalidSplitWithFriends");
		assertThrows(InvalidParameterException.class, () -> calculate.splitWithFriends(100.00, 10.00, 0));
	}
	
}
