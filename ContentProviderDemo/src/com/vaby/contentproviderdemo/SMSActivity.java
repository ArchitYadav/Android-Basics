package com.vaby.contentproviderdemo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SMSActivity extends ListActivity
{
	ListView listView;
	ArrayList<String> listData = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		listView = getListView();
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,listData);
		listView.setAdapter(adapter);
		
		Uri uriName = Uri.parse("content://sms/sent");
		Log.e("SMS!",uriName.toString());
		
		ContentResolver resolver = getContentResolver(); // contentResolver is shared object and accessed 
		//resolver.query(uri, projection, selection, selectionArgs, sortOrder)												 //only by single activity at a time
		Cursor cursor = resolver.query(uriName, null, null, null, null);
		
		// printing list of all columns 
		for(int i=0;i<cursor.getColumnCount();i++)
		{
			Log.e("SMS:", cursor.getColumnName(i));
		}		
		cursor.close();
		String conlName[] ={"_id","address","body","type","date"}; 
		cursor = resolver.query(uriName, conlName,null, null, "_id");
		
		while(cursor.moveToNext())
		{
			String id = cursor.getString(0);
			String name = cursor.getString(1);
			String hasPhone = cursor.getString(2);
			String contactid=cursor.getString(3);
			String date=cursor.getString(4);
			String data=id+":"+name+":"+hasPhone+":"+contactid+":"+date;
			listData.add(data);
		}
		cursor.close();
		listView.setAdapter(adapter);
	}
}
