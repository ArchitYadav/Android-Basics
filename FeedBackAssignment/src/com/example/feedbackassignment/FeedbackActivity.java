package com.example.feedbackassignment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.example.feedbackassignment.RegisterActivity.AddTask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends Activity
{
	EditText editTextFeedback;
	Button buttonSubmit,buttonHistory;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		editTextFeedback = (EditText)findViewById(R.id.editText1);
		buttonSubmit=(Button)findViewById(R.id.button1);
		buttonHistory=(Button)findViewById(R.id.button2);
	
		buttonSubmit.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent in=getIntent();
				String email=in.getStringExtra("email");
				String feedback = editTextFeedback.getText().toString();
			
				AddTask task = new AddTask();
				task.execute(email,feedback);
			}
		});
		buttonHistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(FeedbackActivity.this,AllfeedbackActivity.class);
				startActivity(in);
				
			}
		});
	}
	class AddTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params)
		{
			String result = "";
			String url = "http://192.168.76.53:9090/FeebackServerAssignment/Feedback";
			
			NameValuePair nvp1 = new BasicNameValuePair("email", params[0]);
			
			NameValuePair nvp2 = new BasicNameValuePair("feedback", params[1]);
			
			
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
			if(result.equals("Success"))
			{
			//	Intent intent = new Intent (MainActivity.this,AllFeedbackActivity.class);
				//startActivity(intent);
			}
		}
	}
	
}
