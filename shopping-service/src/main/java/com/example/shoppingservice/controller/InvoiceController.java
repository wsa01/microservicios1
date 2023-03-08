package com.example.shoppingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingservice.entity.Invoice;
import com.example.shoppingservice.service.IInvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private IInvoiceService invoiceService;
	
	
	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		
		List<Invoice> result = invoiceService.findInvoiceAll();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoice(@PathVariable Long id){
		Invoice result = invoiceService.getInvoice(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
		System.out.println(invoice.toString());
		Invoice result = invoiceService.createInvoice(invoice);
		
		return ResponseEntity.ok(result);
	}
	
}
