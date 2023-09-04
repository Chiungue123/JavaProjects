package com.JavaMiniProjects.InventoryManagement;

public class Item {
	// Define the properties of an item object
	private int productId;
	private String productName;
	private int quantity;
	
	//
	Item(int productId, String productName, int quantity){
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
	}
	
	// Setters
	public void setId(int id){
		this.productId = id;
	}
	
	public void setName(String name) {
		this.productName = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Getters
	public int getId() {
		return this.productId;
	}
	
	public String getName() {
		return this.productName;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
}
