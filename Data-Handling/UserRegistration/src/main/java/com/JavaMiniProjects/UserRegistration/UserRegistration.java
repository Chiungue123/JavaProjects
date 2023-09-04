package com.JavaMiniProjects.UserRegistration;

import java.util.Scanner;
import java.util.ArrayList;

public class UserRegistration {
	// List of users
	private static ArrayList<User> users = new ArrayList<>();

	// Method to view users
	public static void view() {
		System.out.println("Users: \n");
		for (User user : users) {
			System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail() + ", Age: " + user.getAge());
		}
	}
	
	// Method to add user
	public static void addUser(Scanner scanner) {
		String name;
		String email;
		int age;
		
		do {
			System.out.println("Name: ");
			name = scanner.nextLine();
			System.out.println("Email: ");
			email = scanner.nextLine();
			System.out.println("Age: ");
			age = scanner.nextInt();
	    	scanner.nextLine();
	    } while(name != "" || email != "" || age != 0);
		
		User user = new User(name, email, age);
		users.add(user);
		System.out.println("User added");
	}
	
	// Method to remove user
	public static void removeUser(Scanner scanner) {
		System.out.println("");
		System.out.println("Name: ");
		String name = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Age: ");
		int age = scanner.nextInt();
    	scanner.nextLine();
		for (User user : users) {
			if(name.equals(user.getName()) && email.equals(user.getEmail()) && age == user.getAge()){
				System.out.println("Removing user " + user);
				users.remove(user);
				break;
			}
			else {
				System.out.println("not found");
			}
		}
	}
	
	public static void main ( String[] args )
	{
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
	    while(loop) {
	    	System.out.println("1: Add User\n2: Remove User\n3: View User\n4: Exit");
	    	int input = scanner.nextInt();
	    	scanner.nextLine();
	    	if(input == 1) {
	    		// Add User
	    		addUser(scanner);
	    	}
	    	else if (input == 2) {
	    		// Remove User
	        	removeUser(scanner);
	    	}
			else if (input == 3) {
				// View User
				view();
	    	}
			else if (input == 4) {
				// Exit
				loop = false;
	    	}
			else {
				continue;
			}
	    }
	    scanner.close();
	}
}