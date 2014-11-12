package com.vaby.wdbviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity
{
	Button buttonShow;
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonShow = (Button)findViewById(R.id.button1);
		webView = (WebView)findViewById(R.id.webView1);
	
		webView.setWebViewClient(new MyWebViewClient()); 		// connects web view with client.
		
		buttonShow.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				webView.loadUrl("http://google.com");				
			}
		});
	}
	
	// to control the  function of keys on avd panel. here to go on previous webpage
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if(keyCode == KeyEvent.KEYCODE_BACK);
		{
			if(webView.canGoBack()) 	// if browser has history
			{
				webView.goBack();
				return true;
			}
		}

		return super.onKeyDown(keyCode, event);
	}

	// this will give behaviour like browser
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
			webView.loadUrl(url);
			
			return super.shouldOverrideUrlLoading(view, url);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
