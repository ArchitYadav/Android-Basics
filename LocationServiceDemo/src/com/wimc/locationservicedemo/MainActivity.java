package com.wimc.locationservicedemo;

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
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textviewLoc;
	Button buttonShowMap;
	LocationManager locManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textviewLoc=(TextView) findViewById(R.id.textView1);
		buttonShowMap=(Button) findViewById(R.id.button1);
		
		locManager=(LocationManager) getSystemService(LOCATION_SERVICE);
		
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, new MyLocationListener());
		
		buttonShowMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				Intent intent=new Intent();
				
				
				intent.setAction(Intent.ACTION_VIEW);
				String url="https://maps.google.com/?q=18.564885, 73.807003";
				Uri dataUri=Uri.parse(url);
				intent.setData(dataUri);
				startActivity(intent);
				
			}
		});
	}

	
	class MyLocationListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
		   double lat=location.getLatitude();
		   double lon=location.getLongitude();
		   textviewLoc.setText(lat+" : "+lon);
		   
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
