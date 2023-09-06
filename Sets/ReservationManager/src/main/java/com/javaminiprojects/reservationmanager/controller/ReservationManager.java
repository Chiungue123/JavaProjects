package com.javaminiprojects.reservationmanager.controller;

import java.util.*;

import com.javaminiprojects.reservationmanager.model.Customer;

public class ReservationManager {
	private static boolean running = true;
	private static String input;

	public static void main(String[] args) {
		// Define LinkedHashSet for waiting list and reservations
		Set<Customer> reservations = new LinkedHashSet<>();
		Set<Customer> waitlist = new LinkedHashSet<>();
		
		// Define variables for validating user input
		boolean valid = false;
		Scanner scanner = new Scanner(System.in);

		while(running) {
			do {
				valid = true;
				System.out.println("========== Menu ==========");
				System.out.println("1: View Reservations\n2: Book a Reservation\n3: Edit Reservations\n4: Exit");
				input = scanner.nextLine();
				if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
					valid = true;
				} else {
					System.out.println("Please enter a number between 1 and 4.");
					clearScreen();
				}
			}while(!valid);
			
			switch(input) {
				case "1":
					viewReservations();
					break;
					
				case "2":
					bookReservation();
					break;
					
				case "3":
					editReservations();
					break;
					
				case "4":
					running = false;
					break;
			}
		}
		scanner.close();
		System.out.println("See you next time!");
		System.exit(0);
	}
	
	public static void viewReservations() {
		System.out.println("Viewing Reservations");
		// Print method that creates a neatly formatted table
		// It should represent the available time slots along with the customer details
		// Reservations should be populated in their respective slot in the table 
		clearScreen();
		
	}
	
	public static void bookReservation() {
		System.out.println("Booking Reservations");
		// When a reservation is canceled, automatically offer the spot to the first person on the waiting list.
		clearScreen();
	}
	
	public static void editReservations() {
		System.out.println("Edit Reservations");
		// run viewReservations
		// Prompt user to select reservation id number, followed by a prompt to edit name, number of people and or time
		// Option to remove a reservation
		// Implement a waiting list feature, upon cancellation, automatically offer the spot to the next person on the wait list
		clearScreen();
	}

	public static void clearScreen() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread.sleep() threw an exception.");
			e.printStackTrace();
		}
		for (int i = 0; i < 4; i++) {
		    System.out.println();
		}

	}
}

/*

Title: Restaurant Table Reservation System

Problem Statement:
- Design and implement a system that allows a restaurant to manage table reservations.

Criteria:
- Use a LinkedHashSet to hold the reservations to ensure there are no duplicate reservations and that they are displayed in the order they were added.
- Allow users (restaurant staff) to add, view, and cancel reservations.
- Implement time slots for reservations, and make sure no two reservations can exist for the same table at the same time slot.
- Include the name of the customer, the table number, and the time slot in each reservation.

Bonus Feature:
- Implement a waiting list feature. When a reservation is canceled, automatically offer the spot to the first person on the waiting list. The waiting list should also be implemented using a LinkedHashSet to maintain order.
- Add functionality to import and export the reservation and waiting list data to a JSON or XML file.

*/