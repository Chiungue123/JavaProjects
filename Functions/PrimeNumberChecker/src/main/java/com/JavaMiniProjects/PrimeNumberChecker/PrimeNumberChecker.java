package com.JavaMiniProjects.PrimeNumberChecker;

import java.util.Scanner;

public class PrimeNumberChecker {

	public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
        // Prompt user to check if a number is prime or to generate prime numbers
    	int input = prompt(scanner);
    	
    	if (input == 1) {
    		// Check if a number is prime
    		System.out.println("Enter a number to check if its prime:");
    		int num = getPositiveInteger(scanner);
    		if (isPrime(num)) {
    		    System.out.println(num + " is prime.");
    		} else {
    		    System.out.println(num + " is not prime.");
    		}

    	}
    	else {
    		// Generate a series of prime numbers up to 'n'
    		System.out.println("Enter a range to generate prime numbers:");
    		int num = getPositiveInteger (scanner);
    		generatePrime(num);	
    	}
    }
    
    // Prompt the user to check if a number is prime or to generate prime numbers
    private static int prompt(Scanner scanner) {
    	int input;
    	do {
    		System.out.println("1: Check if a number is prime.\n2: Generate prime numbers.");
    		input = scanner.nextInt();
    		scanner.nextLine();
    		if (input > 2 || input < 1) {
    			System.out.println("Please enter a '1' or '2'.");
    		}
    	}while(input > 2 || input < 1);
		return input;
    }
    
    // Get input from the user
    private static int getPositiveInteger (Scanner scanner) {
    	int number;
    	do {
    		number = scanner.nextInt();
    		scanner.nextLine();
    		if (number < 0) {
    			System.out.println("Enter a whole number greater than 0.");
    		}
    	} while (number < 0);
    	return number;
    }
    
    // Check whether the number is prime or not
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Generate prime numbers up to the parameterized limit
    private static void generatePrime(int limit) {
    	int primeNumber = 2;
    	while (primeNumber < limit) {
			if (isPrime(primeNumber)) {
			    System.out.println(primeNumber);
			}
			primeNumber ++;
    	}
    }

}
