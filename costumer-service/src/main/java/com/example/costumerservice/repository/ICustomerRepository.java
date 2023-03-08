package com.example.costumerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.costumerservice.entity.Customer;
import com.example.costumerservice.entity.Region;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByNumberId(String numberId);
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByRegion(Region region);
	
}
