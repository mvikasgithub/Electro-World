package com.niitbejai.electroworldBE.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User 
{
	
	/*
	 * private fields for category
	 */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String password;	
	@NotEmpty
	private String fname;
	@NotEmpty
	private String sname;
	@NotEmpty
	private String email;
	@NotEmpty
	private String billingaddress;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String zip;
	@NotEmpty
	@NotNull
	private String phoneno;
	private boolean active = true;
	
	/* 
	 * Getters and Setters and toString
	 */
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", fname=" + fname + ", sname=" + sname + ", email="
				+ email + ", billingaddress=" + billingaddress + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", phoneno=" + phoneno + ", active=" + active + "]";
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	


}
