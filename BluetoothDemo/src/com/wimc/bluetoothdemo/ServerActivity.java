package com.wimc.bluetoothdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class ServerActivity extends Activity 
{
	TextView textViewMsg;
	BluetoothAdapter btadapter;
	MyHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.server);
		
		handler=new MyHandler();
		textViewMsg = (TextView)findViewById(R.id.textView1);

		btadapter = BluetoothAdapter.getDefaultAdapter();

		if(btadapter != null)
		{
			if(btadapter.isEnabled())
			{
				if(btadapter.getScanMode() == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
				{
					ComThread thread=new ComThread();
					thread.start();

				}
				else
				{
					Intent in =new Intent();
					in.setAction(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

					in.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
					startActivity(in);
				}
			}
		}
	}
	
	class MyHandler extends Handler
	{
		@Override
		public void handleMessage(Message msg)
		{		
			super.handleMessage(msg);
			String str=msg.getData().getString("data");
			textViewMsg.setText(str);
		}
	}
	
	class ComThread extends Thread
	{
		@Override
		public void run() 
		{
			super.run();
			UUID uuid=UUID.fromString("00000000-0000-0000-0000-0123456789AB");
			try
			{
				BluetoothServerSocket serverSocket=
				btadapter.listenUsingRfcommWithServiceRecord("new connection",uuid);
				
				BluetoothSocket dataSocket=serverSocket.accept();
				InputStream inStream=dataSocket.getInputStream();
				InputStreamReader reader=new InputStreamReader(inStream);
				
				BufferedReader br=new BufferedReader(reader);
				
				String str=br.readLine();
				//textViewMsg.setText(msg);
				Message msg=new Message();
				Bundle bn=new Bundle();
				bn.putString("data", str);
				msg.setData(bn);
				handler.sendMessage(msg);
				br.close();
				
				
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}	
		}

	}
}
