package com.vaby.onlineshopping.model;

public class Product
{
	String name,date,catagory;
	Double Price;
	int qunatity,prodId;
	
	
	public Product() {
		super();
	}

	public Product(int prodId,String name, Double price, int qunatity,String date) {
		super();
		this.prodId=prodId;
		this.name = name;
		this.date = date;
		Price = price;
		this.qunatity = qunatity;
	}

	public Product(double sumprice, String catagory)
	{
		Price=sumprice; 
		this.catagory = catagory;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	@Override
	public String toString() {
		return "name=" + name + ", date=" + date + ", Price=" + Price
				+ ", qunatity=" + qunatity;
	}
	
}
