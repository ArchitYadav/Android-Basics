package com.example.assign_gps_sms;




import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editTextNum;
	Button buttonSend;
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextNum=(EditText)findViewById(R.id.editText1);
		buttonSend=(Button)findViewById(R.id.button1);
		webView=(WebView)findViewById(R.id.webView1);
		buttonSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num=editTextNum.getText().toString();
				SmsManager sms = SmsManager.getDefault();
				sms.sendTextMessage(num, null,"GET_LOCATION", null, null);
				//sendSMS("5556", "Hi You got a message!");

			}
		});

		NewSMSReciever smsReceiver=new NewSMSReciever();
		IntentFilter filter=new IntentFilter();
		filter.addAction("android.provider.Telephony.SMS_RECEIVED");
		registerReceiver(smsReceiver, filter);

	}
	class NewSMSReciever extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "New SMS......", Toast.LENGTH_LONG).show();

			Object smsObj[] = (Object []) intent.getExtras().get("pdus"); 
			byte[] smsBytes = (byte[])smsObj[0]; 

			SmsMessage sms = SmsMessage.createFromPdu(smsBytes);

			//sms contains msg body 
			String smsData=sms.getMessageBody();
			//to get originated address of sender
			String number = sms.getOriginatingAddress();
			String latlong="";
			if(smsData.startsWith("LAST_LOCATION"))
			{
				latlong=smsData.substring(14);
				Log.e("smsData.... ",""+smsData);
				intent.setAction(Intent.ACTION_VIEW);
				String url="https://www.google.co.in/maps/@"+latlong;
				Uri dataUri=Uri.parse(url);
				intent.setData(dataUri);
				startActivity(intent);

			}
			Toast.makeText(MainActivity.this,"Sms data....."+latlong ,5).show();
			Log.e("smsData.... ",""+smsData);

			//Toast.makeText(context, number+":"+smsData, Toast.LENGTH_LONG).show();
			/*textViewNum.setText(number);
			textViewMsg.setText(smsData);*/


		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
