package com.junittestingexam.testjunitmockitofour.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.junittestingexam.testjunitmockitofour.dto.CartDTO;
import com.junittestingexam.testjunitmockitofour.entity.Cart;

@Component
public class CartMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Cart toCartEntity(CartDTO cartDTO) {
		return modelMapper.map(cartDTO, Cart.class);
	}
	
	public CartDTO toCartDTO(Cart cart) {
		return modelMapper.map(cart, CartDTO.class);
	}
}

