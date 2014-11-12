package com.example.cameraapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button buttonTakePicture;
	ImageView imageView;
	Camera camera;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonTakePicture = (Button)findViewById(R.id.button1);
		imageView =(ImageView)findViewById(R.id.imageView1);
		
		buttonTakePicture.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				camera = Camera.open();
				if(camera == null)		// no camera support
				{
					Toast.makeText(MainActivity.this,"No Camera FOund!!",5).show();
				}
				else
				{
					camera.takePicture(null,null,new PictureListener());				
				}
			}
		});
	}

	class PictureListener implements Camera.PictureCallback
	{
		@Override
		public void onPictureTaken(byte[] data, Camera camera)
		{
			// convert byte array in bitmap
			Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
			imageView.setImageBitmap(bmp);
			camera.release();
		}		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
