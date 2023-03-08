package com.example.productservice.service;

import java.util.List;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;

public interface IProductService {
	
	public List<Product> listAllProduct();
	public Product getProduct(Long id);
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(Long id);
	public List<Product> findByCategory(Category category);
	public Product updateStock(Long id, Double quantity);

}
