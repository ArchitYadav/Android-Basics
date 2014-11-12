package com.wimc.bluetoothdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ClientActivity extends ListActivity 
{
	ListView listViewDevice;
	ArrayList<String> listBTDevice = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	BluetoothAdapter btAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listViewDevice = getListView();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listBTDevice);
		listViewDevice.setAdapter(adapter);
		
		btAdapter = BluetoothAdapter.getDefaultAdapter();  //this is Factory method
		
		if(btAdapter == null)
		{
			Toast.makeText(this, "No Bluetooth!!", 5).show();
		}
		else 
		{
			if(!btAdapter.isEnabled())
			{
				Intent intent = new Intent();
				intent.setAction(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(intent, 101);
			}
			else
			{
				//start Discovery
				listDevices();
			}
		}
		listViewDevice.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
			{
				String info = listBTDevice.get(arg2);
				String address = info.split(",")[1];
				
				BluetoothDevice device = btAdapter.getRemoteDevice(address);
				
				ConnectionThread thread = new ConnectionThread(device);
				thread.start();
				
				// stop searching as we clicked on the device to connect
				btAdapter.cancelDiscovery();
			}
			
		});
	}
	
	class ConnectionThread extends Thread
	{
		BluetoothDevice device;
		ConnectionThread(BluetoothDevice device) 
		{
			this.device = device;
		}
		
		@Override
		public void run()
		{		
			super.run();
			UUID uuid = UUID.fromString("00000000-0000-0000-0000-0123456789AB");
			try
			{
				BluetoothSocket dataSocket = 
				device.createRfcommSocketToServiceRecord(uuid);
				
				if(dataSocket != null)
				{
					Log.e("Status:", "CONNECTED");
					//Start connection
					ComThread  thread = new ComThread(dataSocket);
					thread.start();
				}
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	class ComThread extends Thread
	{
		BluetoothSocket dataSocket;
	
		public ComThread(BluetoothSocket dataSocket)
		{
			this.dataSocket = dataSocket;
		}
		
		@Override
		public void run()
		{			
			super.run();
			try 
			{
				dataSocket.connect();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
				Log.e("SOCKET","connection error");
				try
				{
					dataSocket.close();
				} 
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
				return;
			}
			
			// send some msg to server
			try
			{
				OutputStream out = dataSocket.getOutputStream();
				PrintStream pout = new PrintStream(out);
				pout.println("Hello I am Client");
				pout.flush();
				pout.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 101 && resultCode == RESULT_OK)
		{
			// start discovery
			listDevices();
			
		}		
	}
	
	void listDevices()
	{
		DeviceReceiver receiver = new DeviceReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		
		registerReceiver(receiver, filter);
		
		btAdapter.startDiscovery();
	}
	
	class DeviceReceiver extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent)
		{
			if(intent.getAction().equals(BluetoothDevice.ACTION_FOUND))
			{
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				
				// information about Device found
				String strInfo = device.getName()+":"+device.getAddress();
				
				//add device found in the list of devices
				listBTDevice.add(strInfo);
				listViewDevice.setAdapter(adapter);
			}
		}		
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		btAdapter = null;
	}
	
}

