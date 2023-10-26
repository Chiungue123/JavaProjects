package com.javaprojects.autowireddemo.bean;

public class Order {
	
	int orderID;
	String timeStamp;
	int amount;
	
	public Order(){
		System.out.println("Order Initialized");
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", timeStamp=" + timeStamp + ", amount=" + amount + "]";
	}
	
}
