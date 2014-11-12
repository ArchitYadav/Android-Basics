package com.wimc.assignment6;

	

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ReportActivity extends Activity 
{
	TextView textReport;
	ListView listView;
	ArrayAdapter<String> adapter;
	ArrayList<String> list= new ArrayList<String>();
	DataHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report);
		textReport = (TextView) findViewById(R.id.textView1);
		listView = (ListView) findViewById(R.id.listView1);
		helper = new DataHelper(this, DataHelper.DBName, null, DataHelper.VERSION);
		SQLiteDatabase db = helper.getWritableDatabase();
		String q = "select catName,sum(price) from Item, category where cId=catId group by Item.cId";
		
		Cursor cursor = db.rawQuery(q, null);
		while(cursor.moveToNext())
		{
			String name = cursor.getString(0);
			double sum = cursor.getDouble( 1);
			String str=name+":"+sum;
			list.add(str);
		}
		cursor.close();
		db.close();
		
		adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		listView.setAdapter(adapter);
	}
}


