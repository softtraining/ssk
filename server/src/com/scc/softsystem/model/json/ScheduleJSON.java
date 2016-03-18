package com.scc.softsystem.model.json;

import java.util.Date;

public class ScheduleJSON {
	private Integer id;
	private Date start;
	private Date end;
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
