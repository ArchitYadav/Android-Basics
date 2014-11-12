package com.vaby.dialogueboxdemo;


import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView,textViewDOB;
	Button showButton,selectButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView =(TextView)findViewById(R.id.textView1);
		showButton=(Button)findViewById(R.id.button1);
		selectButton=(Button)findViewById(R.id.button2);
		textViewDOB =(TextView)findViewById(R.id.textView2);
		
		selectButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				final Dialog d2 = new Dialog(MainActivity.this);
				d2.setTitle("Pick Date");
				d2.setContentView(R.layout.date_view);
				final DatePicker picker = (DatePicker) d2.findViewById(R.id.datePicker1);
				
				Button buttonDone = (Button) d2.findViewById(R.id.button1);
				
				buttonDone.setOnClickListener(new OnClickListener()
				{
					
					@Override
					public void onClick(View v) {
						int year = picker.getYear();
						int month = picker.getMonth();
						int date = picker.getDayOfMonth();
						
						String str = date+"-"+month+"-"+year;
						textViewDOB.setText(str);
						d2.dismiss();
					}
				});
				d2.show();
			}
		});
		
		showButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				
				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Welcome");
				d.setContentView(R.layout.dialogue_view);
				
				final EditText editName = (EditText) d.findViewById(R.id.editText1);
				Button showButton =(Button)d.findViewById(R.id.button1);
				
				showButton.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v) {
						
						String sdr = editName.getText().toString();
						textView.setText(sdr);
						d.dismiss();
					}
				});
				
				d.show();
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
