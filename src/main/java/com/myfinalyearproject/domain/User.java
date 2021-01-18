package com.myfinalyearproject.domain;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import com.sun.prism.Image;

@Entity(name="proj_user")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id", nullable=false)
	private int id;
	

	@Lob 
	@Basic(fetch=FetchType.LAZY)
	@Column(name="photo", columnDefinition="BLOB NOT NULL",length=16777217)
	protected byte[] photo;
	
	@Column(name="paymentId", nullable=false)
	private String paymentId;
	
	@Column(name="password", nullable=false)
	private String password;
	
	private String password2;
	@Column(name="firstname", nullable=false)
	private String firstname;
	@Column(name="lastname", nullable=false)
	private String lastname;
	@Column(name="birthdate", nullable=false)
	private Date birthdate;
	@Column(name="phonenumber", nullable=false)
	private String phonenumber;
//	@Column(name="UserPhoto", nullable=true)
//	private Image photo;
	@Column(unique=true, name="Email", nullable=false)
	private String email;
	
	@Transient
	private MultipartFile file;
	
	
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
	public void setPhoto(MultipartFile file) throws IOException {
		this.photo = file.getBytes();
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getpassword2() {
		return password2;
	}
	public void setpassword2(String password2) {
		this.password2 = password2;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getbirthdate() {
		return birthdate;
	}
	public void setbirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getphonenumber() {
		return phonenumber;
	}
	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
//	public Image getPhoto() {
//		return photo;
//	}
//	public void setPhoto(Image photo) {
//		this.photo = photo;
//	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	
	public User() {
		
	}
	
	
	public User(String paymentId, String password, String password2, String firstname, String lastname,
			Date birthdate, String phonenumber, String email) {
		super();
		this.paymentId = paymentId;
		this.password = password;
		this.password2 = password2;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", paymentId=" + paymentId + ", password=" + password + ", password2=" + password2
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", phonenumber="
				+ phonenumber + ", email=" + email + ", photo=" + Arrays.toString(photo) + "]";
	}
}

