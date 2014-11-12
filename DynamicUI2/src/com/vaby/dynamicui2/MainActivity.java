package com.vaby.dynamicui2;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener 
{

	Button rect,circle;
	LinearLayout linear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rect=(Button)findViewById(R.id.button1);
		circle=(Button)findViewById(R.id.button2);
		linear=(LinearLayout)findViewById(R.id.linear1);

		rect.setOnClickListener(this);
		circle.setOnClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) 
	{
		int bid = v.getId();

		LayoutInflater inf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		switch(bid)
		{
		case R.id.button2:
			View myView = inf.inflate(R.layout.rect, null);

			final EditText editRadius = (EditText) myView.findViewById(R.id.editText1);
			Button buttonGo = (Button)myView.findViewById(R.id.button1);

			buttonGo.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					String str = editRadius.getText().toString();
					int r = Integer.parseInt(str);
					float area = (float) (3.14 * r * r);

					Toast t= Toast.makeText(MainActivity.this, ""+area,Toast.LENGTH_LONG);
					t.show();
				}
			});
			linear.removeAllViews();
			linear.addView(myView);
			break;

		case R.id.button1:
			View myView2 = inf.inflate(R.layout.circle,null);
			
			final EditText length = (EditText)myView2.findViewById(R.id.editText1);
			final EditText breadth =(EditText)myView2.findViewById(R.id.editText2);
			Button go = (Button)myView2.findViewById(R.id.button1);
			
			go.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					int l=Integer.parseInt(length.getText().toString());
					int b=Integer.parseInt(breadth.getText().toString()); 
					//String str2=breadth.getText().toString();
								
					double area = l * b;
					
					Toast t= Toast.makeText(MainActivity.this, ""+area,Toast.LENGTH_LONG);
					t.show();
				}
			});


			linear.removeAllViews();
			linear.addView(myView2);
		}

	}

}
