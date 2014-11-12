package com.example.sqlitedemo1.controller;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitedemo1.DataHelper;
import com.example.sqlitedemo1.model.Department;

public class DepartmentController
{
	DataHelper helper;

	public DepartmentController(Context context)
	{
		helper = new DataHelper(context, DataHelper.DBName, null,DataHelper.VERSION);
		
		
	}

	
	public ArrayList<Department> getAllDepartment()
	{
		ArrayList<Department> listDepartments = new ArrayList<Department>();
	//---------------------------------------------------------------
		SQLiteDatabase db = helper.getWritableDatabase();
		String q = "select * from department";
		
		Cursor cursor = db.rawQuery(q,null);
		
		while(cursor.moveToNext())
		{
			int deptId = cursor.getInt(0);
			String name= cursor.getString(1);
			
			Department dept = new Department(deptId, name);
			listDepartments.add(dept);
			
		}
		cursor.close();
		db.close();
	//---------------------------------------------------------------	
		return listDepartments;
		
	}
	
}
