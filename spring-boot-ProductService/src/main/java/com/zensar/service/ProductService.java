package com.zensar.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.dto.ProductDto;

public interface ProductService {
	
	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProducts(int pageNumber ,int pageSize,String sortBy,Direction dir);

	public ProductDto insertProduct(ProductDto product);

	public void updateProduct(int productId, ProductDto product);

	public void deleteProduct(int productId);
	
	List<ProductDto> getByProductName(String productName);
	
	List<ProductDto> findByProductNameAndProductCost(String productName,int cost);

}
