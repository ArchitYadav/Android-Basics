package com.example.feedbackassignment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity 
{
	EditText editName,editEmail,editPassword,editCity;
	Button buttonRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_emp);
		buttonRegister =(Button)findViewById(R.id.button1);
		editName = (EditText)findViewById(R.id.editText1);
		editEmail = (EditText)findViewById(R.id.editText2);
		editPassword = (EditText)findViewById(R.id.editText3);
		editCity = (EditText)findViewById(R.id.editText4);
		
		
		buttonRegister.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				String name = editName.getText().toString();
				String password = editPassword.getText().toString();
				String city = editCity.getText().toString();
				String email = editEmail.getText().toString();
				
				
				 AddTask task = new AddTask();
				task.execute(name,password,city,email);
				
			}
		});
	}
	
	class AddTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params)
		{
			String result = "";
			String url = "http://192.168.76.53:9090/FeebackServerAssignment/RegisterServlet";
			
			NameValuePair nvp2 = new BasicNameValuePair("email", params[1]);
			NameValuePair nvp1 = new BasicNameValuePair("name", params[0]);
			NameValuePair nvp3 = new BasicNameValuePair("password", params[2]);
			NameValuePair nvp4 = new BasicNameValuePair("city", params[3]);
			
			List<NameValuePair> listNVP = new ArrayList<NameValuePair>();
			
			listNVP.add(nvp1);
			listNVP.add(nvp2);
			listNVP.add(nvp3);
			listNVP.add(nvp4);
			
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
			Toast.makeText(RegisterActivity.this, "Succes", 5).show();
		}
	}
}
