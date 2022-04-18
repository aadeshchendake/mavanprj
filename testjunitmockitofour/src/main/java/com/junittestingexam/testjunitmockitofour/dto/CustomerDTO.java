package com.junittestingexam.testjunitmockitofour.dto;

import com.junittestingexam.testjunitmockitofour.entity.Cart;

public class CustomerDTO {
	private Long customerId;
	
	private String customerName;
	
	private String customerEmail;
	
	private Cart cart;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", cart=" + cart + "]";
	}

	

	
	
	
	
}
