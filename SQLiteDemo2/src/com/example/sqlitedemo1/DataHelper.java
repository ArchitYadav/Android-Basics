package com.example.sqlitedemo1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper
{
	public static final int VERSION = 2;
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
		String q = "create table department(deptid integer,name text)";
		db.execSQL(q);
		
		String i1= "insert into department values(1,'HR')";
		db.execSQL(i1);
		
		String i2= "insert into department values(2,'IT')";
		db.execSQL(i2);
		
		String i3= "insert into department values(3,'Finanace')";
		db.execSQL(i3);
		
		String alterQ = "alter table emloyee add column deptId integer default 2";
		db.execSQL(alterQ);
	}

}
