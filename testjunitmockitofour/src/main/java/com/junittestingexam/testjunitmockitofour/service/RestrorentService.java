package com.junittestingexam.testjunitmockitofour.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.dto.RestrorentDTO;
import com.junittestingexam.testjunitmockitofour.entity.Customer;
import com.junittestingexam.testjunitmockitofour.entity.Restrorent;
import com.junittestingexam.testjunitmockitofour.exceptions.RecordNotFoundException;
import com.junittestingexam.testjunitmockitofour.mapper.RestrorentMapper;
import com.junittestingexam.testjunitmockitofour.repository.RestrorentRepo;
import com.junittestingexam.testjunitmockitofour.utils.Message;

@Service
public class RestrorentService {

		@Autowired
		private RestrorentRepo restRepo;
		
		@Autowired
		private RestrorentMapper restMapper;
		
		@Autowired
		private Message message;
		
		@Autowired
		private ModelMapper modelMapper;

		public Restrorent createCall(Restrorent rust) {
			return restRepo.save(rust);
		}

		public Restrorent putCall(Restrorent rust) {
			return restRepo.save(rust);
		}

		public List<Restrorent> getCall() {
			return restRepo.findAll();
		}

		public void deleteCall(Restrorent rust) {
			restRepo.delete(rust);
		}

		/**
		 * 
		 * @param restDTO
		 */
		public void createRestrorentCall(RestrorentDTO restDTO) {
			Restrorent restrorent = restMapper.toRestroEntity(restDTO);
			
			restrorent = restRepo.save(restrorent);
		}

		/**
		 * 
		 * @return
		 */
		public List<RestrorentDTO> getAllRestrorent(){
			List<Restrorent> restrorent = restRepo.findAll();
			
			return restrorent.stream().map(e -> restMapper.toRestroDTO(e)).collect(Collectors.toList());
		}

		/**
		 * 
		 * @param restDTO
		 * @throws RecordNotFoundException
		 */
		public void updateRestrorentCall(RestrorentDTO restDTO) throws RecordNotFoundException {
			Optional<Restrorent> restrorent = restRepo.findByRestId(restDTO.getRestId());
			
			if(!restrorent.isPresent())
				throw new RecordNotFoundException(message.getMessage("restrorent.notPresent"));
			
			Restrorent rest = modelMapper.map(restDTO, Restrorent.class);
			rest.setRestId(restDTO.getRestId());
			rest.setRestName(restDTO.getRestName());
			rest.setRestEmail(restDTO.getRestEmail());
			rest.setFood(restDTO.getFood());
			
			restRepo.save(rest);
		}

		public void deleteRestrorent(Long restId) throws RecordNotFoundException {
			Optional<Restrorent> restrorent = restRepo.findByRestId(restId);
			
			if(!restrorent.isPresent())
				throw new RecordNotFoundException(message.getMessage("restrorent.notPresent"));
			
			restRepo.deleteByRestId(restId);
		}	
		
}
