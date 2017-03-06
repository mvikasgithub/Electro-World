package com.niitbejai.electroworldBE.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * Here there is an option to specify the entity name. If we are not specifying the entity name, then
 * by default the class name ('Product' in this case ) will be the entity name.
 */

@Entity
public class Product {
	
	/*
	 * private fields for category
	 */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty 
	@Size(min=3, max=10) 
	private String code; // code can be alphanumeric
	
	@NotNull
	private int categoryid;
	
	@NotEmpty
	private String quantity;
	@NotEmpty
	private String suppliercode;
	@NotEmpty
	private String imageURL;
	private boolean active = true;
	private boolean inStock = false;
	
	// will be useful in debugging
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", categoryid=" + categoryid + ", quantity=" + quantity
				+ ", suppliercode=" + suppliercode + ", imageURL=" + imageURL + ", active=" + active + ", inStock="
				+ inStock + "]";
	
	
	/*
	 * Getters and Setters
	 */
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSuppliercode() {
		return suppliercode;
	}
	public void setSuppliercode(String suppliercode) {
		this.suppliercode = suppliercode;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	
	

}
