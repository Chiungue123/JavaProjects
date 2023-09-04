package com.JavaMiniProjects.FrequencyCounter;

import java.util.Random;

public class FrequencyCounter {

	public static void main(String[] args) {
		Random random = new Random();
		
		// Create an array to hold a sequence of random numbers
		int[] numbers = new int[10]; // Stores the array of numbers
		int[] counter = new int[10]; // Count the frequency of each number
		
		System.out.println();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10) + 0;
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		// Record the occurrence of each number
		for (int number: numbers) {
			counter[number] ++;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Number: " + i + ", Count: " + counter[i]);
		}
		
		// Print the most frequent number & its frequency
		int mostFrequent = -1;
		int number = 0;
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] > mostFrequent) {
				mostFrequent = counter[i];
				System.out.println("Count = " + mostFrequent);
			}
		}
		//System.out.println("Most Frequent Occourence: " + mostFrequent);
		// System.out.println("Frequency: " + highest);
	}

}

/*
Requirements:
Create an array to store a series of numbers.
Find the number that appears most frequently in the array.
Print the most frequent number and its frequency.
*/