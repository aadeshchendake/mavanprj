package com.junittestingexam.testjunitmockitofour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junittestingexam.testjunitmockitofour.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

}
