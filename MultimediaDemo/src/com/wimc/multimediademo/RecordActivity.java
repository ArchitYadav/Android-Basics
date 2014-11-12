package com.wimc.multimediademo;

import java.io.IOException;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RecordActivity extends Activity
{
	Button buttonRecord,buttonStop;
	MediaRecorder recorder; 
	Dialog d;
	String filePath,Fname;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.record);
		buttonRecord = (Button)findViewById(R.id.button1);
		buttonStop = (Button)findViewById(R.id.button2);
	
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		
		/*String filePath = Environment.getExternalStorageDirectory()+"/myVoice.mp3";
		recorder.setOutputFile(filePath);
		*/
		buttonRecord.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				d =new Dialog(RecordActivity.this);
				d.setContentView(R.layout.filename);
				Button buttonDone = (Button)d.findViewById(R.id.button1);
				final EditText editFileName =(EditText)d.findViewById(R.id.editText1);
				
				buttonDone.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						Fname = editFileName.getText().toString();				
					}				 	
					
				});
				filePath = Environment.getExternalStorageDirectory()+"/"+Fname+".mp3";
				recorder.setOutputFile(filePath);
				
				try {
					recorder.prepare();
					recorder.start();
				} 
				catch (IllegalStateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		buttonStop.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				recorder.stop();				
			}
		});
	}
}
