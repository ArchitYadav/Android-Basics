package com.vaby.mathserviceconnectionapp;

import com.aidlcode.IUtil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	EditText editNum1,editNum2;
	Button buttonAdd,buttonPower,buttonSummetion;
	IUtil iUtil=null;
	MathServiceConnection serviceCon ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editNum1 = (EditText)findViewById(R.id.editText1);
		editNum2 = (EditText)findViewById(R.id.editText2);
		buttonAdd =(Button)findViewById(R.id.button1);
		buttonPower =(Button)findViewById(R.id.button2);
		buttonSummetion =(Button)findViewById(R.id.button3);
	
		// bind with service
		Intent intent = new Intent();
		 serviceCon = new MathServiceConnection();
		intent.setAction("com.vaby.aidlservicedemo.action_util");		
		boolean b = bindService(intent,serviceCon ,Service.BIND_AUTO_CREATE);
		
		if(b)
		{
			Toast.makeText(MainActivity.this, "Service connected",5).show();
		}
		else
		{
			Toast.makeText(MainActivity.this, "Can not connect",5).show();
		}
		
		buttonAdd.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				int x = Integer.parseInt(editNum1.getText().toString());
				int y = Integer.parseInt(editNum2.getText().toString());
				try 
				{
					int result = iUtil.add(x, y);
					Toast.makeText(MainActivity.this, "sum:"+result,5).show();
				} catch (RemoteException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		
		buttonPower.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				int x = Integer.parseInt(editNum1.getText().toString());
				int y = Integer.parseInt(editNum2.getText().toString());
				try 
				{
					int result = iUtil.power(x, y);
					Toast.makeText(MainActivity.this, "Power:"+result,5).show();
				} catch (RemoteException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		
		buttonSummetion.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				int x = Integer.parseInt(editNum1.getText().toString());
				
				try 
				{
					int result = iUtil.summation(x);
					Toast.makeText(MainActivity.this, "Summetion:"+result,5).show();
				} catch (RemoteException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
	}

	class MathServiceConnection implements ServiceConnection
	{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			// It catches the math class object returned from another application.
			iUtil = IUtil.Stub.asInterface(service);
			Log.e("Service","Connected");
		}

		@Override
		public void onServiceDisconnected(ComponentName name)
		{
			Toast.makeText(MainActivity.this,"Disconnected",5).show();			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		unbindService(serviceCon);
	}
}
