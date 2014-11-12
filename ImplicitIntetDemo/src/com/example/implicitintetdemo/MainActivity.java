package com.example.implicitintetdemo;

import java.io.File;
import java.util.List;

import com.example.implicitintetdemo.R.string;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Browser;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView;
	String items[]={"Browser","Camera","Dialer","Gallary"};
	ImageView viewImageView;
	
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewImageView =  (ImageView)findViewById(R.id.imageView1);
		listView=(ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{
				Intent intent = new Intent();
				switch (arg2)
				{
					case 0:
						 intent.setAction(Intent.ACTION_VIEW);
						 String url = "http://msn.com";
						 Uri dataUri = Uri.parse(url);
						 intent.setData(dataUri);
						 
						 startActivity(intent);
						 break;
					
					case 1:
						 
						 intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
						 File f= new File(Environment.getExternalStorageDirectory(),"photo.jpg");
						 
						 intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(f));
						 startActivityForResult(intent,101);
						 
						 break;
					
					case 2:
						 
						 intent.setAction(Intent.ACTION_CALL);		//
						 String url1 = "tel:1234567";  				// Data type is define by attaching tel befor number
						 Uri dataUri1 = Uri.parse(url1);
						 intent.setData(dataUri1);
						 
						 startActivity(intent);
						 break;
					case 3:
						 
						Intent intentBrowseFiles = new Intent(Intent.ACTION_GET_CONTENT);
		                intentBrowseFiles.setType("image/*");
		                intentBrowseFiles.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		                startActivityForResult(intentBrowseFiles, 101); 
						 break;	 
				default:
					break;
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
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 101 && resultCode==RESULT_OK)
		{
			//Uri fileUri = data.getData();
			Log.e("file path:","Done");
			File f= new File(Environment.getExternalStorageDirectory(),"photo.jpg");
			Bitmap bnp = BitmapFactory.decodeFile(f.getPath());
			Log.e("file path:",f.getPath());
			viewImageView.setImageBitmap(bnp);
		}
	}

}
