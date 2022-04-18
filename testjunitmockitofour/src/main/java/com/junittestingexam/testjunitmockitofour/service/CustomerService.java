package com.junittestingexam.testjunitmockitofour.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.entity.Customer;
import com.junittestingexam.testjunitmockitofour.exceptions.RecordNotFoundException;
import com.junittestingexam.testjunitmockitofour.mapper.CustomerMapper;
import com.junittestingexam.testjunitmockitofour.repository.CustomerRepo;
import com.junittestingexam.testjunitmockitofour.utils.Message;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private Message message;


//	public Customer createCall(Customer cust) {
//		return custRepo.save(cust);
//	}

	/**
	 * 
	 * @param cust
	 * @return
	 */
	public Customer putCall(Customer cust) {
		return custRepo.save(cust);
	}

	/**
	 * 
	 * @return
	 */
	public List<Customer> getCall() {
		return custRepo.findAll();
	}


	/**
	 * 
	 * @param cust
	 */
	public void deleteCall(Customer cust) {
		custRepo.delete(cust);
	}

	/**
	 * 
	 * @param custDTO
	 */
	public void createCustomer(CustomerDTO custDTO) {
		Customer customer = customerMapper.toCustomerEntity(custDTO);
		
		customer = custRepo.save(customer);
				
	}

//	/**
//	 * 
//	 * @param custDTO
//	 */
//	public void updateCustomer(CustomerDTO custDTO) {
//		Customer customer = customerMapper.toCustomerEntity(custDTO);
//		
//		customer = custRepo.save(customer);
//	}
	

	/**
	 * 
	 * @return
	 */
	public List<CustomerDTO> getALLCustomers() {
		List<Customer> list = (List<Customer>) custRepo.findAll();
		return list.stream().map(e->customerMapper.toCustomerDTO(e)).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param custDTO
	 * @throws RecordNotFoundException
	 */
	public void updateById(CustomerDTO custDTO) throws RecordNotFoundException {
		Optional<Customer> customer = custRepo.findByCustomerId(custDTO.getCustomerId());
		
		if(!customer.isPresent())
			throw new RecordNotFoundException(message.getMessage("customer.notFound"));
		
		Customer custTwo = customerMapper.toCustomerEntity(custDTO);
				//modelMapper.map(custDTO, Customer.class);
		custTwo.setCustomerId(custDTO.getCustomerId());
		custTwo.setCustomerName(custDTO.getCustomerName());
		custTwo.setCustomerEmail(custDTO.getCustomerEmail());
		custTwo.setCart(custDTO.getCart());
		
		custRepo.save(custTwo);
	}

//	public void deleteCustomerBasedOnId(Long customerId) throws RecordNotFoundException {
//		Optional<Customer> customer = custRepo.findByCustomerId(customerId);
//		
//		if(!customer.isPresent())
//			throw new RecordNotFoundException(message.getMessage("customer.notFound"));
//		
//		custRepo.deleteByCustomerId(customer);
//		
//	}

	/**
	 * 
	 * @param customerId
	 * @throws RecordNotFoundException
	 */
	public void deleteCustomer(Long customerId) throws RecordNotFoundException {
		Optional<Customer> customer = custRepo.findByCustomerId(customerId);
		if(!customer.isPresent())
			throw new RecordNotFoundException(message.getMessage("customer.notFound"));
		
		custRepo.deleteByCustomerId(customerId);
	}

	/**
	 * 
	 * @param customerId
	 */
//	public void deleteCustomerBasedOnId(Long customerId) {
//		Optional<Customer> customer = custRepo.findByCustomerId(customerId);
//		custRepo.deleteByCustomerId(customerId);
//			
//	}

	

//	public void updateCustomer(Long customerId, CustomerDTO custDTO) {
//		Optional<Customer> custEntity = custRepo.findByCustomerId(customerId);
//	
//		
//		
//		CustomerDTO custDTONext = customerMapper.toCustomerDTO(custEntity);
//		
//		custRepo.save(custEntity);
//	}
//	
}
