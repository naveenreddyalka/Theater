package com.theater.seating.domain;

public class Seat {

	private Integer seatId;
	private Integer rowId;
	private Integer sectionId;
	private Boolean taken=false;
	private String userName;
	
	public Seat(Integer seatId, Integer rowId, Integer sectionId) {
		super();
		this.seatId = seatId;
		this.rowId = rowId;
		this.sectionId = sectionId;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	
	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
		result = prime * result + ((seatId == null) ? 0 : seatId.hashCode());
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		if (seatId == null) {
			if (other.seatId != null)
				return false;
		} else if (!seatId.equals(other.seatId))
			return false;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		return true;
	}
	
}
