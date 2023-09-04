package com.JavaMiniProjects.InventoryManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {
	static ArrayList<Item> inventory = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean on = true;
		
		while (on) {
			int prompt;
			do {
				System.out.println("1: New Item\n2: View Inventory\n3: Edit Inventory\n4: Exit");
				prompt = scanner.nextInt();
				scanner.nextLine();
			} while (prompt > 4 && prompt < 1);
			
			if (prompt == 1) {
				newItem(scanner);
			}
			else if (prompt == 2) {
				viewInventory();
			}
			else if (prompt == 3) {
				editInventory(scanner);
			}
			else if (prompt == 4) {
				System.out.println("Exit");
				on = false;
			}
			else {
				System.out.println("Unknown input: " + prompt);
			}
		}
		scanner.close();
	}
	
	public static void newItem(Scanner scanner) {
		System.out.println("Item Name: ");
		String name = scanner.nextLine();
		System.out.println("Quantity: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();
		int index = inventory.size() + 1;
		Item newItem = new Item(index ,name, quantity);
		inventory.add(newItem);
	}
	
	public static void viewInventory() {
		if (inventory.size() != 0) {
			String[] headers = {"Product Id", "Item", "Quantity"};
			System.out.println();
			System.out.printf("%15s %10s %15s", headers[0], headers[1], headers[2]);
			System.out.println();
			
			for (Item item : inventory) {
				System.out.printf("%10s", item.getId() , item.getName(), item.getQuantity());
			}
			System.out.println();
		}
		else {
			System.out.println("You have no items!");
			System.out.println();
		}
		
	}
		
	public static void editInventory(Scanner scanner) {
		viewInventory();
		System.out.println("Product Id to edit: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		for (Item item : inventory) {
			if(id == item.getId()) {
				System.out.println("Product found with id: " + id + "\nName: " + item.getName() + "\nQuantity: " + item.getQuantity());
			}
		}
	}
}