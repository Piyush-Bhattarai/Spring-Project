package com.springproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="address_tbl")
public class Address {
	
	@Id   //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
	private int id;
	private String country;
	private String city;
	private String state;
	private String zipcode;
	

}
