package com.example.uiapp3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editTextAge;
	Button buttonVote;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextAge=(EditText)findViewById(R.id.editText1);
		buttonVote=(Button)findViewById(R.id.button1);
		buttonVote.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String age=editTextAge.getText().toString();
				int a=Integer.parseInt(age);
				if (a>=18)
				{
					Toast t=Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_LONG);
				    t.show();
				}
				else
				{
					Toast.makeText(MainActivity.this, "NO", Toast.LENGTH_LONG).show();
				}
				
				
				
			}
		}
	);
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
