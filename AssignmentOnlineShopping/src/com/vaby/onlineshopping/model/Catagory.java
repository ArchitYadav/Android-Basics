package com.vaby.onlineshopping.model;

public class Catagory
{
	String name;
	int prodId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public Catagory() {
		super();
	}
	public Catagory(String name, int prodId) {
		super();
		this.name = name;
		this.prodId = prodId;
	}
	@Override
	public String toString() {
		return  name;
	}
	
	
}
