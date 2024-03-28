package com.springproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dept_tbl")
public class Department {
	
	@Id   //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
	private int id;
	private String dpt_name;
	private String dpt_hod;
	private String dpt_phone;

}

