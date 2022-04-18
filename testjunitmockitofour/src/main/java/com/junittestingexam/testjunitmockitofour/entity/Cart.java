package com.junittestingexam.testjunitmockitofour.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100000L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cartId;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name="restId", referencedColumnName="restId"),
        @JoinColumn(name="food", referencedColumnName="food")
    })
    private Restrorent restrorent;


	public Long getCartId() {
		return cartId;
	}


	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public Restrorent getRestrorent() {
		return restrorent;
	}


	public void setRestrorent(Restrorent restrorent) {
		this.restrorent = restrorent;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", restrorent=" + restrorent + "]";
	}
	
	
		
	

}
