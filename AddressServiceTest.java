package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.book.entity.Address;

@SpringBootTest
public class AddressServiceTest {
	
	@Autowired
	IAddressService addressService;
	
	@Test
	@Disabled
	void testGetAllAddress() {
		Address std1 = new Address();
		std1.setAddressId(3333);
		std1.setAddress("hbyyhbfbn");
		std1.setCity("gggbg");
		std1.setCountry("frr");
		std1.setPincode(55666);
		
		Address std2 = new Address();
		std2.setAddressId(3);
		std2.setAddress("hbyyhbfbn");
		std2.setCity(" ");
		std2.setCountry(" ");
		std2.setPincode(0);
		List<Address> address = addressService.ListAllAddress(); 
		assertEquals(2, address.size());
		assertEquals(3333, address.get(0).getAddressId());
		assertEquals("hbyyhbfbn", address.get(0).getAddress());
		assertEquals("gggbg", address.get(0).getCity());
		assertEquals("Frr", address.get(0).getCountry());
		assertEquals(55666, address.get(0).getPincode());
		assertEquals(3, address.get(1).getAddressId());
		assertEquals("hbyyhbfbn", address.get(1).getAddress());
		assertEquals("gggbg", address.get(1).getCity());
		assertEquals("frr", address.get(1).getCountry());
		assertEquals(55666, address.get(1).getPincode());
	}
	
	
	@Test
	 @Disabled
	void testAddAddress() {
		Address address = new Address();
		address.setAddressId(3333);
		address.setAddress("hbyyhbfbn");
		address.setCity("gggbg");
		address.setCountry("Frr");
		address.setPincode(55666);
		Address newAddress= addressService.addAddress(address);
		assertEquals(3333, newAddress.getAddressId());
		assertEquals("hbyyhbfbn", newAddress.getAddress());
		assertEquals("gggbg", newAddress.getCity());
		assertEquals("Frr", newAddress.getCountry());
		assertEquals(55666, newAddress.getPincode());
	}
	
	@Test
	void testDeleteAddressByAddress() {
		Address newAddress = addressService.deleteAddressByAddress(3333);
		assertEquals(3333, newAddress.getAddressId());
		assertEquals("hbyyhbfbn", newAddress.getAddress());
		assertEquals("gggbg", newAddress.getCity());
		assertEquals("Frr", newAddress.getCountry());
		assertEquals(55666, newAddress.getPincode());
	}
	

	
	@Test
	 @Disabled
	void testUpdateAddress() {
		Address address = new Address();
		
		address.setAddressId(3);
		address.setAddress("hbyyhbfbn");
//		address.setCity("gggbg");
//		address.setCountry("Frr");
//		address.setPincode(55666);
		Address updatedAddress = addressService.updateAddress(3,address);
		assertEquals(3, updatedAddress.getAddressId());
		assertEquals("hbyyhbfbn", updatedAddress.getAddress());
//		assertEquals("Chahhhran", updatedAddress.getCity());
//		assertEquals("Chahhhran", updatedAddress.getCountry());
//		assertEquals(567, updatedAddress.getPincode());
	}
}

