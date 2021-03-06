package com.demo.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.book.dao.IAddressDao;
import com.demo.book.entity.Address;
import com.demo.book.exception.AddressNotFoundException;

@ExtendWith(SpringExtension.class)
	public class AddressServiceMockitoTest {
	     
		// @InjectMock - Creates instance of a class and injects mocks that are created
			// with @Mock

			@InjectMocks
			AddressServiceImpl addressService;

			// @MockBean - Creates Mock of a class or interface

			@MockBean
			IAddressDao addressDao;

			// Initialization of mock objects
			@BeforeEach
			void init() {
				MockitoAnnotations.openMocks(this);
			}
			
			@Test
			void testGetAddressByAddressId() throws AddressNotFoundException {
				
				Address address = new Address();
				address.setAddressId(3);
				address.setAddress("hbyyhbfbn");
				address.setCity("gggbg");
				address.setCountry("Frr");
				address.setPincode(55666);
				
				Mockito.when(addressDao.findById(3)).thenReturn(Optional.of(address));
				Address std= addressService.getAddressByAddressId(3);
				assertEquals(3, std.getAddressId());
				assertEquals("hbyyhbfbn", std.getAddress());
				assertEquals("gggbg", std.getCity());
				assertEquals("Frr", std.getCountry());
				assertEquals(55666, std.getPincode());
			}
			
			@Test
			void testGetAllAddress() {
				Address std1 = new Address();
				std1.setAddressId(3);
				std1.setAddress("hbyyhbfbn");
				std1.setCity("gggbg");
				std1.setCountry("frr");
				std1.setPincode(55666);
				
				Address std2 = new Address();
				std2.setAddressId(3333);
				std2.setAddress("hbyyhbfbn");
				std2.setCity("gggbg");
				std2.setCountry("frr");
				std2.setPincode(55666);
				//Address std2 = new Address(3333, "hbyyhbfbn","gggbg","frr",55666);
				List<Address> addressList = new ArrayList<>();
				addressList.add(std1);
				addressList.add(std2);
				Mockito.when(addressDao.findAll()).thenReturn(addressList);
				List<Address> address = addressService.ListAllAddress();
				assertEquals(2, address.size());
				assertEquals(3, address.get(0).getAddressId());
				assertEquals("hbyyhbfbn", address.get(0).getAddress());
				assertEquals("gggbg", address.get(0).getCity());
				assertEquals("frr", address.get(0).getCountry());
				assertEquals(55666, address.get(0).getPincode());
				assertEquals(3333, address.get(1).getAddressId());
				assertEquals("hbyyhbfbn", address.get(1).getAddress());
				assertEquals("gggbg", address.get(1).getCity());
				assertEquals("frr", address.get(1).getCountry());
				assertEquals(55666, address.get(1).getPincode());
			}
			
			@Test
			void testAddAddress() {
				//Address address = new Address(3333, "hbyyhbfbn","gggbg","frr",55666);
				Address address = new Address();
				address.setAddressId(3333);
				address.setAddress("hbyyhbfbn");
				address.setCity("gggbg");
				address.setCountry("Frr");
				address.setPincode(55666);
				
				Mockito.when(addressDao.save(address)).thenReturn(address);
				
				Address newAddress = addressService.addAddress(address);
				assertEquals(3333, newAddress.getAddressId());
				assertEquals("hbyyhbfbn", newAddress.getAddress());
				assertEquals("gggbg", newAddress.getCity());
				assertEquals("Frr", newAddress.getCountry());
				assertEquals(55666, newAddress.getPincode());
			}
			
			/*Mockito
			 * Verify update Address by roll no method
			 */
			@Test
			void testUpdateAddress() {
				Address address = new Address();
				
				address.setAddressId(3);
				address.setAddress("hbyyhbfbn");
//				address.setCity("gggbg");
//				address.setCountry("Frr");
//				address.setPincode(55666);
				
				Mockito.when(addressDao.findById(3)).thenReturn(Optional.of(address));
				Mockito.when(addressDao.save(address)).thenReturn(address);
				Address updatedAddress = addressService.updateAddress(3, address);
				assertEquals("hbyyhbfbn", updatedAddress.getAddress());
//				assertEquals("Chahhhran", updatedAddress.getCity());
//				assertEquals("Chahhhran", updatedAddress.getCountry());
//				assertEquals(567, updatedAddress.getPincode());
			}
			
			/*
			 * Verify delete student by roll no.
			 */
			@Test
			void testDeleteAddress() {
				Address address = new Address();
				
				address.setAddressId(3);
				address.setAddress("hbyyhbfbn");
				address.setCity("gggbg");
				address.setCountry("Frr");
				address.setPincode(55666);
				
				Mockito.when(addressDao.findById(3)).thenReturn(Optional.of(address));
				addressDao.deleteById(3);
				Address std = addressService.deleteAddressByAddress(3);
				assertEquals("hbyyhbfbn", std.getAddress());
			}
		
	}


