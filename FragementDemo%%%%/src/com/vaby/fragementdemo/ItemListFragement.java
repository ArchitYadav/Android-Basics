package com.vaby.fragementdemo;

import android.app.Fragment;
import android.app.LauncherActivity.ListItem;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ItemListFragement extends android.support.v4.app.Fragment 
{
	ListView listView;
	Button buttonRefresh;
	ArrayAdapter<String> adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View myView = inflater.inflate(R.layout.item_list_fragement, container,false);
		listView = (ListView)myView.findViewById(R.id.listView1);
		buttonRefresh =(Button)myView.findViewById(R.id.button1);
		DynamicMainActivity mainAct = (DynamicMainActivity) getActivity(); //changes
		
		adapter = new ArrayAdapter<String>(mainAct,android.R.layout.simple_list_item_1,mainAct.listItems);
		
		buttonRefresh.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				listView.setAdapter(adapter);
			}
		});
		return myView;
	}
}
