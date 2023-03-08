package com.example.costumerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customers")
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String numberId;
	private String firstName;
	private String lastName;
	private String email;
	private String photoUrl;
	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;
	private String state;
	
}
