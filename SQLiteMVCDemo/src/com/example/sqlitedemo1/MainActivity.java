package com.example.sqlitedemo1;

import java.util.ArrayList;

import com.example.sqlitedemo1.controller.DepartmentController;
import com.example.sqlitedemo1.controller.EmployeeController;
import com.example.sqlitedemo1.model.Department;
import com.example.sqlitedemo1.model.Employee;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText textId,textName,textSal;
	Button buttonInsert,buttonList,buttonDelete,buttonUpdate;
	ListView listView;
	Spinner spnDept;
	TextView textView1;
	
	ArrayList<Department> listDept;
	ArrayList<Employee> listEmp = new ArrayList<Employee>();
	ArrayAdapter<Employee> adapter;
	ArrayAdapter<Department> adapterDept;
	DepartmentController deptContrpoller;
	EmployeeController empController;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		empController = new EmployeeController(this);

		textId = (EditText)findViewById(R.id.editText1);
		textName = (EditText)findViewById(R.id.editText2);
		textSal = (EditText)findViewById(R.id.editText3);
		listView =(ListView)findViewById(R.id.listView1);
		buttonInsert= (Button)findViewById(R.id.button1);
		buttonList = (Button)findViewById(R.id.button2);
		buttonDelete = (Button)findViewById(R.id.button3);
		buttonUpdate = (Button)findViewById(R.id.button4);
		spnDept = (Spinner)findViewById(R.id.spinner1);
		
		deptContrpoller = new DepartmentController(this);
		listDept = deptContrpoller.getAllDepartment();
		adapterDept = new ArrayAdapter<Department>(this,android.R.layout.simple_spinner_item,listDept);
		spnDept.setAdapter(adapterDept);
		
		buttonInsert.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				int eid =Integer.parseInt(textId.getText().toString());
				String name  = textName.getText().toString();
				Double sal =Double.parseDouble(textSal.getText().toString());
				
				Department dept = (Department) spnDept.getSelectedItem();
							
				Employee emp = new Employee(eid, name, sal, dept.getDeptId());
				long r = empController.insertEmployee(emp);
				
				if(r != -1)
				{
					Toast.makeText(MainActivity.this,"Inserted successfully",Toast.LENGTH_SHORT).show(); 
					
				}
			}

		});

		buttonList.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				listEmp = empController.getAllEmployee();
				adapter = new ArrayAdapter<Employee>(MainActivity.this,android.R.layout.simple_list_item_1,listEmp);
				listView.setAdapter(adapter);				

			}
		});

		buttonDelete.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				int i = Integer.parseInt(textId.getText().toString());

				listEmp = empController.deleteEmployee(i);
				listView.setAdapter(adapter);
				Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_SHORT).show();

			}
		});

		buttonUpdate.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				int eid =Integer.parseInt(textId.getText().toString());
				String name  = textName.getText().toString();
				Double sal =Double.parseDouble(textSal.getText().toString());
				
				Department dept = (Department) spnDept.getSelectedItem();	
				Employee emp = new Employee(eid, name, sal, dept.getDeptId());
				
				long r = empController.updateEmployee(emp);
				if(r != -1)
				{
					Toast.makeText(MainActivity.this,"Updated successfully",Toast.LENGTH_SHORT).show(); 
				}
				
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
