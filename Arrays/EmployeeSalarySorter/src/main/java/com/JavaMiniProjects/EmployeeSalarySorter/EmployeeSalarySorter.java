package com.JavaMiniProjects.EmployeeSalarySorter;

import java.util.Random;

public class EmployeeSalarySorter {

	public static void main(String[] args) {
		// Create an array to store employee salaries
		int[] salaries = new int[10];
		Random random = new Random();
		
		// Defining our salary ranges
		int minSalary = 10000;
		int maxSalary = 50000;
		
		// Populate the array with random values
		for (int i = 0; i < salaries.length; i++) {
			salaries[i] = random.nextInt(maxSalary - minSalary + 1) + minSalary;
		}
		
		System.out.println("Before sorting: ");
		for (int i = 0; i < salaries.length; i++) {
			System.out.print(salaries[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		// Sort the array in ascending order using bubble sort
		boolean notSorted = true;
		for (int y = 0; y < salaries.length-1; y++) {
			if(notSorted) {
				notSorted = false;
				for (int i = 1; i < salaries.length; i++) {
					if (salaries[i-1] > salaries[i]) {
						int bigger = salaries[i-1]; // Bigger value is assigned to a variable
						salaries[i-1] = salaries[i]; // Smaller value is assigned to the previous iteration
						salaries[i] = bigger; // Bigger variable is assigned to the current iteration
						notSorted = true;
					}
				}
			}
			else {
				break;
			}
		}
		
		// Display the sorted array of salaries
		System.out.println("After sorting: ");
		for (int i = 0; i < salaries.length; i++) {
			System.out.print(salaries[i] + " ");
		}
	}
}
