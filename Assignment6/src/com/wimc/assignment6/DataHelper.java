package com.wimc.assignment6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper
{
	public static final int VERSION = 1;
	public static final String DBName = "ShoppingDB";
	

	public DataHelper(Context context, String name, CursorFactory factory,int version) 
	{
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String q = "create table Item(name text,price real,quantity integer,cId integer,date text)";
		db.execSQL(q);
		String iq1 = "insert into Item values('LG Mobile',12000,4,1,'15/01/2013')";
		db.execSQL(iq1);
		String iq2 = "insert into Item values('Jeans',2000,2,2,'5/11/2010')";
		db.execSQL(iq2);
		String iq3 = "insert into Item values('Diamond Ring',52000,1,3,'14/02/2014')";
		db.execSQL(iq3);
		
		q = "create table category(catId integer,catName text)";
		db.execSQL(q);
		iq1 = "insert into category values(1,'Electronics')";
		db.execSQL(iq1);
		iq2 = "insert into category values(2,'Clothing')";
		db.execSQL(iq2);
		iq3 = "insert into category values(3,'Jewellery')";
		db.execSQL(iq3);
		
		Log.e("DB:","on create");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
