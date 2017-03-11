package com.niitbejai.electroworldBE.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name="UserOrder")
public class Order implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8044554779286575462L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private int userid;
	private int totalitems;
	private int totalvalue;
	private String billingaddress;
	private String shippingaddress;
	
	
	/*
	 * Getters and Setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTotalitems() {
		return totalitems;
	}
	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	public String getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
