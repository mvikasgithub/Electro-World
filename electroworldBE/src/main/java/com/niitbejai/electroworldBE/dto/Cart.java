package com.niitbejai.electroworldBE.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cart implements Serializable 
{
	private static final long serialVersionUID = -7122125179605249088L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userid;
	private int totalitems;
	private int totalvalueofitems;
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", totalitems=" + totalitems + ", totalvalueofitems="
				+ totalvalueofitems + "]";
	}	
	
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
	public int getTotalvalueofitems() {
		return totalvalueofitems;
	}
	public void setTotalvalueofitems(int totalvalueofitems) {
		this.totalvalueofitems = totalvalueofitems;
	}

}
