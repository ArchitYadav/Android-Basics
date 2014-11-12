package com.wimc.xmlparsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
	ListView listView;
	ArrayList<String> listNews =  new ArrayList<String>();
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listNews);
		
		
		try 
		{
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser parser = factory.newPullParser();
			String xmlPath = Environment.getExternalStorageDirectory()+"/apple.xml";
			
			FileReader reader = new FileReader(xmlPath);
			parser.setInput(reader);
			
			//start parsing
			while(true)
			{
				int eventType = parser.next();
				// if reader reached end of line
				if(eventType == XmlPullParser.END_DOCUMENT)
				{
					break;
				}
				// read the data of title tag
				if(eventType == XmlPullParser.START_TAG && parser.getName().equals("title"))
				{
					eventType = parser.next();
					String text = parser.getText();
					listNews.add(text);
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
