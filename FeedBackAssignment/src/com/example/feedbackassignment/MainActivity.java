package com.example.feedbackassignment;



import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	TextView textView;
	Button buttonLogin,buttonRegister;
	EditText editTextEmail,editTextPassword;
	String a="";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonLogin = (Button)findViewById(R.id.button1);
		buttonRegister =(Button)findViewById(R.id.button2);
		editTextEmail = (EditText)findViewById(R.id.editText1);
		editTextPassword = (EditText)findViewById(R.id.editText2);
		textView=(TextView)findViewById(R.id.textView1);
		buttonLogin.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				a = editTextEmail.getText().toString();
				String b = editTextPassword.getText().toString();

				AddTask task = new AddTask();
				task.execute(a,b);
				
			}
		});
		
		buttonRegister.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent (MainActivity.this,RegisterActivity.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
	class AddTask extends AsyncTask<String, Void, String>
	{
		@Override
		protected String doInBackground(String... params)
		{
			String result = "";
			String url = "http://192.168.76.53:9090/FeebackServerAssignment/LoginServlet";
			
			NameValuePair nvp1 = new BasicNameValuePair("email", params[0]);			
			NameValuePair nvp2 = new BasicNameValuePair("password", params[1]);
			
			
			List<NameValuePair> listNVP = new ArrayList<NameValuePair>();
			
			listNVP.add(nvp1);
			listNVP.add(nvp2);
			
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
			textView.setText(result);
			
			if(result.equals("Login Successful"))
			{
				Intent intent = new Intent (MainActivity.this,FeedbackActivity.class);
			Log.e("a", a);
				intent.putExtra("email", a);
				startActivity(intent);
			}
			
		}
		
	}

}
