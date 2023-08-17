package com.SangamOne.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_orders")
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int product_order_id;
	private int quantity;
	private int company_id;
	private int house_id;
	private int product_id;
	
	@ManyToOne()
	@JoinColumn(name = "company_id",insertable = false, updatable=false)
	private Company company;
	
	@ManyToOne()
	@JoinColumn(name = "house_id",insertable = false, updatable=false)
	private House house;
	
	@ManyToOne()
	@JoinColumn(name = "product_id",insertable = false, updatable=false)
	private Product product;

	public int getProduct_order_id() {
		return product_order_id;
	}

	public void setProduct_order_id(int product_order_id) {
		this.product_order_id = product_order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
