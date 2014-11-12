package com.viby.grid_viewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends Activity{
	TextView texttitle;
	ImageView imageview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		texttitle=(TextView) findViewById(R.id.textView1);
		imageview=(ImageView) findViewById(R.id.imageView1);
		
		Intent intent=getIntent();
		Photo photo = (Photo) intent.getSerializableExtra("photo");
		texttitle.setText(photo.getNames());
		imageview.setImageResource(photo.getImgId());
		
	}
	
	

}
