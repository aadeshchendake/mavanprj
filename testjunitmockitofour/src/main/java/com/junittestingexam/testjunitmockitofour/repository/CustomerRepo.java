package com.junittestingexam.testjunitmockitofour.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junittestingexam.testjunitmockitofour.dto.CustomerDTO;
import com.junittestingexam.testjunitmockitofour.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	//Optional<Customer> findByCustomerId(Long customerId);


	void save(Optional<Customer> custEntity);

	Optional<Customer> findByCustomerId(Long customerId);

	void deleteByCustomerId(Long customerId);








}
