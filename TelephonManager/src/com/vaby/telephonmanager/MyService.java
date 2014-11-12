package com.vaby.telephonmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyService extends Service
{
	TelephonyManager tm;
	String number = "";
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		tm.listen(new MyCallStateListner(),PhoneStateListener.LISTEN_CALL_STATE|PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
	
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	class MyCallStateListner extends PhoneStateListener
	{
		@Override
		public void onCallStateChanged(int state, String incomingNumber)
		{
			super.onCallStateChanged(state, incomingNumber);
			Toast.makeText(MyService.this, "Incoming NUmber:"+incomingNumber+""+state,5).show();
			
			if(state==TelephonyManager.CALL_STATE_RINGING)
			{
				WaitingThread thread = new WaitingThread();
				thread.start();
			}
		}
		@Override
		public void onDataConnectionStateChanged(int state)
		{		
			super.onDataConnectionStateChanged(state);
			Toast.makeText(MyService.this, "State:"+state,5).show();
		}
	}
	
	class WaitingThread extends Thread
	{
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			super.run();
			sleep(1500);
		
		
		if(curr == TelephonyManager.CALL_STATE_RINGING)
		{
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(number, null, "Busy",null,null);
		}
		}
	}
	

}
