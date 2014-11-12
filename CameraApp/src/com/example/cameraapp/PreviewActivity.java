package com.example.cameraapp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class PreviewActivity extends Activity
{
	Button buttonCapture,buttonPreview;
	FrameLayout frame;
	Camera camera;
	String Fname;
	Dialog d;
	FileOutputStream fOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview);
		
		buttonPreview = (Button)findViewById(R.id.buttonPreview);
		buttonCapture = (Button)findViewById(R.id.buttonCapture);
		frame = (FrameLayout)findViewById(R.id.myframe);
		
		camera = Camera.open();
		if(camera == null)		// no camera support
		{
			Toast.makeText(PreviewActivity.this,"No Camera FOund!!",5).show();
		}
		else
		{
			// start displaying preview
			CameraPreview preview = new CameraPreview(PreviewActivity.this, camera);
			frame.addView(preview);
		}
		
				
		buttonCapture.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				d =new Dialog(PreviewActivity.this);
				d.setContentView(R.layout.filename);
				Button buttonDone = (Button)d.findViewById(R.id.button1);
				d.show();
				
				buttonDone.setOnClickListener(new OnClickListener()
				{				
					@Override
					public void onClick(View v)
					{
						EditText editFileName =(EditText)d.findViewById(R.id.editText1);
						Fname = editFileName.getText().toString();	
						d.dismiss();
						camera.takePicture(null,null,new PictureListener());
					}
				});
												
			}
		});
		
		buttonPreview.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				camera.startPreview();		
			}
		});		
		
	}
	
	@Override
	protected void onDestroy()
	{	
		super.onDestroy();
		camera.release();

	}

	class PictureListener implements Camera.PictureCallback
	{
		@Override
		public void onPictureTaken(byte[] data, Camera camera)
		{
			String path = Environment.getExternalStorageDirectory()+"/"+Fname+".jpg";
			try
			{
				fOut = new FileOutputStream(path);
				fOut.write(data);
				fOut.flush();
				fOut.close();					
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				Log.e("Error:",e.toString());
			}			
		}		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
