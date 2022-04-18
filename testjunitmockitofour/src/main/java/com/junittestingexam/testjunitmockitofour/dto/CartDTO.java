package com.junittestingexam.testjunitmockitofour.dto;

import com.junittestingexam.testjunitmockitofour.entity.Restrorent;

public class CartDTO {
	private Long cartId;
	
	private Restrorent restrorent;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Restrorent getRestrorent() {
		return restrorent;
	}

	public void setRestrorent(Restrorent restrorent) {
		this.restrorent = restrorent;
	}

	
	
	
}
