package com.scc.softsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "schedule", catalog = "mydb")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7273054563819561818L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idSchedule", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateStart")
	private Date start;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateEnd")
	private Date end;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
}
