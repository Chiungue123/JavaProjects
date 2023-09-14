package com.javaminiprojects.reservationmanager.model;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class Reservation {
	private Customer mainCustomer;
	private int groupSize;
	private LocalDateTime reservationTime;
	private int tableNumber;
	

	public Reservation(Customer mainCustomer, int groupSize, LocalDateTime reservationTime, int tableNumber) {
	    this.mainCustomer = mainCustomer;
	    this.groupSize = groupSize;
	    this.reservationTime = reservationTime;
	    this.tableNumber = tableNumber;
	}
	
	// Getters
	public Reservation getReservation(LinkedHashSet<Reservation> reservations, int tableNumber) {
		for (Reservation r : reservations) {
			if (r.tableNumber == tableNumber) {
				Reservation reservation = r;
				return reservation;
			}
		}
		System.out.println("Returning null\nNo reservation found for table number: " + tableNumber);
		return null;
	}
	
	public int getReservationSize(Reservation reservation) {
		return reservation.groupSize;
	}
	
	public LocalDateTime getReservationTime(Reservation reservation) {
		return reservation.reservationTime;
	}
	
	public int getReservationTableNumber(Reservation reservation) {
		return reservation.tableNumber;
	}
	
	public Customer getMainCustomer(Reservation reservation) {
		return reservation.mainCustomer;
	}
}