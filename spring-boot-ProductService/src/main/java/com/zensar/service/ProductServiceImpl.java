package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.dto.ProductDto;
import com.zensar.entity.Product;
import com.zensar.repository.ProductRepository;


	
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
		
	@Autowired
	private ModelMapper modelMapper;



	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.findById(productId).get();
//		ProductDto dto = mapToDto(product);
			
		return modelMapper.map(product,ProductDto.class);
			
//		return dto;

	}

	@Override
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize,String sortBy,Direction dir) {
//		List<Product>listOfProducts = productRepository.findAll();
		List<ProductDto> listOfProductDto= new ArrayList<ProductDto>();
			
//		Pageable p;
//		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"productName")));
//		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.ASC,"productName"));
			
		Page<Product> findAll=productRepository.findAll(PageRequest.of(pageNumber,pageSize,dir,sortBy));
		List<Product> content =findAll.getContent();
		for(Product product:content) {
//			listOfProductDto.add(mapToDto(product));
			listOfProductDto.add(modelMapper.map(product,ProductDto.class));
		}
			
		return listOfProductDto;

	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
//		Product product = mapToEntity(productDto);
		Product product = modelMapper.map(productDto,Product.class);
		Product insertedProduct =productRepository.save(product);
//		ProductDto mapToDto =mapToDto(insertedProduct);
		return modelMapper.map(insertedProduct,ProductDto.class);
		
//		return mapToDto;

	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {
//		Product product = mapToEntity(productDto);
		Product product = modelMapper.map(productDto,Product.class);
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> getByProductName(String productName) {
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productRepository.test(productName);
		for(Product product:products)
			productDtos.add(modelMapper.map(product,ProductDto.class));
		return productDtos;
	}

	@Override
	public List<ProductDto> findByProductNameAndProductCost(String productName, int cost) {
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productRepository.test1(productName,cost);
		for(Product product:products)
			productDtos.add(modelMapper.map(product,ProductDto.class));
		return productDtos;
			
	}

		
		
/*	
	public ProductDto mapToDto(Product product) {
		ProductDto dto= new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setProductCost(product.getProductCost());
		return dto;
	}
		
	public Product mapToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductCost(productDto.getProductCost());
			
		return product;
	}
		
	*/

	

}
