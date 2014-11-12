package com.example.uiapp4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	RadioButton radioMale,radioFemale;
	EditText editName;
	CheckBox checkBE, checkME,checkPhd;
	Button buttonSave;
	EditText editResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editName=(EditText)findViewById(R.id.editText1);
		buttonSave=(Button)findViewById(R.id.button1);
		radioMale=(RadioButton)findViewById(R.id.radio0);
		radioFemale=(RadioButton)findViewById(R.id.radio2);
		checkBE=(CheckBox)findViewById(R.id.checkBox1);
		checkME=(CheckBox)findViewById(R.id.checkBox2);
		checkPhd=(CheckBox)findViewById(R.id.checkBox3);
		buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name=editName.getText().toString();
				String gender="";
				if (radioMale.isChecked())
				{
					gender="Male";
				}
					else
					{
						gender="Female";
				}
				String education="";
				if(checkBE.isChecked())
				{
					education="BE";
					}
				if(checkME.isChecked())
				{
					education="ME" + education;
					}
				if(checkPhd.isChecked())
				{
					education=",Phd";
					}
				String data=name+gender+education;
				editResult.setText(data);
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
