package com.wimc.downloadingdemo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Button buttonDownload,buttonImageDownload;
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonDownload = (Button)findViewById(R.id.button1);
		buttonImageDownload = (Button)findViewById(R.id.button2);
		imageView = (ImageView)findViewById(R.id.imageView1);
		
		buttonDownload.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				String Url = "http://images.apple.com/main/rss/hotnews/hotnews.rss";
				DownloadTask task = new DownloadTask();
				task.execute(Url);
			}
		});
		
		buttonImageDownload.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				String url = "http://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&docid=obInKolUXQVTyM&tbnid=0N-RNYmuTWaEIM:&ved=0CAUQjRw&url=http%3A%2F%2Fwww.123rf.com%2Fphoto_9436980_smiley-face.html&ei=vRR_U5WLIoejugSU74E4&psig=AFQjCNGdNF0t-jOAgLwWsNtey7bI64Ci_w&ust=1400923705049937";
				ImageTask task = new ImageTask();
				task.execute(url);
			}
		});
	}

	class DownloadTask extends AsyncTask<String,Void, String>
	{
		ProgressDialog pd;
		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("Downloading");
			pd.setProgressStyle(pd.STYLE_SPINNER);
			pd.show();
		}
		@Override
		protected String doInBackground(String... params) 
		{
			String Url = params[0];
			
			// create HTTP client and connect URl 
			HttpClient client = new DefaultHttpClient(); 
			HttpGet get = new HttpGet(Url);
			String result = "";
			try 
			{
				HttpResponse responce =	client.execute(get); // this connects to the server
				InputStream in = responce.getEntity().getContent(); // it returns input stream
				
				//read line by line
				InputStreamReader reader = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(reader);
								
				while(true)
				{
					String s =br.readLine();
					if(s == null)
						break;
					result = result + s;					
				}
				br.close();
			} 
			catch (ClientProtocolException e)
			{				
				e.printStackTrace();
			} 
			catch (IOException e) 
			{				
				e.printStackTrace();
			}
			return result;
		}
	
		@Override
		protected void onPostExecute(String result)
		{			
			super.onPostExecute(result);
			pd.dismiss();
			String path = Environment.getExternalStorageDirectory()+"/apple.xml";
			try
			{
				FileWriter writer = new FileWriter(path);
				writer.write(result);
				writer.flush();
				writer.close();
				Toast.makeText(MainActivity.this, "Done", 5).show();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	class ImageTask extends AsyncTask<String, Void, Bitmap>
	{
	ProgressDialog pd;
		
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("Downloading");
			pd.setProgressStyle(pd.STYLE_SPINNER);
			pd.show();
		}
		
		@Override
		protected Bitmap doInBackground(String... params) 
		{
			String url = params[0];
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			InputStream istream = null;
			Bitmap bmp = null;
			try 
			{
				HttpResponse response = client.execute(get);
				istream =response.getEntity().getContent();
				bmp = BitmapFactory.decodeStream(istream);
				
			} 
			catch (ClientProtocolException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return bmp;
		}
		
		@Override
		protected void onPostExecute(Bitmap result)
		{			
			super.onPostExecute(result);
			pd.dismiss();
			if(result != null)
			{
				imageView.setImageBitmap(result);
			}
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
