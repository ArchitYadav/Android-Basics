package com.vaby.broadcastreceiverapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	TextView textViewNum,textViewMsg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViewMsg = (TextView)findViewById(R.id.textView3);
		textViewNum = (TextView)findViewById(R.id.textView1);
		
		NewSMSReceiver smsReceiver = new NewSMSReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.provider.Telephony.SMS_RECEIVED");
		
		registerReceiver(smsReceiver, filter);
	}
	
	public class NewSMSReceiver extends BroadcastReceiver 
	{

		@Override
		public void onReceive(Context context, Intent intent) 
		{
			
			
			Object smsObj[]= (Object []) intent.getExtras().get("pdus");  // key is fixed and given by android telephony service
			
			byte[] smsBytes = (byte[]) smsObj[0];
			
			SmsMessage sms = SmsMessage.createFromPdu(smsBytes);
			String smsData = sms.getMessageBody();
			String number = sms.getOriginatingAddress();
		
		
			textViewNum.setText(number);
			textViewMsg.setText(smsData);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
