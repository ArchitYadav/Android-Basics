package com.vaby.animationdemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	Button buttonAnimate;
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		buttonAnimate = (Button)findViewById(R.id.button1);
		imageView = (ImageView)findViewById(R.id.imageView1);
		
		buttonAnimate.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/*Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.set);
				imageView.setAnimation(anim);*/
			imageView.setBackgroundResource(R.drawable.sequence);
			AnimationDrawable anim= (AnimationDrawable) imageView.getBackground();
			anim.start();
			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
