package com.theater.seating.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.theater.seating.domain.Row;
import com.theater.seating.domain.Seat;
import com.theater.seating.domain.Section;
import com.theater.seating.domain.StatusCode;
import com.theater.seating.domain.Theater;
import com.theater.seating.domain.Ticket;

public class TicketServiceImpl implements TicketService{

	private Theater theater;
	private static TicketServiceImpl ticketServiceImpl;
	
	public synchronized static TicketServiceImpl startTheater(List<String> args, Boolean resetTheater) {
		if (ticketServiceImpl == null) {
			return new TicketServiceImpl(init(args));
		} else {
			if (resetTheater)
				return new TicketServiceImpl(init(args));
			else
				return ticketServiceImpl;
		}
	}
	
	private static Theater init(List<String> args) {
		Theater theater = new Theater();
		try {

			for (String arg : args) {
				Row r = theater.addRow();
				String[] sections = arg.split(" ");
				Arrays.asList(sections).forEach(n -> r.addSection(Integer.parseInt(n)));
			}
		} catch (Exception e) {
			throw new RuntimeException("Theater CLOSED");
		}
		return theater;
	}
	
	private TicketServiceImpl(Theater theater) {
		super();
		if(theater.getTotalSeats()>0 && theater.getOpenSeats()>0)
			this.theater = theater;
		else
			throw new RuntimeException("Theater CLOSED");
	}

	@Override
	public synchronized Ticket bookATicket(String userName, Integer noOfTickets) {
		Ticket ticket = new Ticket(userName, new Date());

		for (Row row : theater.getRows()) {
			for (Section section : row.getSections()) {
				List<Seat> openSeats = new ArrayList<Seat>();
				for (Seat seat : section.getSeats()) {
					if (!seat.getTaken()) {
						openSeats.add(seat);
					}
				}
				if (openSeats.size() >= noOfTickets) {
					ticket.setSeats(openSeats.stream().limit(noOfTickets).collect(Collectors.toList()));
					theater.confirmTicket(ticket);
					return ticket;
				}
			}
		}

		if (noOfTickets < theater.getOpenSeats()) {
			ticket.setStatus(StatusCode.T4);
		} else {
			ticket.setStatus(StatusCode.T3);
		}

		return ticket;
	}
	
	public void showMeTheater() {
		theater.print();
	}
	
}
