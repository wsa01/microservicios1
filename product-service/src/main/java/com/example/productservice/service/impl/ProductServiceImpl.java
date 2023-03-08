package com.example.productservice.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.IProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		log.info("listAllProduct");
		List<Product> result = productRepository.findAll();
		return  result; 
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		Product productDB = getProduct(product.getId());
		if (productDB==null) {
			return null;
		}
		
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		productDB.setStock(product.getStock());
		
		
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		// TODO Auto-generated method stub
		Product productDB = getProduct(id);
		if (productDB==null) {
			return null;
		}
		
		Double newStock = productDB.getStock() + quantity;
		productDB.setStock(newStock);
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
		Product productDB = getProduct(id);
		if (productDB==null) {
			return null;
		}
		
		productDB.setStatus("DELETED");
		
		return productRepository.save(productDB);
	}
	

}
