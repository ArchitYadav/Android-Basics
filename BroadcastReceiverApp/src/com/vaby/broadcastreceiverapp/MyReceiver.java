package com.vaby.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver // doen not extends context classs
{
	@Override
	public void onReceive(Context arg0, Intent arg1)
	{
		//arg1.getAction();
		String str = arg1.getStringExtra("Data");
		Toast.makeText(arg0,"Received:"+str, 5).show();
	}

}
