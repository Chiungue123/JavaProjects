package com.javaminiprojects.reservationmanager.model;
import java.util.LinkedHashSet;

public class Reservation {
	private Customer mainCustomer;
	private int guests;
	private String day;
	private String reservationTime;
	private String table;
	

	public Reservation(Customer mainCustomer, int guests, String day, String reservationTime, String table) {
	    this.mainCustomer = mainCustomer;
	    this.guests = guests;
	    this.day = day;
	    this.reservationTime = reservationTime;
	    this.table = table;
	}
	
	// Getters
	public Reservation getReservation(LinkedHashSet<Reservation> reservations, String table) {
		for (Reservation r : reservations) {
			if (r.table.equals(table)) {
				Reservation reservation = r;
				return reservation;
			}
		}
		System.out.println("Returning null\nNo reservation found for table number: " + table);
		return null;
	}
	
	public int getReservationSize(Reservation reservation) {
		return reservation.guests + 1;
	}
	
	public String getReservationTime(Reservation reservation) {
		return reservation.reservationTime;
	}
	
	public String getReservationTableNumber(Reservation reservation) {
		return reservation.table;
	}
	
	public Customer getMainCustomer(Reservation reservation) {
		return reservation.mainCustomer;
	}

	public String getReservationDay() {
		return day;
	}

	public void setReservationDay(String day) {
		this.day = day;
	}
}