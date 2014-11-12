package com.vaby.employeerecord;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class MainActivity extends Activity 
{
	
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	ListView listEmp;
	ArrayAdapter<Employee> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_act);
		
		listEmp =(ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employeeList);
		
		employeeList.add(new Employee("Atul",23000.0));
		employeeList.add(new Employee("Rohit",20000.0));
		employeeList.add(new Employee("amit",26000.0));
		
		listEmp.setAdapter(adapter);
		registerForContextMenu(listEmp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id) {
		case R.id.addEmp:
			final Dialog d = new  Dialog(MainActivity.this);
			d.setTitle("New Employee");
			d.setContentView(R.layout.dialogue_box);
			Button buttonDone = (Button) d.findViewById(R.id.button1);
			final EditText editName = (EditText)d.findViewById(R.id.editText1);
			final EditText editSal = (EditText)d.findViewById(R.id.editText2);
			
			buttonDone.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					String name = editName.getText().toString(); 
					double Sal = Double.parseDouble(editSal.getText().toString());
					
					employeeList.add(new Employee(name,Sal));
					listEmp.setAdapter(adapter);
					d.dismiss();
				}
			});
			d.show();
			break;

		case R.id.addExit:
			finish();
			break;

		default:
			break;
		}
	
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo)
	{
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	
		MenuInflater inflater = getMenuInflater();
		int viewId = v.getId();
		
			inflater.inflate(R.menu.option_contextmenu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		final int p = info.position;
		switch (id) {
		
		case R.id.edit:
			final Dialog d2=new Dialog(MainActivity.this);
			d2.setContentView(R.layout.dialgue_edit);
			final EditText editName = (EditText) d2.findViewById(R.id.editText1);
			final EditText editSal = (EditText) d2.findViewById(R.id.editText2);
			Button updateButton = (Button)d2.findViewById(R.id.button1); 
			d2.show();
			editName.setText(employeeList.get(p).getName());
			editSal.setText(employeeList.get(p).getSal()+"");
			updateButton.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					String name = editName.getText().toString();
					Double sal = Double.parseDouble(editSal.getText().toString());
					Employee e = (new Employee(name,sal));
					employeeList.set(p,e);
					d2.dismiss();
					listEmp.setAdapter(adapter);
				}
			});
			
			break;
		
		
		case R.id.Remove:
			employeeList.remove(p);
			listEmp.setAdapter(adapter);
			break;
			
		
		case R.id.Select:
			Dialog d21=new Dialog(MainActivity.this);
			d21.setContentView(R.layout.dailog_show);
			TextView data=(TextView) d21.findViewById(R.id.textView1);
			Employee emp1=employeeList.get(p);
			data.setText(""+emp1);
			d21.show();
		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}

	
}
