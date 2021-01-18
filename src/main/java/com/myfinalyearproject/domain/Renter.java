package com.myfinalyearproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="proj_renter")
public class Renter {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id", nullable=false)
	private int id;
	
	@OneToOne(optional=false)
	  @JoinColumn(name="user", nullable=false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Renter(int id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Renter [id=" + id + ", user=" + user + "]";
	}

}
