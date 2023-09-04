package com.JavaMiniProjects.FibonacciSeriesGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSeriesGenerator {
    public static void main( String[] args ) {
    	// Initializing Array and Scanner
    	Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> fibSeries = new ArrayList<Integer>();
        fibSeries.add(0);
		fibSeries.add(1);
		
		// Get input from user
		int n;
		do {
			System.out.println("Enter a maximum value for a Fibonacci Series: ");
	        n = scanner.nextInt();
	        scanner.nextLine();
	        if (n < 0) {
	            System.out.println("Number must be non-negative. Please try again.");
	        } 
        } while (n < 0);
 
        // Calculating Fibonacci Series
        int nextInt;
		for (int i = 2; i < n; i++) {
			nextInt = fibSeries.get(i-2) + fibSeries.get(i-1);
			if (n >= nextInt) {
				fibSeries.add(nextInt);
				nextInt = 0;
			}
			else {
				break;
			}
		}
		
		// Displaying Fibonacci Series
		System.out.println("Series: " + fibSeries);
        scanner.close();
    }
}