package com.vaby.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		
		
		Object smsObj[]= (Object []) intent.getExtras().get("pdus");  // key is fixed and given by android telephony service
		
		byte[] smsBytes = (byte[]) smsObj[0];
		
		SmsMessage sms = SmsMessage.createFromPdu(smsBytes);
		String smsData = sms.getMessageBody();
		String number = sms.getOriginatingAddress();
	
		Toast.makeText(context, number+":"+smsData, 5).show();	
	}

}
