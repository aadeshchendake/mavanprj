package com.junittestingexam.testjunitmockitofour.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.junittestingexam.testjunitmockitofour.dto.RestrorentDTO;
import com.junittestingexam.testjunitmockitofour.exceptions.RecordNotFoundException;
import com.junittestingexam.testjunitmockitofour.service.RestrorentService;
import com.junittestingexam.testjunitmockitofour.utils.ResponseBody;

@RunWith(MockitoJUnitRunner.class)
public class TestRestrorentController {
	
	@Test
	public void testCreateRestrorentCall() {
		RestrorentService restServ = mock(RestrorentService.class);
		
		RestrorentDTO restDTO = new RestrorentDTO();
		restDTO.setRestId(2L);
		restDTO.setRestName("Cafe T");
		restDTO.setRestEmail("cafet12@gmail.com");
		restDTO.setFood("Berger");
		
		assertNotNull(restDTO);
	}
	
	@Test
	public void testGetAllRestrorentCall() {
		//RestrorentService restServ = mock(RestrorentService.class);
		
//		List<RestrorentDTO> listRestDTO = new ArrayList<>();
//		
//		RestrorentDTO restDTOOne = new RestrorentDTO();
//		restDTOOne.setRestId(2L);
//		restDTOOne.setRestName(null);
//		
//		RestrorentDTO restDTOTwo = new RestrorentDTO();
//		restDTOTwo.setRestId(2L);
//		restDTOTwo.setRestName("Jhon");
//		
		RestrorentController restController = mock(RestrorentController.class);
		RestrorentDTO restDTO = mock(RestrorentDTO.class);
		
		
		ResponseEntity<ResponseBody> acutalResposne =  restController.createRestrorent(restDTO);
		
		assertNull(acutalResposne);
		
	}
	
	@Test
	public void testForUpdateRestrorentCall() throws RecordNotFoundException {
		RestrorentController restController = mock(RestrorentController.class);
		RestrorentDTO restDTO = new RestrorentDTO();
		
		assertNull(restController.updateRestrorent(restDTO));
	}
	
	@Test
	public void testForDeleteByIdCall() throws RecordNotFoundException {
		RestrorentController restCont = mock(RestrorentController.class);
		RestrorentDTO restDTO = new RestrorentDTO();
		restDTO.setRestId(2L);
		
		assertNull(restCont.deleteRestrorent(restDTO.getRestId()));
	}
	
	
	
}
