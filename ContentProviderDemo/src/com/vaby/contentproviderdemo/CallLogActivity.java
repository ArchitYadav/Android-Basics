package com.vaby.contentproviderdemo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CallLogActivity extends ListActivity
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
		
		Uri uriName = CallLog.Calls.CONTENT_URI;
		Log.e("Phone URI",uriName.toString());
		
		ContentResolver resolver = getContentResolver(); // contentResolver is shared object and accessed 
		//resolver.query(uri, projection, selection, selectionArgs, sortOrder)												 //only by single activity at a time
		Cursor cursor = resolver.query(uriName, null, null, null, null);
		
		// printing list of all columns 
		for(int i=0;i<cursor.getColumnCount();i++)
		{
			Log.e("Phone Calls:", cursor.getColumnName(i));
		}		
		cursor.close();
		String conlName[] ={"_id","duration","number","type","date"}; 
		cursor = resolver.query(uriName, conlName,"type=3", null, "date");
		
		while(cursor.moveToNext())
		{
			String id = cursor.getString(0);
			String name = cursor.getString(1);
			String number = cursor.getString(2);
			String contactid=cursor.getString(3);
			String type=cursor.getString(4);
			
			String data=id+":"+name+":"+number+":"+contactid+":"+type;
			listData.add(data);
		}
		cursor.close();
		listView.setAdapter(adapter);
	}
}
