package com.wimc.sum;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText editText1;
	EditText editText2;
	Button Add;
	TextView result;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		result= (TextView)findViewById(R.id.textView1);  //refers textview type of object..return type is textview
		editText1= (EditText)findViewById(R.id.editText1);
		Add=(Button)findViewById(R.id.button1);
		editText1.setText("enter your name");
		Add.setOnClickListener(new MyListener());
		
		
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
public void onClick(View v) 
	{
		int c;
	int num1 =Integer.parseInt(editText1.getText().toString());
	int num2 =Integer.parseInt(editText2.getText().toString());
	
c=num1+num2;
	String data=" "+c;
	result.setText(c);
}
}
}