package com.niitbejai.electroworldBE.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/*
 * Here there is an option to specify the entity name. If we are not specifying the entity name, then
 * by default the class name ('Product' in this case ) will be the entity name.
 */

@Component
@Entity
public class Product implements Serializable 
{
	
	private static final long serialVersionUID = 3815550983024238320L;
	
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
	@Transient
	private MultipartFile imagempfile;
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@NotEmpty
	private int Price;
	
	/*
	 * To strong function
	 */
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", categoryid=" + categoryid + ", quantity=" + quantity
				+ ", suppliercode=" + suppliercode + ", imageURL=" + imageURL + ", active=" + active + ", inStock="
				+ inStock + ", imagempfile=" + imagempfile + ", name=" + name + ", description=" + description
				+ ", Price=" + Price + "]";
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

	public MultipartFile getImagempfile() {
		return imagempfile;
	}

	public void setImagempfile(MultipartFile imagempfile) {
		this.imagempfile = imagempfile;
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
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}
	
	
	
	

}
