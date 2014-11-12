package com.vaby.assignday3_3;

import java.io.Serializable;

public class Product implements Serializable
{
	String pName;
	Double Price;
	int qty;
	
	public Product(String pName, Double price, int qty) {
		super();
		this.pName = pName;
		Price = price;
		this.qty = qty;
	}

	public Product()
	{
		super();
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", Price=" + Price + ", qty=" + qty
				+ "]";
	}
	
	
}

