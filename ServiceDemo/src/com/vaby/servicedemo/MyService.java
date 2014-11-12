package com.vaby.servicedemo;

import java.io.File;
import java.io.FileWriter;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service
{
	File  myFile=null;
	@Override
	public void onCreate()
	{
		super.onCreate();
		Toast.makeText(this,"On Create",5).show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Toast.makeText(this,"On Start:"+startId,5).show(); 
		
		String data = intent.getStringExtra("data");
		Toast.makeText(this,"data:"+data,5).show();
		
		File sdCard=Environment.getExternalStorageDirectory();
		File myDataDir=new File(sdCard,"data2");
		
		if(!myDataDir.exists())
		{
			myDataDir.mkdir();
		}
		myFile=new File(myDataDir, "data.txt");
		
		try
		{
			FileWriter writer = new FileWriter(myFile,true);
			writer.write(data+"\n");						
			writer.flush();
			writer.close();
		
		} catch (Exception e)
		{
			Log.e("Erroe in File",e.toString());          
		}	
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy()
	{
		Toast.makeText(this,"On Destroy",Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		
		return null;
	}

}
