package com.vaby.onlineshopping.controller;

import java.util.ArrayList;

import com.vaby.onlineshopping.DataHelper;
import com.vaby.onlineshopping.model.Catagory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CatagoryController
{
	DataHelper helper;

	public CatagoryController(Context context)
	{
		helper = new DataHelper(context, DataHelper.DBName, null,DataHelper.VERSION);
	
	}
	
	public ArrayList<Catagory> getAllCatagory()
	{
		ArrayList<Catagory> listCatagories = new ArrayList<Catagory>();
		//---------------------------------------------------------------
			SQLiteDatabase db = helper.getWritableDatabase();
			String q = "select * from catagory";
			
			Cursor cursor = db.rawQuery(q,null);
			
			while(cursor.moveToNext())
			{
				int Id = cursor.getInt(0);
				String name= cursor.getString(1);
				
				Catagory cat = new Catagory(name, Id);
				listCatagories.add(cat);
				
			}
			cursor.close();
			db.close();
		//---------------------------------------------------------------	
			return listCatagories;
		
		
	}
}
