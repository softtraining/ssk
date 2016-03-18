package com.scc.softsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "clinic", catalog = "mydb")
public class Clinic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5642790101515442350L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idClinic", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "clinicName", nullable = false)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
