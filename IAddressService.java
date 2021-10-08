package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.Address;
import com.demo.book.entity.Review;
import com.demo.book.exception.AddressNotFoundException;

public interface IAddressService {


	List<Address> ListAllAddress();

	Address addAddress(Address address);

	Address deleteAddressByAddress(int addressId);

	Address getAddressByAddressId(int addressId) throws AddressNotFoundException;

	Address updateAddress(int addressId, Address address);

	//Address getAddressByAddressId(int addressId) throws AddressNotFoundException;

	//Address getAddressByAddressId(int addressId);

	//Address addAddress(Address address);

	

	
	
	 



	
	

	

	
	
	
	
}
