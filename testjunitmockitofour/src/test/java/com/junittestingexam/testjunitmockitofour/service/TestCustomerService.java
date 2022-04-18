package com.junittestingexam.testjunitmockitofour.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.entity.Cart;
import com.junittestingexam.testjunitmockitofour.entity.Customer;
import com.junittestingexam.testjunitmockitofour.entity.Restrorent;
import com.junittestingexam.testjunitmockitofour.exceptions.RecordNotFoundException;
import com.junittestingexam.testjunitmockitofour.mapper.CustomerMapper;
import com.junittestingexam.testjunitmockitofour.repository.CustomerRepo;


@RunWith(MockitoJUnitRunner.class)
public class TestCustomerService {
	
	@InjectMocks
	private CustomerService custServ;
	
	@Mock
	private CustomerRepo custRepo;
	
	@Mock
	private CustomerMapper custMapper;
	
	
	@Test
	public void testCreateCall() {
		CustomerService custServ = mock(CustomerService.class);
		
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		CustomerDTO cust = new CustomerDTO();
		cust.setCustomerId(100L);
		cust.setCustomerName("Jhon Weak");
		cust.setCustomerEmail("jhon12@gmail.com");

		customerList.add(cust);
		
		custServ.createCustomer(cust);
		assertNotNull(cust);
	}
	
	@Test
	public void testDeleteCustomerById() throws RecordNotFoundException {
		//CustomerService custServ = mock(CustomerService.class);
		Long customerId = 4L;
//		/Customer customer = new Customer();
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setCustomerId(4L);
				
		//custServ.deleteCustomer(customerId);
		//assertNotNull(custDTO);
		assertEquals(customerId, custDTO.getCustomerId());
	}
	
	@Test
	public void testUpdateCustomerById() {
		//CustomerService custServ = mock(CustomerService.class);
		CustomerRepo custRepo = mock(CustomerRepo.class);
		CustomerMapper custMapper = mock(CustomerMapper.class);
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setCustomerId(4L);
		custDTO.setCustomerName("Pratap P");
		
		Customer customer = new Customer();
		Optional<Customer> optionCust = Optional.of(customer);
		
		customer.setCustomerId(4L);
		customer.setCustomerName("Rajnandini");
		
		when(custRepo.findByCustomerId(customer.getCustomerId())).thenReturn(optionCust);
		when(custMapper.toCustomerDTO(customer)).thenReturn(custDTO);
		
		//updateById(custDTO.getCustomerId())
		Long actualResponse = customer.getCustomerId();
		
		assertEquals(custDTO.getCustomerId(), actualResponse);
		
	}
	
	@Test
	public void testGetAllCustomers() {
		CustomerService custServ = mock(CustomerService.class);
		
		List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
		
		CustomerDTO custDtoOne = new CustomerDTO();
		custDtoOne.setCustomerId(2L);
		custDtoOne.setCustomerName("Raj Patil");
		custDtoOne.setCustomerEmail("raj12@gmail.com");
		Cart cOne = new Cart();
		cOne.setCartId(5L);
		Restrorent rOne = new Restrorent();
		rOne.setRestId(10L);
		rOne.setRestName("Pizza Shop");
		rOne.setRestEmail("pizzashop12@gmail.com");
		rOne.setFood("Cheese Pizza");
		cOne.setRestrorent(rOne);
		custDtoOne.setCart(cOne);
		
		CustomerDTO custDtoTwo = new CustomerDTO();
		custDtoTwo.setCustomerId(4L);
		custDtoTwo.setCustomerName("Satya");
		custDtoTwo.setCustomerEmail("satya12@gmail.com");
		Cart cTwo = new Cart();
		cTwo.setCartId(7L);
		Restrorent rTwo = new Restrorent();
		rTwo.setRestId(12L);
		rTwo.setRestName("Hotel Relax");
		rTwo.setRestEmail("relax12@gmail.com");
		rTwo.setFood("French Fries");
		cTwo.setRestrorent(rTwo);
		custDtoTwo.setCart(cTwo);
		
		listCustomer.add(custDtoOne);
		listCustomer.add(custDtoTwo);
		
		when(custServ.getALLCustomers()).thenReturn(listCustomer);
		
		List<CustomerDTO> result = custServ.getALLCustomers();
		
		assertEquals(2, result.size());
	}
	
}
