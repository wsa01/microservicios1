package com.example.shoppingservice.service;

import java.util.List;

import com.example.shoppingservice.entity.Invoice;

public interface IInvoiceService {

	public List<Invoice> findInvoiceAll();
	public Invoice createInvoice(Invoice invoice);
	public Invoice updateInvoice(Invoice invoice);
	public Invoice deleteInvoice(Invoice invoice);
	
	public Invoice getInvoice(Long id);
	
	
}
