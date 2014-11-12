package com.example.sdimagedemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listViewImage;
	ImageView imageView;
	
	String fileNames[]=null;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listViewImage=(ListView)findViewById(R.id.listView1);
		imageView=(ImageView)findViewById(R.id.imageView1);
		
		final File myDataDir = new File(Environment.getExternalStorageDirectory(),"myData");
		fileNames = myDataDir.list();		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fileNames);
	
		listViewImage.setAdapter(adapter);
		
		listViewImage.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{
				String fname = fileNames[arg2];
				File imageFile = new File(myDataDir,fname);
				
				// convert image file into binary mapped imaged file i.e.bmp file
				Bitmap bmp = BitmapFactory.decodeFile(imageFile.getPath());
				
				//Set bitmap file on image view
				
				imageView.setImageBitmap(bmp);
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
