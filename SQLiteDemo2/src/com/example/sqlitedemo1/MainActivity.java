package com.example.sqlitedemo1;

import java.util.ArrayList;

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
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText textId,textName,textSal;
	Button buttonInsert,buttonList,buttonDelete,buttonUpdate;
	ListView listView;
	ArrayList<String> listEmp = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		textId = (EditText)findViewById(R.id.editText1);
		textName = (EditText)findViewById(R.id.editText2);
		textSal = (EditText)findViewById(R.id.editText3);
		listView =(ListView)findViewById(R.id.listView1);
		buttonInsert= (Button)findViewById(R.id.button1);
		buttonList = (Button)findViewById(R.id.button2);
		buttonDelete = (Button)findViewById(R.id.button3);
		buttonUpdate = (Button)findViewById(R.id.button4);
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listEmp);
		listView.setAdapter(adapter);
		
		buttonInsert.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				int eid =Integer.parseInt(textId.getText().toString());
				String name  = textName.getText().toString();
				Double sal =Double.parseDouble(textSal.getText().toString());
		
				String q = "insert into employee values("+eid+",'"+name+"',"+sal+")";
				
				DataHelper helper = new DataHelper(MainActivity.this,"OfficeDB",null,DataHelper.VERSION);
				SQLiteDatabase db =helper.getWritableDatabase();
				db.execSQL(q);
				db.close();
				
				Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();
			}
			
		
		});
		
		buttonList.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				
				DataHelper helper = new DataHelper(MainActivity.this,"OfficeDB",null,DataHelper.VERSION);
				SQLiteDatabase db = helper.getWritableDatabase();
				// This method first checks whether dabase with specified name is exist or not
				// if not then create it by calling on create method and we will get reference of database
				// if yes then checks for that file name
				
				String q = "select * from employee";
				Cursor cursor = db.rawQuery(q,null);
				// cursor is memory represntation of table
				
				// count number of rows
				int c = cursor.getCount();
				listEmp.clear();
				while(cursor.moveToNext())
				{
					// column index start from 0
					int eid= cursor.getInt(0);
					String name = cursor.getString(1);
					double sal = cursor.getDouble(2);
					
					String Str = eid+":"+name+":"+sal;
					
					listEmp.add(Str);
				} 
				listView.setAdapter(adapter);
				
				cursor.close();	
				db.close();
			}
		});
		
		buttonDelete.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				int i = Integer.parseInt(textId.getText().toString());
				
				String q = "delete from employee where eid = "+i+"";
				
				DataHelper helper = new DataHelper(MainActivity.this,"OfficeDB",null,DataHelper.VERSION);
				SQLiteDatabase db =helper.getWritableDatabase();
				db.execSQL(q);
				db.close();
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
				
				String s = "Update employee set name ='"+name+"',salary = "+sal+" where eid = "+eid+"";
				DataHelper helper = new DataHelper(MainActivity.this,"OfficeDB",null,DataHelper.VERSION);
				SQLiteDatabase db =helper.getWritableDatabase();
				db.execSQL(s);
				db.close();
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
