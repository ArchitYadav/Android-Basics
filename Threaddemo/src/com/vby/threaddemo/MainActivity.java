package com.vby.threaddemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText editNum;
	TextView textViewcount;
	Button ButtonStart;
	ProgressBar ProgBar;
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editNum=(EditText) findViewById(R.id.editText1);
		textViewcount=(TextView)findViewById(R.id.textView1);
		ButtonStart=(Button)findViewById(R.id.button1);
		ProgBar=(ProgressBar)findViewById(R.id.progressBar1);
		
		handler =new MyHandler();
		
		ButtonStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				CountThread thread= new CountThread();
				thread.start();
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class MyHandler extends Handler
	{
		@Override
		public void handleMessage(Message msg) //msg recivd
		{
			super.handleMessage(msg);
			Bundle bundle=msg.getData();
			int c=bundle.getInt("count");
			textViewcount.setText(c+"");
			ProgBar.setProgress(c);
		}
		
	}
	class CountThread extends Thread
	{
		public void run() {
		
			int max=Integer.parseInt(editNum.getText().toString());
			ProgBar.setMax(max);
			for(int i=max;i>0;i--)
			{
				//textViewcount.setText(i+""); can not be passed,thread unsafe
				Bundle bundle=new Bundle(); //hashmap
				bundle.putInt("count", i);
				Message msg=new Message();
				msg.setData(bundle);
				handler.sendMessage(msg);
				
				try 
				{
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

	}
}
