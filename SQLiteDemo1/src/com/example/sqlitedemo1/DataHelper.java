package com.example.sqlitedemo1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper
{

	public DataHelper(Context context, String name, CursorFactory factory,int version)
	{
		super(context, name, factory, version);
		
		 
	}

	@Override
	public void onCreate(SQLiteDatabase db) // create initial structre of database
	{
		String q = "create table employee(eid integer,name text,salary real)";
		db.execSQL(q);
		String iql = "insert into employee values(1,'Raj',45000)";
		db.execSQL(iql);
		String iql1 = "insert into employee values(10,'Archit',65000)";
		db.execSQL(iql1);
		String iql2 = "insert into employee values(34,'Divya',55000)";
		db.execSQL(iql2);

		Log.e("DB:", "On create");			
	}		
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{

		
		Log.e("DB:", "On Upgrade");			

	}


}
