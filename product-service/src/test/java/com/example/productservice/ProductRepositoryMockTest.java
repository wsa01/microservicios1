package com.example.productservice;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void whenFindByCategory() {
		Product product01 = Product.builder()
								.name("computer")
								.category(Category.builder().id(1L).build())
								.description("")
								.stock(Double.parseDouble("10"))
								.price(Double.parseDouble("1240.99"))
								.status("Created")
								.build();
		productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
		
		Assertions.assertThat(founds.size()).isEqualTo(3);
	}
	
	
}
