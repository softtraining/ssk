package com.scc.softsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "user", catalog = "mydb")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9092312469883276488L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "login", unique = true, nullable = false)
	private String login;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "isDoctor")
	private boolean isDoctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_idUser")
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Schedule_idSchedule")
	private Schedule schedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Clinic_idClinic")
	private Clinic clinic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDoctor() {
		return isDoctor;
	}

	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
