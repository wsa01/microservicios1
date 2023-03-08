package com.example.costumerservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.costumerservice.entity.Customer;
import com.example.costumerservice.entity.Region;
import com.example.costumerservice.repository.ICustomerRepository;
import com.example.costumerservice.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findCustomerByRegion(Region region) {
		// TODO Auto-generated method stub
		return customerRepository.findByRegion(region);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer.setState("CREATED");
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customerDB = getCustomer(customer.getId());
		if (customerDB == null) {
			return null;
		}
		
		customerDB.setFirstName(customer.getFirstName());
		customerDB.setLastName(customer.getLastName());
		customerDB.setEmail(customer.getEmail());
		customerDB.setPhotoUrl(customer.getPhotoUrl());
	
		return customerRepository.save(customerDB);
	}

	@Override
	public Customer deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer customerDB = getCustomer(id);
		if (customerDB == null) {
			return null;
		}
		customerDB.setState("DELETED");
		return customerRepository.save(customerDB);
	}

	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).orElse(null);
	}
	
	
	
}
