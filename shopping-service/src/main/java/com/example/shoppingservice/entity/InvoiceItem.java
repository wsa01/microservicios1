package com.example.shoppingservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@Table(name = "tbl_invoice_items")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double quantity;
	private Double price;
	private Long productId;
	@Transient
	private Double subtotal;
	
	
	public Double getSubTotal() {
		if(price > 0 && quantity>0) {
			return quantity * price;
		}
		
		return (double) 0;
	}
	
	public InvoiceItem() {
		price = (double) 0 ;
		quantity = (double) 0;
	}
	
}
