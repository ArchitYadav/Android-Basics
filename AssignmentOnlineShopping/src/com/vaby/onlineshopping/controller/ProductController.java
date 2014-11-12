package com.vaby.onlineshopping.controller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vaby.onlineshopping.DataHelper;
import com.vaby.onlineshopping.model.Product;

public class ProductController
{
	DataHelper helper;
	ArrayList<String> listProducts = new ArrayList<String>();
	
	public ProductController(Context context)
	{
		helper = new DataHelper(context,DataHelper.DBName,null,DataHelper.VERSION);
	}

	public long insertProduct(Product product)
	{
		SQLiteDatabase db =helper.getWritableDatabase();
		ContentValues cv =new ContentValues();
		cv.put("Id",product.getProdId());
		cv.put("ItemName", product.getName());
		cv.put("Price", product.getPrice());
		cv.put("Quantity",product.getQunatity());
		cv.put("DateOfPurchase",product.getDate());
		
		long result = db.insert("product",null,cv);
		db.close();
		return result;
	}
	
	public ArrayList<String> getExpenditure()
	{
		SQLiteDatabase db =helper.getWritableDatabase();
		
		String q="select sum(Price), from product,Catagory Group by Id";
		Cursor cursor = db.rawQuery(q,null);
		listProducts.clear();
		while(cursor.moveToNext())
		{
			double sumprice=cursor.getDouble(0);
			String catagory=cursor.getString(1);	
			//Product prod=new Product(sumprice,catagory);
			String str=catagory+"          "+sumprice; 
			 listProducts.add(str);
		} 
		cursor.close();	
		db.close();
		return listProducts;
	}
}
