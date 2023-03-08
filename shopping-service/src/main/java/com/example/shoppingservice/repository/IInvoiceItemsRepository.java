package com.example.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingservice.entity.InvoiceItem;

@Repository
public interface IInvoiceItemsRepository extends JpaRepository<InvoiceItem, Long>{

}
