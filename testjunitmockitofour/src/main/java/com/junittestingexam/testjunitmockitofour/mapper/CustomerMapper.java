package com.junittestingexam.testjunitmockitofour.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.entity.Customer;

@Component
public class CustomerMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Customer toCustomerEntity(CustomerDTO custDTO) {
		return modelMapper.map(custDTO, Customer.class);
	}
	
	public CustomerDTO toCustomerDTO(Customer cust) {
		return modelMapper.map(cust, CustomerDTO.class);
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
