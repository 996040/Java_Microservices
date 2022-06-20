package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@NamedQueries(value = {
//		@NamedQuery(name = "Product.test1", query = "from Product s where s.productName=?1 and s.productCost=?2") })
//@NamedQuery(name = "Product.test",query = "from Product s where s.productName=?1")
//@NamedQuery(name = "Product.test1", query = "from Product s where s.productName=?1 and s.productCost=?2")

//@NamedNativeQuery(name = "Product.test",query="select * from product where product_name=?1",resultClass = Product.class)
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int productCost;
	public Product() {
		super();
	}
	public Product(int productId, String productName, int productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ "]";
	}
	

}
