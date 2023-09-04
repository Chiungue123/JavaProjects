package com.JavaMiniProjects.DuplicateSolver;

import java.util.*;

public class DuplicateSolver {
	// Initialize the random object globally to be accessed for each data type
	public static Random random = new Random();
	
	public static void main(String[] args) {
		handleType();
	}
	
	public static void handleType() {
		// Declare the valid boolean, dataType string and scanner object to prompt the user and validate input
		boolean valid;
		String dataType;
		Scanner scanner = new Scanner(System.in);
		
		do {
			valid = false;
			System.out.println("Enter Data Type");
			System.out.println("1: String");
			System.out.println("2: Integer");
			System.out.println("3: Float");
			System.out.println("4: Char");
			dataType = scanner.nextLine();
			if (dataType.equals("1") || dataType.equals("2") || dataType.equals("3") || dataType.equals("4")) {
			    valid = true;
			}
		} while(!valid);
			
		// Once valid input is received, pass the variable to the switch statement
		// The applicable method will be executed depending on the user input
		switch(dataType) {
		case("1"):
			generateStrings();
			scanner.close();
			break;
			
		case("2"):
			generateIntegers();
			scanner.close();
			break;
		
		case("3"):
			generateFloats();
			scanner.close();
			break;
		
		case("4"):
			generateChars();
			scanner.close();
			break;
	
		default: 
			System.out.println("Invalid Input");
			break;
		}
	}
	
	private static void generateStrings() {
		List<String> list = new ArrayList<>();
		// Add 100 random strings to ArrayList
		for (int i = 0; i < 100; i++) {
			// Generate a random 2 character string, add it to the list
			list.add(generateRandomString());
		}
		System.out.println("ArrayList: With Duplicates");
		System.out.println(list);
		printHashSet(list);
	}
	
	private static String generateRandomString() {
		// Defines 5 capital case letters in the variable characters
		// The string builder's mutability enables indices from characters to be added to result to construct random strings
	    String characters = "ABCDE";
	    StringBuilder result = new StringBuilder();
	    for (int i = 0; i < 2; i++) {
	        char c = characters.charAt(random.nextInt(characters.length()));
	        result.append(c);
	    }
	    // Return the randomized string
	    return result.toString();
	}
	
	private static void generateIntegers() {
		// Add 100 random integers to ArrayList
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			// Generate a random number between 1 and 30, add it to the list
			list.add((random.nextInt(30) + 1));
		}
		System.out.println("ArrayList: With Duplicates");
		System.out.println(list);
		printHashSet(list);
	}
	
	private static void generateFloats() {
		// Add 30 random floats to ArrayList
		List<Float> list = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			// Generate a random float between 0.0 and 1.0, add it to the list
			float number = random.nextFloat() * 10; // Random number between 0.000 and 9.999, multiplied by 10 puts two digits ahead of the decimal
			int temp = (int) number; // Truncate - in other words remove - the decimal, now one or two digits remain, becoming an integer
			float oneDecimalFloat = temp / 10.0f; //Divide by 10.0F, shifting the digit(s) back a decimal place
			
			list.add(oneDecimalFloat);
		}
		System.out.println("ArrayList: With Duplicates");
		System.out.println(list);
		printHashSet(list);
	}
	
	private static void generateChars() {
		// Add 100 random characters to ArrayList
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			// Generate a random character between A to Z, add it to the list
			list.add((char) (random.nextInt(26) + 'A'));
		}
		System.out.println("ArrayList: With Duplicates");
		System.out.println(list);
		printHashSet(list);
	}
	
	private static <T> void printHashSet (List<T> list) {
		// Define a hash set with list as the constructor
		Set<T> set = new HashSet<>(list);
		System.out.println();
		System.out.println("HashSet: Without Duplicates");
		System.out.println(set);
	}
}

/*
	Create a program that takes a list of integers and removes all duplicate values

	The program should be able to take multiple integers as input
	Use a HashSet to store unique integers
	Output the unique integers in no particular order

	Bonus: Make it work for not just integers, but also for floating-point numbers and strings
*/