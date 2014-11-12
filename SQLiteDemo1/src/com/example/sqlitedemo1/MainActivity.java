package com.example.sqlitedemo1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	EditText textId,textName,textSal;
	Button buttonInsert,buttonList;
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
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listEmp);
		
		listView.setAdapter(adapter);
		
		buttonInsert.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				
			}
		});
		
		buttonList.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				
				DataHelper helper = new DataHelper(MainActivity.this,"OfficeDB",null,1);
				SQLiteDatabase db = helper.getWritableDatabase();
				// This method first checks whether dabase with specified name is exist or not
				// if not then create it by calling on create method and we will get reference of database
				// if yes then checks for that file name
				
				
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
