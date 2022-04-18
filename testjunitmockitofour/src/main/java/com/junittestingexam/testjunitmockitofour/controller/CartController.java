package com.junittestingexam.testjunitmockitofour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junittestingexam.testjunitmockitofour.entity.Cart;
import com.junittestingexam.testjunitmockitofour.entity.Customer;
import com.junittestingexam.testjunitmockitofour.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController  {
	@Autowired
	private CartService cartServ;
	
	@PostMapping("/createCall")
	public Cart createCall(@RequestBody Cart cart) {
		return cartServ.createCall(cart);
	}
	
	
	@PutMapping("/putCall")
	public Cart putCall(@RequestBody Cart cart) {
		return cartServ.putCall(cart);
	}
	
	@GetMapping("/getCall")
	public List<Cart> getCall(){
		return cartServ.getCall();
	}

	@DeleteMapping("/deleteCall")
	public String deleteCall(@RequestBody Cart cart) {
		cartServ.deleteCall(cart);
		return "Deleted!";
	}
}
