package com.example.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import com.example.productservice.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	
	@GetMapping
	public ResponseEntity<?> listProduct(@RequestParam(name = "categoryId",required = false) Long categoryId){
		List<Product> result = new ArrayList<Product>();
		if(categoryId != null) {
			result = productService.findByCategory(Category.builder().id(categoryId).build());
		}else {
			result = productService.listAllProduct();
		}
		
		return ResponseEntity.ok(result);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		Product result = productService.getProduct(id);
		return ResponseEntity.ok(result);
		
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		Product result = productService.saveProduct(product);
		
		return ResponseEntity.ok(result); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
		
		product.setId(id);
		Product result = productService.updateProduct(product);
		return ResponseEntity.ok(result);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
		
		Product result = productService.deleteProduct(id);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable Long id,@RequestParam Double quantity){
		System.out.println(id+" "+quantity);
		Product result = productService.updateStock(id, quantity);
		return ResponseEntity.ok(result);
		
	}
}
