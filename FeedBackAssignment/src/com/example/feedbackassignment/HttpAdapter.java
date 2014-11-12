package com.example.feedbackassignment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpAdapter 
{
	static String getURLData(String url)
	{
		String result="";
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response;
		try 
		{
			response = client.execute(get);
			InputStream in = response.getEntity().getContent();
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);

			while(true)
			{
				String s = br.readLine();
				if(s == null)
					break;
				result = result + s;
			}
			br.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	static String postData(HttpPost post)
	{
		String result="";
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		try 
		{
			response = client.execute(post);
			InputStream in = response.getEntity().getContent();
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);

			while(true)
			{
				String s = br.readLine();
				if(s == null)
					break;
				result = result + s;
			}
			br.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
