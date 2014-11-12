package com.vaby.educationalsearch;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v4.util.ArrayMap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity 
{
	WebView webView1;
	AutoCompleteTextView autoText;
	ArrayAdapter<Colleges> adapter;
	ArrayList<Colleges> listOfCollege;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView1 = (WebView)findViewById(R.id.webView1);
		autoText = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		listOfCollege = new ArrayList<Colleges>();
		webView1.setWebViewClient(new MyWebViewClient());
		listOfCollege.add(new Colleges("vit","www.google.com"));
		listOfCollege.add(new Colleges("symbi","www.siu.edu.in"));
		listOfCollege.add(new Colleges("Coep","http://www.coep.org.in"));
		listOfCollege.add(new Colleges("MIT,pune","http://www.mitpune.com"));
		listOfCollege.add(new Colleges("VJTI","http://www.vjti.ac.in"));
		
		adapter = new ArrayAdapter<Colleges>(MainActivity.this, android.R.layout.simple_list_item_1,listOfCollege);
		autoText.setAdapter(adapter);
		
		autoText.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				autoText.showDropDown();
			}
		});
		autoText.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Colleges city =adapter.getItem(arg2);
				String url = city.getUrl();
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"Selected:"+city,6).show();
				webView1.loadUrl(url);
			
			}
		});

	}
	
	class MyWebViewClient extends WebViewClient
	{
ProgressDialog pd;
		
		//executes when page strats loading
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon)
		{
			super.onPageStarted(view, url, favicon);
			
			pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("Loading");
			pd.setProgressStyle(pd.STYLE_SPINNER);
			pd.show();
		}
		
		@Override
		public void onPageFinished(WebView view, String url) 
		{
			super.onPageFinished(view, url);
			pd.dismiss();
		}
		
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			webView1.loadUrl(url);
			
			return super.shouldOverrideUrlLoading(view, url);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
