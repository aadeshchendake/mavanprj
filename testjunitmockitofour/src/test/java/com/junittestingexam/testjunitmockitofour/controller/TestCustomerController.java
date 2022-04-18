package com.junittestingexam.testjunitmockitofour.controller;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.repository.CustomerRepo;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerController {
	
	/**
	 * for working with @ mocking need to use junit 5
	 */	
	@Mock
	CustomerRepo custRepo;
	
	@InjectMocks
	CustomerController custController;
	
	@Mock
	CustomerDTO custDTO;
	
	
//
//	@Test
//	public void testForCreateCall() {
//		CustomerService custServ = mock(CustomerService.class);
//		//CustomerController custController = mock(CustomerController.class);
//		CustomerDTO custDTO = new CustomerDTO();
//		custDTO.setCustomerId(2L);
//		custDTO.setCustomerName("Raj");
//		custServ.createCustomer(custDTO);
//		//ResponseEntity<ResponseBody> response = custController.createCustomer(custDTO);
//		//assertEquals((HttpStatus.OK.value(),"created"), response);
//		assertNotNull(custDTO);
//	}
//	
//	@Test
//	public void testForUpdateByIdCall() throws RecordNotFoundException {
//		CustomerService custServ = mock(CustomerService.class);
//		CustomerDTO custDTO = new CustomerDTO();
//		custServ.updateById(custDTO);
//		assertNotNull(custDTO);
//	}
//	
//	@Test
//	public void testForDeleteByIdCall() throws RecordNotFoundException {
//		CustomerService custServ = mock(CustomerService.class);
//		CustomerController custController = mock(CustomerController.class);
//		CustomerDTO custDTO = new CustomerDTO();
//		custDTO.setCustomerId(4L);
//		custDTO.setCustomerName("Raj P");
//		
//		custServ.deleteCustomer(custDTO.getCustomerId());
//		
//
//		ResponseEntity<ResponseBody> response = custController.deleteCustomer(custDTO.getCustomerId());
//		
//		assertNull(response);
//		
//	}
//	
//	@Test
//	public void testForGetAllCustomers() {
//		//CustomerController custController = mock(CustomerController.class);
//		
//		List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
//		
//		CustomerDTO custDTOOne = new CustomerDTO();
//		custDTOOne.setCustomerId(4L);
//		custDTOOne.setCustomerName("Raj P");
//		custDTOOne.setCustomerEmail("raj123@gmail.com");
//		
//		listCustomer.add(custDTOOne);
//		
//		
//		assertNotNull(listCustomer);
//	}
	/**
	 *-----------------------------------------------------------------------------------------------------
	 */
	
	@Test
	public void testForGetCall() {
		
	}
}
