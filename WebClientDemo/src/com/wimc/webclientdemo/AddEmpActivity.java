package com.wimc.webclientdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.helpers.DefaultHandler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEmpActivity extends Activity 
{
	TextView textViewResult;
	EditText editText1,editText2,editText3;
	Button buttonAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addemp);

		buttonAdd = (Button)findViewById(R.id.button1);
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		editText3 = (EditText)findViewById(R.id.editText3);
		textViewResult = (TextView)findViewById(R.id.textView1);

		buttonAdd.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				String id = editText1.getText().toString();
				String name = editText2.getText().toString();
				String salary = editText3.getText().toString();

				AddTask task = new AddTask();
				task.execute(id,name,salary);

			}
		});
	}
	class AddTask extends AsyncTask<String, Void, String>
	{
		@Override
		protected String doInBackground(String... params)
		{
			String result = "";
			String url = "http://192.168.76.53:9090/MyWebSite" +
			"/AddEmpServlet";
			
			NameValuePair nvp1 = new BasicNameValuePair("id", params[0]);
			NameValuePair nvp2 = new BasicNameValuePair("name", params[1]);
			NameValuePair nvp3 = new BasicNameValuePair("salary", params[2]);
			
			List<NameValuePair> listNVP = new ArrayList<NameValuePair>();
			
			listNVP.add(nvp1);
			listNVP.add(nvp2);
			listNVP.add(nvp3);
			
			HttpPost  post = new HttpPost(url);
			
			try
			{
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(listNVP);
				post.setEntity(entity);
				
			} 
			catch (UnsupportedEncodingException e) 
			{				
				e.printStackTrace();
			}
			result = HttpAdapter.postData(post); 			
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
