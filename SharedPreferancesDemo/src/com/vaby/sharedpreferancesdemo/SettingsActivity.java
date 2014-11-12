package com.vaby.sharedpreferancesdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends Activity
{
	EditText editemail;
	Spinner spnColor;
	Button buttonOk;

	String arColor[]={"Red","Green","Blue","Yellow"};
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		editemail=(EditText)findViewById(R.id.editText1);
		spnColor=(Spinner)findViewById(R.id.spinner1);
		buttonOk=(Button)findViewById(R.id.button1);
		
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arColor);
		spnColor.setAdapter(adapter);
		
		buttonOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String email=editemail.getText().toString();
				int color=spnColor.getSelectedItemPosition();
				SharedPreferences sp=getSharedPreferences("setting", MODE_PRIVATE);
				SharedPreferences.Editor edit=sp.edit();
				edit.putString("userEmail",email);
				edit.putInt("themeColor", color);
				edit.commit();
				finish();
				}
		});
	}
}
