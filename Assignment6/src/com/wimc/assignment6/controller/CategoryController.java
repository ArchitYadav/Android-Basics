package com.wimc.assignment6.controller;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wimc.assignment6.DataHelper;
import com.wimc.assignment6.model.Category;


public class CategoryController 
{
	DataHelper helper;

	public CategoryController(Context context)
	{
		helper = new DataHelper(context, DataHelper.DBName, null, DataHelper.VERSION);
	}
	
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> listCategories= new ArrayList<Category>();  
		
		SQLiteDatabase db = helper.getWritableDatabase();
		String q = "select * from category";
		
		Cursor cursor = db.rawQuery(q, null);
		
		while(cursor.moveToNext())
		{
			int catId = cursor.getInt(0);
			String name = cursor.getString(1);
			
			Category cat = new Category(catId,name);
			listCategories.add(cat);
		}
		cursor.close();
		db.close();
		
		//-----------------------------------------------------------
		return listCategories;
	}
	
}
