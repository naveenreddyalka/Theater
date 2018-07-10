package com.theater.seating.domain;

import java.util.Date;
import java.util.List;

public class Ticket {

	private String userName;
	private List<Seat> seats;
	private Date createdDate;
	private StatusCode status;
	
	public Ticket(String userName, Date createdDate) {
		super();
		this.userName = userName;
		this.createdDate = createdDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public StatusCode getStatus() {
		return status;
	}
	public void setStatus(StatusCode status) {
		this.status = status;
	}
	@Override
	public String toString() {
		if(status==StatusCode.T99)
			return userName + ", row=" + seats.get(0).getRowId() + ", section=" + seats.get(0).getSectionId() ;
		else
			return userName + "," + status.getDescription();
	}
}
