package com.vaby.stopwatch;


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

public class MainActivity extends Activity {

	TextView textViewClock;
	Button ButtonStart;
	ProgressBar ProgBar;
	int h=0;
	int m =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		textViewClock=(TextView)findViewById(R.id.textView1);
		ButtonStart=(Button)findViewById(R.id.button1);

		ButtonStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CountTask task=new CountTask();
				task.execute();

			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class CountTask extends AsyncTask<Void,Integer,Void>
	{	

		protected Void doInBackground(Void... params) {

			for (int  i = 0; i < 60; i++) 
			{	
				if(i<59)
				{
					try 
					{
						Thread.sleep(10);
					} catch (InterruptedException e)
					{

						e.printStackTrace();
					}
					publishProgress(h,m,i);
				}

				if(i==59)
				{
					i=0;
					m=m+1;
					if(m==59)
					{
						m=0;
						h=h+1;
					}
					publishProgress(h,m,i);
				}
			}
			return null;
		}
		@Override
		protected void onProgressUpdate(Integer... values)
		{

			super.onProgressUpdate(values);

			int s=values[2];
			int m=values[1];
			int h=values[0];
			textViewClock.setText(h+":"+m+":"+s);


		}
		/*@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
			pd.dismiss();
		}*/



	}

}