package com.junittestingexam.testjunitmockitofour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restrorent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100000L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restId;
	
	@Column
	private String restName;
	
	private String restEmail;
	
	private String food;

	public Long getRestId() {
		return restId;
	}

	public void setRestId(Long restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestEmail() {
		return restEmail;
	}

	public void setRestEmail(String restEmail) {
		this.restEmail = restEmail;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Restrorent [restId=" + restId + ", restName=" + restName + ", restEmail=" + restEmail + ", food=" + food
				+ "]";
	}
	
	
}
