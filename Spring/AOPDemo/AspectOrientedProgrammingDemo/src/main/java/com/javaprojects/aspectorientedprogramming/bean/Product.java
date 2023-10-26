package com.javaprojects.aspectorientedprogramming.bean;

public class Product {

	int id;
	String name;
	int price;
	String brand;
	int stock;
	boolean canBuy;

	Product(){
		System.out.println("Product initialized");
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", stock=" + stock + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean canBuy() {
		return canBuy;
	}
	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}
	
	public void purchaseProduct(String deliveryLocation, String deliveryTime, String userEmail) {
		System.out.println("PRODUCT: Validating Stock...");
		
		// 1. Validate Stock: Pre-processing
		if (canBuy) {
			
			// 2. Perform Business Logic
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			System.out.println("PRODUCT: Beginning Transaction for " + name + ", Price: " + price);
			System.out.println("PRODUCT: Order Conformed for " + userEmail);
			System.out.println();
			
		} else {
			System.out.println("Out of stock, try again later");
		}	
	}
	
}