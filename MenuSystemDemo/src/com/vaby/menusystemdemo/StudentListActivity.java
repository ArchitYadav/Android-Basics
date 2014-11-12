package com.vaby.menusystemdemo;

import java.util.ArrayList;

import android.R.string;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StudentListActivity extends ListActivity 
{
	ArrayList<String> listStudents = new ArrayList<String>();
	ListView listViewStudent;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		listViewStudent = getListView();
		
		listStudents.add("Abhinav");
		listStudents.add("Parle-G");
		listStudents.add("Saddam");
		listStudents.add("Ramadhir");
		listStudents.add("Faizal");
		listStudents.add("Chaman");
		listStudents.add("Kernel");
		listStudents.add("Siji");
		listStudents.add("Mata");
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listStudents);
		listViewStudent.setAdapter(adapter);
		registerForContextMenu(listViewStudent);
			
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
			
	
			MenuInflater inflater = getMenuInflater();
			
			inflater.inflate(R.menu.listmenu, menu);
			super.onCreateContextMenu(menu, v, menuInfo);
			
			int viewId = v.getId();
			
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		int p = info.position;
		
		switch (id) {
		case R.id.itemSelect:
			Toast.makeText(this,listStudents.get(p),Toast.LENGTH_SHORT).show();
			break;

		case R.id.itemRemove:
			//Toast.makeText(this,listStudents.get(p),Toast.LENGTH_SHORT).show();
			listStudents.remove(p);
			
			// refresh adapter now
			listViewStudent.setAdapter(adapter);
			break;
	
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}
