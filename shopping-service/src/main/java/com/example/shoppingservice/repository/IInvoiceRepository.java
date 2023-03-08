package com.example.shoppingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingservice.entity.Invoice;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long>{

	public List<Invoice> findByCustomerId(Long customerId);
	public Invoice findByNumberInvoice(String numberInvoice);
	
}
