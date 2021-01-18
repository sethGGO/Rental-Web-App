package com.myfinalyearproject.domain;

import java.io.IOException;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

@Entity(name="proj_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="lister", nullable=false)
	private String lister;
	
	public String getLister() {
		return lister;
	}

	public void setLister(String lister) {
		this.lister = lister;
	}
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@Column(name="available", nullable=false)
	private int available;

	@Lob 
	@Basic(fetch=FetchType.LAZY)
	@Column(name="photo", columnDefinition="BLOB NOT NULL",length=16777217)
	protected byte[] photo;
	
	public int getId() {
		return id;
	}
	@Transient
	private MultipartFile file;
	@Transient
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public byte[] getPhoto() {
		return photo;
	}
	@Transient
private String base64; //Variable to store the conversion of a data byte type to String

@Transient //Annotation so it does not persist in the database
public String getBase64() {
    //Convert the data type byte to String, store it in the variable and return it
    return this.base64 = Base64.encodeBase64String(this.photo); 
}

public void setBase64(String base64) {
    this.base64 = base64;
}
	public void setPhoto(MultipartFile file) throws IOException {
		this.photo = file.getBytes();
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", lister=" + lister + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", photo=" + Arrays.toString(photo) + "]";
	}

	public Product(String lister, String name, String description, int price) {
		super();
		this.lister = lister;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product() {
		
	}

	
}
