package com.courseendprojects.JUnit1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AppTest  {
	
	App app;
	
	@BeforeAll
	public void beforeAll() {
		System.out.println("BeforeAll: Initizlizing App");
		System.out.println();
		app = new App();
	}
	
	@BeforeEach
	public void before() {
		System.out.println("BeforeEach");
	}
	
	@AfterEach
	public void after() {
		System.out.println("AfterEach");
		System.out.println();
	}
    
	@Test
    public void add() {
    	System.out.println("Add");
    	int a = 10;
    	int b = 3;
    	int expectedResult = 13;
    	assertEquals( expectedResult, app.add(a, b) );
    	assertNotEquals( 0, app.add(a, b) );
    }
    
	@Test
    public void multiply() {
    	System.out.println("Multiply");
    	int a = 10;
    	int b = 3;
    	int expectedResult = 30;
    	assertEquals( expectedResult, app.multiply(a, b) );
    	assertNotEquals( 0, app.multiply(a, b) );
    }
    
	@Test
    public void divide() {
    	System.out.println("Divide");
    	int a = 10;
    	int b = 3;
    	int expectedResult = 3;
    	assertEquals( expectedResult, app.divide(a, b) );
    	assertNotEquals( 0, app.divide(a, b) );
    }
}