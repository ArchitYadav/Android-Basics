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

public class ListNameActivity extends ListActivity
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
		
		Uri uriName = ContactsContract.Contacts.CONTENT_URI;
		Log.e("URI",uriName.toString());
		
		ContentResolver resolver = getContentResolver(); // contentResolver is shared object and accessed 
		//resolver.query(uri, projection, selection, selectionArgs, sortOrder)												 //only by single activity at a time
		Cursor cursor = resolver.query(uriName, null, null, null, null);
		
		// printing list of all columns 
		for(int i=0;i<cursor.getColumnCount();i++)
		{
			Log.e("Col:", cursor.getColumnName(i));
		}		
		cursor.close();
		String conlName[] ={"_id","display_name","has_phone_number"}; 
		cursor = resolver.query(uriName, conlName, null, null, "display_name");
		
		while(cursor.moveToNext())
		{
			String id = cursor.getString(0);
			String name = cursor.getString(1);
			String hasPhone = cursor.getString(2);
			
			String data=id+":"+name+":"+hasPhone;
			listData.add(data);
		}
		cursor.close();
		listView.setAdapter(adapter);
	}
}
