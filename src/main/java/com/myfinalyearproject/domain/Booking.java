package com.myfinalyearproject.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="proj_booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="productid", nullable=false)
	private int productid;
	
	@Column(name="renterid", nullable=false)
	private int renterid;
	
	@Column(name="startdate", nullable=false)
	private Date startdate;
	
	@Column(name="enddate", nullable=false)
	private Date enddate;
	
	@Column(name="cost", nullable=false)
	private int cost;
	
	@Column(name="accepted")
	private Integer accepted;

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}
	
	public int confirmed() {
		if(accepted == null) {
			return 0;
		}
		else return 1;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getRenterid() {
		return renterid;
	}

	public void setRenterid(int renterid) {
		this.renterid = renterid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Booking(int id, int productid, int renterid, Date startdate, Date enddate, int cost,Integer accepted) {
		super();
		this.id = id;
		this.productid = productid;
		this.renterid = renterid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.cost = cost;
		this.accepted = accepted;
	}
	public Booking() {
		
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", productid=" + productid + ", renterid=" + renterid + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", cost=" + cost + "]";
	}
	
}
