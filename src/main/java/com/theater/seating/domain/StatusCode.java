package com.theater.seating.domain;

public enum StatusCode {
	T99(99,"SUCESS"),
	
	T1(1,"THEATER_INIT_ERROR"),
	T2(2,"THEATER_CLOSED"),
	T3(3,"NO_TICKETS"),
	T4(4,"NEED_TO_SPLIT");
	
	
	private Integer code;
	private String description;
	
	private StatusCode(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
