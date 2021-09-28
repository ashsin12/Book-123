package com.demo.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
     
	@Id
	private int addressId;
	private String address;
	private String city;
	private String country;
	private String pincode;
	
	
			
	
}

    
