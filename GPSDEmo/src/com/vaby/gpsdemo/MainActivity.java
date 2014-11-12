// it need permission ACCESS_FINE_LOCATION

package com.vaby.gpsdemo;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
	TextView textView;
	Button buttonShow;
	EditText editLongitude,editLatitude;
	LocationManager lm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView)findViewById(R.id.textV);
		buttonShow = (Button)findViewById(R.id.button1);
		editLatitude = (EditText)findViewById(R.id.editText2);
		editLongitude = (EditText)findViewById(R.id.editText1);
		lm = (LocationManager)getSystemService(LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,10,new MyLocationListnear());
		
		final String longitude = editLongitude.getText().toString();
		final String latitude = editLatitude.getText().toString();
		
		buttonShow.setOnClickListener(new OnClickListener()
		{
		
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				String url = "http://maps.google.com/?q="+""+longitude+","+""+latitude+"";
				Uri dataUri = Uri.parse(url);
				intent.setData(dataUri);				 
				startActivity(intent);
				
			}
		});
	}

	
	class MyLocationListnear implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location)
		{
			double lat = location.getLatitude();
			double lon = location.getLongitude();
			
			textView.setText(lat+""+lon);
		}

		@Override
		public void onProviderDisabled(String provider)
		{
						
		}

		@Override
		public void onProviderEnabled(String provider)
		{
						
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)
		{
						
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
