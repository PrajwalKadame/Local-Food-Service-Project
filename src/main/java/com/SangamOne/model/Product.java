package com.SangamOne.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int product_id;
	private String product_name;
	private int quantity;
	private int price;
	private String product_desc;
	private String delivery_desc;
	private int company_id;
	private int house_id;
	private String house_number;
	
	@ManyToOne()
	@JoinColumn(name = "company_id",insertable = false, updatable=false)
	private Company company;
	
	@ManyToOne()
	@JoinColumn(name = "house_id",insertable = false, updatable=false)
	private House house;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getDelivery_desc() {
		return delivery_desc;
	}

	public void setDelivery_desc(String delivery_desc) {
		this.delivery_desc = delivery_desc;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	
	

}
