package com.springproject.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="employee_tbl")
public class Employee {
	
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fname;
	private String lname;
	private String gender;
	private String phone;
	private String company;
	private String post;
	private int salary;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate joinDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deparimentId")
	private Department department;
	
	@ElementCollection
	@CollectionTable
	private List<String> projects;
	

}
