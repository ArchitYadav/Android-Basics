package com.wimc.assignment6.model;

public class ItemDetails 
{
	
	String itemname;
	double price;
	int quantity;
	int category;
	String date;
	
	public ItemDetails() 
	{
	super();
	}
	
	
	
	public ItemDetails(String itemname, double price, int quantity, int category,String date) 
	{
		super();
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.date=date;
	}
	public String getItemname() 
	{
		return itemname;
	}
	public void setItemname(String itemname) 
	{
		this.itemname = itemname;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) 
	{
		this.category = category;
	}
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() 
	{
		return "ItemDetails [itemname=" + itemname + ", price=" + price
				+ ", quantity=" + quantity + ", category=" + category
				+ ", date=" + date + "]";
	}

}
