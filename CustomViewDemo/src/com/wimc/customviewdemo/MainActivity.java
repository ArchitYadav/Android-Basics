package com.wimc.customviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	Smiley simley1;
	TextView textPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simley1=(Smiley)findViewById(R.id.smiley1);
		textPosition=(TextView)findViewById(R.id.textView1);

		simley1.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

					float x=event.getX();
					float y=event.getY();

					if(x>=20 && x <= 40 && y >= 20 && y <= 40)
						textPosition.setText("Left Eye");

					if(x>=60 && x <= 80 && y >= 20 && y <= 40)
						textPosition.setText("Right Eye");

					if(x>=50 && x <= 55 && y >= 40 && y <= 55)
						textPosition.setText("Rectangle");
					/*else
						textPosition.setText(x+":"+y);*/
					return false;
				

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
