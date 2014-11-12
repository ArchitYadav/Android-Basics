package com.vaby.onlineshopping;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper
{
	public static final int VERSION = 1;
	public static final String DBName = "ProductDB";
	
	public DataHelper(Context context, String name, CursorFactory factory,int version) 
	{
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String q = "create table product (Id integer,ItemName text,Price real,Quantity integer,DateOfPurchase text)";
		db.execSQL(q);
		String iql = "insert into  product values(1,'HDD',10000,1,'12-07-2013')";
		db.execSQL(iql);
		String iq2 = "insert into  product values(3,'Necklace',25000,1,'11-07-2013')";
		db.execSQL(iq2);
		String iq3= "insert into  product values(2,'Shoes',10000,1,'12-07-2014')";
		db.execSQL(iq3);
		String iq4 = "insert into  product values(4,'Jeans',10000,4,'104-12-2000')";
		db.execSQL(iq4);
		
		q = "create table catagory(Id integer,Catagory text)";
		db.execSQL(q);
		
		String i1= "insert into catagory values(1,'Electronics')";
		db.execSQL(i1);
		
		String i2= "insert into catagory values(2,'Sports')";
		db.execSQL(i2);
		
		String i3= "insert into catagory values(3,'Jewllery')";
		db.execSQL(i3);
		
		String i4= "insert into catagory values(4,'Cloths')";
		db.execSQL(i4);
		
		Log.e("DB:", "On create");	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
