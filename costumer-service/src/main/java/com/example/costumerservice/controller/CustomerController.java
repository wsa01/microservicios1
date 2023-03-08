package com.example.costumerservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.costumerservice.entity.Customer;
import com.example.costumerservice.entity.Region;
import com.example.costumerservice.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping()
	public ResponseEntity<List<Customer>> listAllCustomer(@RequestParam(required = false) Long regionId){
		
		List<Customer> result=new ArrayList<Customer>();
		
		if(regionId == null) {
			result = customerService.getAllCustomer();
		}else {
			result = customerService.findCustomerByRegion(Region.builder().id(regionId).build());
		}
		
		return ResponseEntity.ok(result);
	}
	
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		
		System.out.println(customer.toString());
		
		Customer result = customerService.saveCustomer(customer);
		
		return ResponseEntity.ok(result);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
		
		Customer result = customerService.deleteCustomer(id);
		
		return ResponseEntity.ok(result);
		
	}

}
