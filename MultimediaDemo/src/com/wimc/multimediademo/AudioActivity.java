package com.wimc.multimediademo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AudioActivity extends Activity
{
	Button buttonPlay,buttonPause;
	MediaPlayer player;							// class to play audio files			
	@Override
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audio_activity);
		buttonPause = (Button)findViewById(R.id.button2);
		buttonPlay = (Button)findViewById(R.id.button1);
		
		player = MediaPlayer.create(this,R.raw.waka);
		
		buttonPlay.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				if(!player.isPlaying())
				{
					player.start();
				}
			}
		});
		
		buttonPause.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				if(player.isPlaying())
				{
					player.pause();
				}
			}
		});
		
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		if(player.isPlaying())
		{
			player.stop();
		}
	}
}
