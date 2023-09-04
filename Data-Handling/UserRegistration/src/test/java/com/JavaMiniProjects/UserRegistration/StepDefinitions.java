package com.JavaMiniProjects.UserRegistration;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	
	private boolean isValidString(String value) {
	    // Check if the string is not empty and maybe other custom rules
	    return !value.isEmpty();
	}

	private boolean isValidAge(Integer age) {
	    // Check if age is greater than zero
	    return age > 0;
	}
	
	public class ValidationException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	    public ValidationException(String message) {
	        super(message);
	    }
	}

	@Given("I enter the values {string}, {string} and {int}")
	public void i_enter_the_values(String name, String email, Integer age) {
		if (!isValidString(name) || !isValidString(email) || !isValidAge(age)) {
	        // Handle error condition, such as raising a specific exception or setting a failure status
			throw new ValidationException("Validation failed for name, email, or age.");
	    }
	    System.out.println("Name: " + name + ", Email: " + email + ", Age: " + age);
	}

	@When("I press enter")
	public void i_press_enter() {
		System.out.println("2: When");
	}

	@Then("The program validation will return a {string}")
	public void the_program_validation_will_return_a(String status) {
		System.out.println("Status: " + status);
	}
}
