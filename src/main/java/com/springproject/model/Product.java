package com.springproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id   
	@GeneratedValue
	private int id;
	private String title;
	private double price;
	@Column(columnDefinition = "Text")
	private String description;
	private String category;
	private String image;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ratingid")
	private Rating rating;

}
