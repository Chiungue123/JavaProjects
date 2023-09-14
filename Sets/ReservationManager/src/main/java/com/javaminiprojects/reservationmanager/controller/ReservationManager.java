package com.javaminiprojects.reservationmanager.controller;

import java.util.*;

import com.javaminiprojects.reservationmanager.model.Reservation;

/*
 * WIP
 * 	- Changed DAYS, TABLES & SLOTS into String Arrays, adding more detail for the View Recipe function
 * 	- View Reservations function is functional & formatted
 *  - 
 */

public class ReservationManager {
	private static boolean running = true;
	private static String input;
	
	// Define data structure dimensions for calendar
	final static String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	final static String [] TABLES = {"A", "B", "C"};
	final static String[] SLOTS = {"2-4", "4-6", "6-8", "8-10"};

	public static void main(String[] args) {
		// Define LinkedHashSet for waiting list and reservations
		Set<Reservation> waitlist = new LinkedHashSet<>();
		
		@SuppressWarnings("unchecked")
		Map<Boolean, Reservation>[][][] calendar = new Map[DAYS.length][TABLES.length][SLOTS.length];

		
		// Define variables for validating user input
		boolean valid = false;
		Scanner scanner = new Scanner(System.in);

		while (running) {
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
					viewReservations(calendar);
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
	
	public static void viewReservations(Map<Boolean, Reservation>[][][] calendar) {
		System.out.println("Viewing Reservations");
		//if (calendar.containsKey(true)) {
		//	System.out.println("No reservations are scheduled at the moment.");
		//	clearScreen();
		//} else {
			for (int day = 0; day < (DAYS.length); day++) {
				System.out.println("================================= " + (DAYS[day].toUpperCase()) + " ==================================");
			    for (int table = 0; table < (TABLES.length); table++) {
			    	System.out.print("Table: " + (TABLES[table]));
			    	
			        for (int slot = 0; slot < (SLOTS.length); slot++) {
			        	if (calendar[day][table][slot] == null) {
			        		System.out.print("\t" + SLOTS[slot] + ": Empty"); 
			        	}
			        	else {
			        		System.out.print("\t" + SLOTS[slot] + ": Booked");
			        	}
			        	 
			        }
			        System.out.println();
			    }
			    System.out.println();
			}
		//}
		// Print method that creates a neatly formatted table
		// It should represent the available time slots along with the customer details
		// Reservations should be populated in their respective slot in the table 
		// clearScreen();
		
	}
	
	/*public static void hasReservations(Map<Boolean, Reservation>[][][] calendar) {
		boolean hasReservations = false;
		for (int day = 0; day < DAYS; day++) {
			System.out.println("Day: " + (day + 1));
		    for (int slot = 0; slot < SLOTS; slot++) {
		    	System.out.println("Slot: " + (slot + 1));
		        for (int table = 0; table < TABLES; table++) {
		        	if (calendar[day][slot][table]) 
	}*/
	
	public static void bookReservation() {
		System.out.println("Booking Reservations");
		
		clearScreen();
	}
	
	public static void editReservations() {
		System.out.println("Edit Reservations");
		// run viewReservations
		// Prompt user to select reservation id number, followed by a prompt to edit name, number of people and or time
		// Option to remove a reservation
		// Implement a waiting list feature
		// When a reservation is canceled, automatically offer the spot to the first person on the waiting list.
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