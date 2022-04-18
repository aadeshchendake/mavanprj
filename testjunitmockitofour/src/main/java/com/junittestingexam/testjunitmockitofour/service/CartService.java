package com.junittestingexam.testjunitmockitofour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junittestingexam.testjunitmockitofour.entity.Cart;
import com.junittestingexam.testjunitmockitofour.repository.CartRepo;

@Service
public class CartService {
  @Autowired
  private CartRepo cartRepo;

public Cart createCall(Cart cart) {
	return cartRepo.save(cart);
}

public Cart putCall(Cart cart) {
	return cartRepo.save(cart);
}

public List<Cart> getCall() {
	return cartRepo.findAll();
}

public void deleteCall(Cart cart) {
	cartRepo.delete(cart);
}
}
