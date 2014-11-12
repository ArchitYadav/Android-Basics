package com.wimc.webclientdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.helpers.DefaultHandler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	TextView textViewResult;
	EditText editText1,editText2;
	Button buttonAdd,buttonNewEmp;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonAdd = (Button)findViewById(R.id.button1);
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		textViewResult = (TextView)findViewById(R.id.textView1);
		buttonNewEmp= (Button)findViewById(R.id.button2);
		
		buttonAdd.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				int a = Integer.parseInt(editText1.getText().toString());
				int b = Integer.parseInt(editText2.getText().toString());

				AddTask task = new AddTask();
				task.execute(a,b);

			}
		});
		
		buttonNewEmp.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				Intent intent =new Intent(MainActivity.this,AddEmpActivity.class);
				startActivity(intent);
			}
		});
	}
	class AddTask extends AsyncTask<Integer, Void, String>
	{
		@Override
		protected String doInBackground(Integer... params)
		{
			String result = "";
			String url = "http://192.168.76.53:9090/MyWebSite" +
			"/AddServlet?n1="+params[0]+"&n2="+params[1];

			result = HttpAdapter.getURLData(url); 			
			return result;
		}
		@Override
		protected void onPostExecute(String result)
		{
			super.onPostExecute(result);
			textViewResult.setText(result);
		}
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

}
