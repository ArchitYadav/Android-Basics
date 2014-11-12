package com.wimc.senserdemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	TextView textView;
	SensorManager sensorManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView)findViewById(R.id.textView1);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		sensorManager.registerListener(new MysensorListener(),
		        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
		        SensorManager.SENSOR_DELAY_NORMAL);
	}

	
	class MysensorListener implements SensorEventListener
	{

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy)
		{
			
		}

		@Override
		public void onSensorChanged(SensorEvent event)
		{
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];
			textView.setSingleLine(false);
			textView.setText("X = "+x+"\nY = "+y+"\nZ = "+z);
		}

		/*@Override
		public void onAccuracyChanged(int sensor, int accuracy)
		{
			
			
		}

		@Override
		public void onSensorChanged(int sensor, float[] values)
		{
			float x = arg[0];
			float y = arg1[1];
			float z = arg1[2];
		}*/
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
