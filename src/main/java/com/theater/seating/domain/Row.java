package com.theater.seating.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {

	private Integer rowId;
	private Integer maxSectionId=0;
	private List<Section> sections = new ArrayList<Section>();

	public Row(Integer rowId) {
		super();
		this.rowId = rowId;
	}

	public List<Section> getSections() {
		return sections;
	}

	public Section addSection() {
		Section section = new Section(maxSectionId+1, rowId);
		this.sections.add(section);
		maxSectionId++;
		return section;
	}
	
	public Section addSection(Integer noOfSeats) {
		Section section = new Section(maxSectionId+1, rowId);
		section.addSeat(noOfSeats);
		this.sections.add(section);
		maxSectionId++;
		return section;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	
	public Integer seatCount() {
		Integer max = 0;
		for (Section section : sections) {
			max = max + section.getSeats().size();
		}
		return max;
	}

}
