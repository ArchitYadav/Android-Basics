package com.vaby.mapdemo;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	GoogleMap gMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fm = getFragmentManager();
		fm.findFragmentById(R.id.fragment1);
		MapFragment mapFrag = (MapFragment) fm.findFragmentById(R.id.fragment1);
		
		gMap = mapFrag.getMap();   // this gives object of google map and downloads the actual map
		
		//18.5122457,73.766837
		
		LatLng pune = new LatLng(18.500525, 73.827090);
		MarkerOptions place1 = new  MarkerOptions();
		place1.position(pune);
		place1.title("Pune, City of Maharashtra");
		place1.snippet("Education centre of India");
		place1.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		
		place1.draggable(true);
		gMap.addMarker(place1);
		
		// make location aware of your place.
		gMap.setMyLocationEnabled(true);
		
		gMap.setOnMapClickListener(new OnMapClickListener()
		{
			@Override
			public void onMapClick(LatLng arg0)
			{
				Toast.makeText(MainActivity.this, "Your location"+arg0, 5).show();			
			}
		});
		
		//18.506141, 73.831639
		//18.5524677,73.8128852 cdac
		
		LatLng erandwane = new LatLng(18.506141, 73.831639);
		LatLng Cdac = new LatLng(8.5524677,73.8128852);
		
		PolylineOptions pOtion = new PolylineOptions();
		pOtion.add(erandwane,Cdac);
		pOtion.color(Color.BLUE);
		pOtion.width(5);
		
		gMap.addPolyline(pOtion);
		gMap.setMapType(gMap.MAP_TYPE_SATELLITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
