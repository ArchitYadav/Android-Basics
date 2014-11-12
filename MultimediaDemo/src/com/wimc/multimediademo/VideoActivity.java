package com.wimc.multimediademo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity
{
	VideoView videoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.video);
			videoView  = (VideoView)findViewById(R.id.videoView1);			
			String videoPath = Environment.getExternalStorageDirectory()+"/tech.3gp";			
			videoView.setVideoPath(videoPath);
			
			MediaController mediaCon = new MediaController(this);
			
			videoView.setMediaController(mediaCon);
			
			videoView.start();
	}
}
