package com.example.sqlitedemo1.controller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitedemo1.DataHelper;
import com.example.sqlitedemo1.MainActivity;
import com.example.sqlitedemo1.model.Employee;

public class EmployeeController
{
	DataHelper helper;
	ArrayList<Employee> listEmployees = new ArrayList<Employee>();
	public EmployeeController(Context context)
	{
		helper = new DataHelper(context,DataHelper.DBName,null,DataHelper.VERSION);
		
	}

	public long insertEmployee(Employee emp)
	{
		SQLiteDatabase db =helper.getWritableDatabase();
		ContentValues cv =new ContentValues();
		cv.put("eid",emp.getEid());
		cv.put("name", emp.getName());
		cv.put("salary", emp.getSalary());
		cv.put("deptId",emp.getDeptId());
		
		long result = db.insert("employee",null,cv);
		db.close();
		return result;
	}
	
	public ArrayList<Employee> getAllEmployee()
	{
		
		//------------------------------------------------------------	
		
		SQLiteDatabase db = helper.getWritableDatabase();
		// This method first checks whether dabase with specified name is exist or not
		// if not then create it by calling on create method and we will get reference of database
		// if yes then checks for that file name
		
		String q = "select * from employee";
		Cursor cursor = db.rawQuery(q,null);
		// cursor is memory represntation of table
		listEmployees.clear();
		// count number of rows
		while(cursor.moveToNext())
		{
			// column index start from 0
			int eid= cursor.getInt(0);
			String name = cursor.getString(1);
			double sal = cursor.getDouble(2);
			int deptId = cursor.getInt(3);
	
			Employee emp = new Employee(eid, name, sal, deptId);
			
			listEmployees.add(emp);
		} 
		cursor.close();	
		db.close();
		//------------------------------------------------------------
		return listEmployees;
	}
	
	public ArrayList<Employee> deleteEmployee(int i)
	{
		String q = "delete from employee where eid = "+i+"";

		SQLiteDatabase db =helper.getWritableDatabase();
		db.execSQL(q);
		db.close();
		
		return listEmployees;
	}
	
	public long updateEmployee(Employee emp)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		//db.update(table, values, whereClause, whereArgs)
		
		ContentValues cv =new ContentValues();
		
		cv.put("name",emp.getName());
		cv.put("salary", emp.getSalary());
		cv.put("deptId",emp.getDeptId());
		
		String where = "eid="+emp.getEid();
		
		long result =db.update("employee", cv, where, null);
		db.close();
		return 0;
	}
}
