package com.junittestingexam.testjunitmockitofour.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.junittestingexam.testjunitmockitofour.dto.RestrorentDTO;
import com.junittestingexam.testjunitmockitofour.entity.Restrorent;

@Component
public class RestrorentMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Restrorent toRestroEntity(RestrorentDTO restDTO) {
		return modelMapper.map(restDTO, Restrorent.class);
	}
	
	public RestrorentDTO toRestroDTO(Restrorent rest) {
		return modelMapper.map(rest, RestrorentDTO.class);
	}
}
