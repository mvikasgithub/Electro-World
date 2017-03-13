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
@Table(name = "CartItems")
public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 980537677398532164L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userid;
	private int cartid;
	private int productid;
	private int quantity;
	private int unitprice;
	private int totalprice;

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", userid=" + userid + ", cartid=" + cartid + ", productid=" + productid
				+ ", quantity=" + quantity + ", unitprice=" + unitprice + ", totalprice=" + totalprice + "]";
	}

	/*
	 * Setters and Getters
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

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
