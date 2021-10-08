package com.demo.book.entity;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String country;
	@NotEmpty
	@Size(min=6,message="minimum size should be 6 and valid")
	private String pincode;
	
	
	@ManyToOne
	@JoinColumn(name="customer_addr_fk")
	private Customer customer;

}