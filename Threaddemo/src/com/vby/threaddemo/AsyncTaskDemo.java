package com.vby.threaddemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskDemo extends Activity {
	EditText editNum;
	TextView textViewcount;
	Button ButtonStart;
	ProgressBar ProgBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editNum=(EditText) findViewById(R.id.editText1);
		textViewcount=(TextView)findViewById(R.id.textView1);
		ButtonStart=(Button)findViewById(R.id.button1);
		ProgBar=(ProgressBar)findViewById(R.id.progressBar1);



		ButtonStart.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				CountTask task=new CountTask();
				int max=Integer.parseInt(editNum.getText().toString());
				task.execute(max);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class CountTask extends AsyncTask<Integer,Integer,String>
	{	
		ProgressDialog pd;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd=new ProgressDialog(AsyncTaskDemo.this);
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();
		}

		@Override
		protected String doInBackground(Integer... params) {
			int m=params[0];
			pd.setMax(m);
			for (int  i = 0; i < m; i++) 
			{
				publishProgress(i);
				try 
				{
					Thread.sleep(200);
				} catch (InterruptedException e)
				{

					e.printStackTrace();
				}
			}
			return "DONE";
		}
		@Override
		protected void onProgressUpdate(Integer... values)
		{
			super.onProgressUpdate(values);
			int c=values[0];
			textViewcount.setText("Count:"+c);
			ProgBar.setProgress(c);
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		Toast.makeText(AsyncTaskDemo.this, result, Toast.LENGTH_SHORT).show();
		pd.dismiss();
		}
		
	}

}
