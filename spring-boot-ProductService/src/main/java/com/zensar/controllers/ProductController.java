package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.ProductDto;
import com.zensar.entity.Product;
import com.zensar.service.ProductService;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class ProductController {

	@Autowired
	private ProductService productService;

//	 http://localhost:9999/product-api/products

//	@RequestMapping("/product/{productId}")
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int poductId) {
		return new ResponseEntity<ProductDto>(productService.getProduct(poductId), HttpStatus.OK);
	}

//	@RequestMapping("/products")
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy",required=false, defaultValue = "productName")String sortBy,
			@RequestParam(value = "dir",required = false, defaultValue = "ASC")Direction dir){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(pageNumber,pageSize,sortBy,dir), HttpStatus.OK);
	}

	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productService.insertProduct(productDto), HttpStatus.CREATED);


	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully!!!", HttpStatus.OK);
	}

	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {
		productService.updateProduct(productId, productDto);
		return new ResponseEntity<String>("ProductDetails Updated Successfully!!!", HttpStatus.OK);

	}

	// http:localhost:9999/product-api/products/productname/cost

	@GetMapping("/products/productname/{producName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productService.getByProductName(productName), HttpStatus.OK);
	}

	@GetMapping("/products/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndProductCost(
			@PathVariable("productName") String productName, @PathVariable("productCost") int cost) {
		return new ResponseEntity<List<ProductDto>>(productService.findByProductNameAndProductCost(productName, cost),
				HttpStatus.OK);
	}

}
