package com.wimc.assignment6.controller;

import java.util.ArrayList;

import android.app.LauncherActivity.ListItem;
import android.content.ClipData.Item;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wimc.assignment6.DataHelper;
import com.wimc.assignment6.model.Category;
import com.wimc.assignment6.model.ItemDetails;


public class ItemController  
{
	DataHelper helper;

	public ItemController(Context context) 
	{
		helper = new DataHelper(context,DataHelper.DBName, null, DataHelper.VERSION);
	}
	public long insertItem(ItemDetails item)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("name", item.getItemname());
		cv.put("price",item.getPrice());
		cv.put("quantity",item.getQuantity());
		cv.put("cId",item.getCategory());
		cv.put("date",item.getDate());
		
		long result = db.insert("Item",null,cv);
		db.close();
		return result;
	}
	public ArrayList<ItemDetails> getAllItem()
	{
		ArrayList<ItemDetails> listitem = new ArrayList<ItemDetails>();
		//--------------------------------------------------------
		
		SQLiteDatabase db = helper.getWritableDatabase();
		//select data
		String q = "select * from item";
		Cursor cursor = db.rawQuery(q, null);
		//rows in the cursor
		while(cursor.moveToNext())
		{
			
			String name = cursor.getString(0);
			double p= cursor.getDouble(1);
			int quant=cursor.getInt(2);
			int cid = cursor.getInt(3);
			String date=cursor.getString(4);
			
			ItemDetails itemDetails = new ItemDetails(name,p,quant,cid,date);
			
			listitem.add(itemDetails);
		}		
		cursor.close();
		db.close();	
		return listitem;
	}
	public ArrayList<ItemDetails> getItem(Category c)
	{
		ArrayList<ItemDetails> listitem = new ArrayList<ItemDetails>();
		//--------------------------------------------------------
		
		SQLiteDatabase db = helper.getWritableDatabase();
		//select data
		int cid=c.getCatId();
		String q = "select * from item where cId="+cid+"";
		Cursor cursor = db.rawQuery(q, null);
		//rows in the cursor
		while(cursor.moveToNext())
		{
			
			String name = cursor.getString(0);
			double p= cursor.getDouble(1);
			int quant=cursor.getInt(2);
			cid = cursor.getInt(3);
			String date=cursor.getString(4);
			
			ItemDetails itemDetails = new ItemDetails(name,p,quant,cid,date);
			
			listitem.add(itemDetails);
		}		
		cursor.close();
		db.close();	
		
		return listitem;
		
	}
}
