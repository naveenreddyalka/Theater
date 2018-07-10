package com.theater.seating.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {

	private Integer sectionId;
	private Integer rowId;
	private Integer maxSeatId = 0;
	private List<Seat> seats = new ArrayList<Seat>();

	public Section(Integer sectionId, Integer rowId) {
		super();
		this.sectionId = sectionId;
		this.rowId = rowId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public synchronized void addSeat(Integer noOfSeats) {
		for (int i = 0; i < noOfSeats; i++) {
			Seat s = new Seat(maxSeatId + 1, rowId, sectionId);
			this.seats.add(s);
			maxSeatId++;
		}
	}
}
