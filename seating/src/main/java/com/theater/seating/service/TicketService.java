package com.theater.seating.service;

import com.theater.seating.domain.Ticket;

public interface TicketService {

	public Ticket bookATicket(String userName,Integer noOfTickets);
	public void showMeTheater();
}
