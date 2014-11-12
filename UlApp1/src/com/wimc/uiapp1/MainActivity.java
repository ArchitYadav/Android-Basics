package com.wimc.uiapp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView1;// this refers the actual objects...
	EditText editText1;
	Button buttonSayHello;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView1= (TextView)findViewById(R.id.textView1);  //refers textview type of object..return type is textview
		editText1= (EditText)findViewById(R.id.editText1);
		buttonSayHello=(Button)findViewById(R.id.button1);
		editText1.setText("enter your name");
		buttonSayHello.setOnClickListener(new MyListener());
	}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
//create inner class
	class MyListener implements OnClickListener
	{
	@Override
public void onClick(View v) {
	String name=editText1.getText().toString();
	String data="Hello "+name;
	textView1.setText(data);
}
		
		
		
	}
}
