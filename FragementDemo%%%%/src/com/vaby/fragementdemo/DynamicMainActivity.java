package com.vaby.fragementdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicMainActivity extends  FragmentActivity
{
	public ArrayList<String> listItems = new ArrayList<String>();
	TextView textViewItems,textViewAddnew;
	FragmentManager fragMan;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);
		textViewItems=(TextView) findViewById(R.id.textViewitems);
		textViewAddnew=(TextView) findViewById(R.id.textViewAddNew);
		
		fragMan=getSupportFragmentManager();
		
		textViewItems.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction transaction=fragMan.beginTransaction();
				transaction.replace(R.id.linaerFrag,new ItemListFragement());
				transaction.commit();
				
			}
		});
		textViewAddnew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction transaction=fragMan.beginTransaction();
				transaction.replace(R.id.linaerFrag,new AddFragment());
				transaction.commit();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
