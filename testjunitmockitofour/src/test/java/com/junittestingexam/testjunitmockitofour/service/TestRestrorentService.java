package com.junittestingexam.testjunitmockitofour.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.annotation.Order;

import com.junittestingexam.testjunitmockitofour.dto.RestrorentDTO;
import com.junittestingexam.testjunitmockitofour.entity.Restrorent;
import com.junittestingexam.testjunitmockitofour.mapper.RestrorentMapper;
import com.junittestingexam.testjunitmockitofour.repository.RestrorentRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
public class TestRestrorentService {
	
	@Test
	@Order(2)
	public void createCallService() {
		RestrorentService restServ = mock(RestrorentService.class);
		
		List<RestrorentDTO> listRestDTO = new ArrayList<RestrorentDTO>(); 
		RestrorentDTO restDTO = new RestrorentDTO();
		restDTO.setRestId(2L);
		restDTO.setRestName("Good Food Restrorent");
		restDTO.setRestEmail("goodfood12@gmail.com");
		restDTO.setFood("Maggie");
		
		listRestDTO.add(restDTO);
		
		restServ.createRestrorentCall(restDTO);
		
		assertNotNull(listRestDTO);
	}
	
	@Test
	@Order(1)
	public void getCallService() {
		RestrorentService restServ = mock(RestrorentService.class);
		
		List<RestrorentDTO> listRestDTO = new ArrayList<RestrorentDTO>();
		
		RestrorentDTO restDTOOne = new RestrorentDTO();
		restDTOOne.setRestId(2L);
		restDTOOne.setRestName("Good Food Restro");
		restDTOOne.setRestEmail("goodfood12@gmail.com");
		restDTOOne.setFood("Maggie");
		
		RestrorentDTO restDTOTwo = new RestrorentDTO();
		restDTOTwo.setRestId(2L);
		restDTOTwo.setRestName("Baba Yaga");
		restDTOTwo.setRestEmail("babayaga12@gmail.com");
		restDTOTwo.setFood("Pizza");
		
		listRestDTO.add(restDTOOne);
		listRestDTO.add(restDTOTwo);
		
		when(restServ.getAllRestrorent()).thenReturn((List<RestrorentDTO>) listRestDTO);
		
		List<RestrorentDTO> actualResponse = restServ.getAllRestrorent();
		assertEquals(2, actualResponse.size());
	}
	
	@Test
	@Order(3)
	public void updateRestrorentById() {
		RestrorentRepo restRepo = mock(RestrorentRepo.class);
		RestrorentMapper restMapper = mock(RestrorentMapper.class);
		
		RestrorentDTO restDTO = new RestrorentDTO();
		restDTO.setRestId(2L);
		restDTO.setRestName("Good Food");
		restDTO.setRestEmail("goodfood12@gmail.com");
		restDTO.setFood("Maggie");
		
		Restrorent restrorent = new Restrorent();
		Optional<Restrorent> restOption = Optional.of(restrorent);
		
		restrorent.setRestId(2L);
		restrorent.setRestName("Well Good Food");
		restrorent.setRestEmail("wellgood@gmail.com");
		restrorent.setFood("Maggie");
		
		when(restRepo.findByRestId(restrorent.getRestId())).thenReturn(restOption);
		when(restMapper.toRestroDTO(restrorent)).thenReturn(restDTO);
		
		Long actualReponse = restrorent.getRestId();
		
		assertEquals(restDTO.getRestId(), actualReponse);
		
	}
	
	
}
