package com.theater.seating.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Theater {

	private List<Row> rows = new ArrayList<Row>();
	private Integer maxRowId = 0;
	private String SEAT_EMPTY = "[_]";
	private String SEAT_TAKEN = "[x]";
	private String EMPTY_SPACE = "   ";
	private List<Ticket> tickets = new ArrayList<Ticket>();

	public List<Ticket> getTickets() {
		return tickets;
	}

	public List<Row> getRows() {
		return rows;
	}

	public Integer getMaxRowId() {
		return maxRowId;
	}

	public Row addRow() {
		Row row = new Row(maxRowId + 1);
		rows.add(row);
		maxRowId++;
		return row;
	}

	public void add(Integer maxRows, Integer maxSections) {
		if (maxRows > 0 && maxSections > 0) {
			maxRowId = maxRows + maxRowId;
			IntStream.range(0, maxRows).mapToObj(i -> addRow()).forEach(r -> {
				IntStream.range(0, maxSections).mapToObj(i -> r.addSection());
			});
		}
	}

	public Integer getMaxWidth() {
		Integer max = 0;
		for (Row row : rows) {
			Integer sum = 0;
			for (Section section : row.getSections()) {
				sum = sum + section.getSeats().size() + 1;
			}
			sum--;
			if (sum > max)
				max = sum;
		}
		return max;
	}

	public Integer getTotalSeats() {
		Integer sum = 0;
		for (Row row : rows) {
			for (Section section : row.getSections()) {
				sum = sum + section.getSeats().size();
			}
		}
		return sum;
	}

	public Integer getOpenSeats() {
		Integer sum = 0;
		for (Row row : rows) {
			for (Section section : row.getSections()) {
				for (Seat seat : section.getSeats()) {
					if (!seat.getTaken()) {
						sum = sum + 1;
					}
				}
			}
		}
		return sum;
	}

	public Boolean isEmpty() {
		return getOpenSeats() == 0 ? true : false;
	}

	public Ticket getTicket(String userName) {
		for (Ticket ticket : tickets) {
			if (ticket.getUserName().equals(userName)) {
				return ticket;
			}
		}
		return null;
	}

	public synchronized void confirmTicket(Ticket ticket) {
		ticket.getSeats().forEach( s -> s.setTaken(true));
		tickets.add(ticket);
		ticket.setStatus(StatusCode.T99);
	}

	public void print() {
		Integer gridSize = getMaxWidth();
		int screanStart = (gridSize * 3 - 16) / 2;
		System.out.println();
		if (screanStart > 0)
			IntStream.range(0, (gridSize * 3 - 20) / 2).forEach(i -> System.out.print(" "));
		System.out.println("=======SCREEN=======");
		System.out.println();
		rows.forEach(r -> {
			Integer spaces = r.getSections().size() - 1;
			Integer seats = r.seatCount();
			Integer start = ((gridSize) - (spaces + seats)) / 2;
			IntStream.range(0, start).forEach(i -> System.out.print(EMPTY_SPACE));
			r.getSections().forEach(s -> {
				s.getSeats().forEach(seat -> {
					if (seat.getTaken()) {
						System.out.print(SEAT_TAKEN);
					} else {
						System.out.print(SEAT_EMPTY);
					}
				});
				System.out.print(EMPTY_SPACE);

			});
			System.out.println();

		});
	}
}
