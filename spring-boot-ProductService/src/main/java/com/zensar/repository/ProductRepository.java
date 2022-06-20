package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
//	List<Product> getByProductName(String productName);
	
	@Query(value = "select * from product where product_name=:name",nativeQuery=true)
	List<Product> test(@Param("name")String productName);
	
//	List<Product> findByProductNameAndProductCost(String productName,int cost);
	@Query("from Product s where s.productName=:name and s.productCost=:cost")
	List<Product> test1(@Param("name")String productName,@Param("cost")int cost);	

}
