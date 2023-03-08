package com.example.shoppingservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingservice.entity.Invoice;
import com.example.shoppingservice.repository.IInvoiceRepository;
import com.example.shoppingservice.service.IInvoiceService;

@Service
public class InvoiceServiceImpl implements IInvoiceService{

	@Autowired
	private IInvoiceRepository  invoiceRepository;

	@Override
	public List<Invoice> findInvoiceAll() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		Invoice invoiceDB = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
		if (invoiceDB != null) {
			return  invoiceDB;
		}
		
		invoice.setState("CREATED");
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice deleteInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		Invoice invoiceDB = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
		if (invoiceDB == null) {
			return  null;
		}
		invoiceDB.setState("DELETED");
		return invoiceRepository.save(invoiceDB);
	}

	@Override
	public Invoice getInvoice(Long id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id).orElse(null);
	}
	
}
