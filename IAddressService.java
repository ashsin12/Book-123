package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.Address;
import com.demo.book.entity.Review;

public interface IAddressService {


	List<Address> ListAllAddress();

	Address addAddress(Address address);

	Address deleteAddressByAddress(int addressId);

	Address updateAddress(int addressId, Address address);

	//Address addAddress(Address address);

	

	
	
	 



	
	

	

	
	
	
	
}
