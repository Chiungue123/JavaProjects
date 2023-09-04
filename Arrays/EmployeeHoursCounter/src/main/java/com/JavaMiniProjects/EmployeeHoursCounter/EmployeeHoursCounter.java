package com.JavaMiniProjects.EmployeeHoursCounter;

import java.util.Random;

public class EmployeeHoursCounter {

	public static void main(String[] args) {
		// Defining the variables and arrays for the 2D array
		Random random = new Random();
		String[] employees = {"George", "Jane", "Bob", "Isabella", "Requis", "Susan"};
		String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
		int[][] list = new int[employees.length][days.length];
		
		
		// Printing days of the week
		System.out.printf("%18s", days[0] + "  ");
		for (int x = 1; x < days.length; x++) {
			System.out.print(days[x] + "  ");
		}
		System.out.println();
		
		
		// Generating random hours for each week for employees for display
		for (int i = 0; i < employees.length; i++) {
			System.out.printf("%-14s", employees[i] + ": ");
			for (int j=0; j < days.length; j++) {
				int hours = random.nextInt(10);
				list[i][j] = hours;
				System.out.printf("%-5s" ,hours);
			}
			System.out.println();
		}
		System.out.println();
		
		
		// Add up the total hours of each employee
		System.out.println(" ==== Total Hours ==== ");
		System.out.println();
		int grandTotal = 0;
		for (int i = 0; i < employees.length; i++) {
			System.out.printf("%-15s", employees[i] + ": ");
			int total = 0;
			for (int j = 0; j < days.length; j++) {
				total += list[i][j];
			}
			System.out.println(total + " hours");
			grandTotal += total;
		}
		
		// Print the hourly grand total
		System.out.println();
		System.out.println(" ==== Grand Total ==== ");
		System.out.println();
		System.out.printf("%15s", grandTotal + " hours");
	}

}
