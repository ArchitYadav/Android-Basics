package com.wimc.xmlassignment;

import java.io.FileReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	ListView listView;
	ArrayList<String> listProduct = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listProduct);

		XmlPullParserFactory factory;
		try 
		{
			factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser parser = factory.newPullParser();
			String xmlPath = Environment.getExternalStorageDirectory()+"/file.txt";

			FileReader reader = new FileReader(xmlPath);
			parser.setInput(reader);
			String text="";
			while(true)
			{
				
				int eventType = parser.next();
				if(eventType == XmlPullParser.END_DOCUMENT)
				{
					break;
				}

				if(eventType == XmlPullParser.START_TAG && parser.getName().equals("name"))
				{
					eventType = parser.next();
					text = parser.getText();
					text = text.concat(":");
					
				}

				if(eventType == XmlPullParser.START_TAG && parser.getName().equals("price"))
				{
					eventType = parser.next();
					text = text.concat(parser.getText());
					text = text.concat(":");
					
				}
				if(eventType == XmlPullParser.START_TAG && parser.getName().equals("quantity"))
				{
					eventType = parser.next();
					text= text.concat(parser.getText());
					listProduct.add(text);
				}

			}
			listView.setAdapter(adapter);
		} 
		catch (Exception e)
		{

			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
