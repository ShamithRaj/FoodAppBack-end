package com.cl.foodapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String status;
	private double totalPrice;
	private String orderCreatedTime;
	private String orderDeliveryTime;
	private String customerName;
	private String contactNumber;
	
	@ManyToOne
	@JoinColumn
	private Staff staff;
	@OneToMany(mappedBy = "foodorder",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Item> item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public void setOrderCreatedTime(String orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}

	public String getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public void setOrderDeliveryTime(String orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public FoodOrder(int id, String status, double totalPrice, String orderCreatedTime, String orderDeliveryTime,
			String customerName, String contactNumber, Staff staff) {
		super();
		this.id = id;
		this.status = status;
		this.totalPrice = totalPrice;
		this.orderCreatedTime = orderCreatedTime;
		this.orderDeliveryTime = orderDeliveryTime;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.staff = staff;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public FoodOrder() {
	}

	

}
