package com.example.costumerservice.service;

import java.util.List;

import com.example.costumerservice.entity.Customer;
import com.example.costumerservice.entity.Region;

public interface ICustomerService {

	public List<Customer> getAllCustomer();
	public List<Customer> findCustomerByRegion(Region region);
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Long id);
	public Customer getCustomer(Long id);
	
}
