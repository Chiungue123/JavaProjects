package com.javaminiprojects.reservationmanager.controller;

import java.util.*;

import com.javaminiprojects.reservationmanager.model.Customer;
import com.javaminiprojects.reservationmanager.model.Reservation;

/*
 * Work in Progress
 * 	- function viewCalendar is working well
 * 	- createReservation logic is underway
 * 
 * Next Steps
 * 	- Deciding wether to use String or int for table datatype
 * 	- Still need to initialize the calendar coordintate before adding the reservation
 * 
 * Work in Progress
 * 	- Decided to use integers for table values as I can use them as coordinates for the selected reservation spot
 * 	- Create Reservation doesn't trigger errors, however it doesn't reflect on the viewReservations
 * 		- The conditional logic should render 'Booked' when reserved and 'Open' if no reserations exist for that slot
 * 		- To trouble shoot, print out the reservation object as well as the coordinates where the key/value pair should be
 * 		- This will determine wether the values are not being sent or if the conditional logic isn't correct, should be one or the other
 */

public class ReservationManager {
	private static boolean running = true;
	private static String input;
	
	// Define data structure dimensions for calendar
	final static String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	final static int [] TABLES = {1, 2, 3};
	final static String[] SLOTS = {"2-4", "4-6", "6-8", "8-10"};
	final static Boolean isAvailable = true;

	public static void main(String[] args) {
		// Define LinkedHashSet for waiting list and reservations
		//Set<Reservation> waitlist = new LinkedHashSet<>();
		
		@SuppressWarnings("unchecked")
		// All Map elements in calendar are objects, therefore they are null by default
		Map<Boolean, Reservation>[][][] calendar = new Map[DAYS.length][SLOTS.length][TABLES.length];

		// Define variables for validating user input
		boolean valid = false;
		Scanner scanner = new Scanner(System.in);

		while (running) {
			do {
				valid = true;
				System.out.println("===== MAIN MENU =====");
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
					viewCalendar(calendar);
					break;
					
				case "2":
					bookReservation(calendar, scanner);
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
	
	public static void viewCalendar(Map<Boolean, Reservation>[][][] calendar) { 
		String header = "|  Slots  |  Table 1  |  Table 2  |  Table 3  |";
		System.out.println("Viewing Reservations");
		/*for (int day = 0; day < (DAYS.length); day++) {
			System.out.println("==================== " + (DAYS[day].toUpperCase()) + " ==================");
			System.out.println(header);
			System.out.println("-----------------------------------------------");
		    for (int slot = 0; slot < (SLOTS.length); slot++) {
		    	//System.out.print("| ");
		    	System.out.printf("%-2s %-5s %2s", "|", SLOTS[slot], "|");
		        for (int table = 0; table < TABLES.length; table++) {
		        	if (calendar[day][slot][table] == null || calendar[day][slot][table].containsKey(isAvailable)) {
		        		System.out.printf("%7s %4s", "Open", "|");
		        	}
		        	else {
		        		System.out.printf("%6 %3", "Booked", "|");
		        	}
		        }
		        System.out.println();
		    }
		    System.out.println("-----------------------------------------------");
		    System.out.println();*/
			System.out.println("==================== SUNDAY ==================");
			for (int table = 0; table < TABLES.length; table++) {
	        	if (calendar[0][0][table] == null || calendar[0][0][table].containsKey(isAvailable)) {
	        		System.out.printf("Table " + (table+1) + ", " + DAYS[0] + ", " + SLOTS[0] + "Status: Open");
	        	}
	        	else {
	        		System.out.printf("Table " + (table+1) + " is booked");
	        	}
	        	
        	System.out.println();
		}
		
			
		// Print method that creates a neatly formatted table
		// It should represent the available time slots along with the customer details
		// Reservations should be populated in their respective slot in the table 
		// clearScreen();
	}
	
	public static void bookReservation(Map<Boolean, Reservation>[][][] calendar, Scanner scanner) {
		// Print out calendar for user to see
		viewCalendar(calendar);
		
		//Prompt user for Reservation Details
		createReservation(calendar, scanner);
		//clearScreen();
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

	public static void createReservation(Map<Boolean, Reservation>[][][] calendar, Scanner scanner) {
		// Collect information from the user to create a Reservation
		
		// First, prompt the user for Reservation day, slot and table //
		System.out.println("========= Booking a Reservation =========");
		System.out.println();
		System.out.println();
		System.out.print("===== Days ===== \nEnter 1 -> Sun \nEnter 2 -> Mon \nEnter 3 -> Tue \nEnter 4 -> Wed \nEnter 5 -> Thu \nEnter 6 -> Fri \nEnter 7 -> Sat \n> ");
		
		int day = scanner.nextInt();
		scanner.nextLine();
		System.out.println();
		System.out.print("== Time Slots ==\nEnter 1 -> 2-4 \nEnter 2 -> 4-6 \nEnter 3 -> 6-8 \nEnter 4 -> 8-10 \n> ");
		
		int slot = scanner.nextInt();
		scanner.nextLine();
		System.out.println();
		System.out.println("=== " + DAYS[day - 1] + " Tables Available for " + SLOTS[slot - 1] + " ===\n");
		
		for(int i = 0; i < TABLES.length; i++) {
			if (calendar[day-1][slot-1][i] == null || calendar[day - 1][slot-1][i].containsKey(!isAvailable)) {
				System.out.println( "Enter " + (i+1) + " -> Table " + TABLES[i]);
			}
		}
		System.out.println("> ");
		int table = scanner.nextInt();
		
		// Second, prompt the user for the Main Customer details and number of guests 
		System.out.println();
		System.out.println("========== Customers Details ==========");
		System.out.println("Main Customer Details\nName: ");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Number of guests: ");
		int guests = scanner.nextInt();
		scanner.nextLine();
		
		
		// Prompt the user to confirm everything before creating the reservation
		System.out.println("===== Confirm Reservation =====");
		System.out.println("Day: " + DAYS[day - 1]);
		//System.out.println("Table: " + table.toUpperCase());
		System.out.println("Time Slot: " + SLOTS[slot - 1]);
		System.out.println("Table Number: " + TABLES[table - 1]);
		System.out.println("Main Customer's Name: " + name);
		System.out.println("Main Customer's Age: " + age);
		System.out.println("Number of guests: " + guests);
		System.out.println("Confirm? Y/N");
		String confirm = scanner.nextLine();
		
		// Create and print the Customer and Reservation object
		if (confirm.equals("Y")) {
			Customer mainCustomer = new Customer(name, age);
			Reservation reservation = new Reservation(mainCustomer, guests, DAYS[day-1], SLOTS[slot-1], table);
			
			// Initializing selected coordinates on calendar
	        calendar[day - 1][slot-1][table-1] = new HashMap<>();
	        calendar[day - 1][slot-1][table-1].put(isAvailable, reservation);
			System.out.println("Reservation Confirmed");
			System.out.println();
			
		}
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