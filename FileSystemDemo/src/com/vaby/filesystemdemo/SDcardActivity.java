package com.vaby.filesystemdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SDcardActivity extends Activity {
	EditText editName;
	Button buttonSave,buttonList;
	ListView listViewNames;

	ArrayList<String> listNames = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	File  myFile=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editName =(EditText)findViewById(R.id.editText1);
		buttonList=(Button)findViewById(R.id.button2);
		buttonSave=(Button)findViewById(R.id.button1);
		listViewNames=(ListView)findViewById(R.id.listView1);

		adapter =new ArrayAdapter<String>(SDcardActivity.this ,android.R.layout.simple_list_item_1,listNames);
		listViewNames.setAdapter(adapter);
		
		//craete mydata folder in SD card
		File sdCard=Environment.getExternalStorageDirectory();
		File myDataDir=new File(sdCard,"mydata");
		if(!myDataDir.exists())
		{
			myDataDir.mkdir();
		}
		myFile=new File(myDataDir, "wim.txt");
		
		buttonSave.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/*String fileName = "wimc.txt";
				String dataDirPath = getApplicationInfo().dataDir; //get path of internal folder in data directory
				Log.e("path:", dataDirPath);
				
				File myFile = new File(dataDirPath,fileName);	   // create anew file with specified path*/ 

				String name = editName.getText().toString();

				try
				{
					FileWriter writer = new FileWriter(myFile,true);//creating file writer object in appendable 
					writer.write(name+"\n");						//mode to add data in file
					writer.flush();
					writer.close();
					//editName.setText("");
				} catch (Exception e)
				{
					Log.e("Erroe in File",e.toString());          // printing error in log cat
				}	
							
			}
		});
		
		buttonList.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/*String fileName = "wimc.txt";
				String dataDirPath = getApplicationInfo().dataDir; //get path of internal folder in data directory
				Log.e("path:", dataDirPath);
				
				File myFile = new File(dataDirPath,fileName);	   // create anew file with specified path 
		*/
				try {
					FileReader reader = new FileReader(myFile);
					BufferedReader br = new BufferedReader(reader);
					listNames.clear();
					while(true)
					{
						String name = br.readLine();
						if(name == null)
							break;
						else
							listNames.add(name);
					}
					listViewNames.setAdapter(adapter);
					br.close();
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
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
