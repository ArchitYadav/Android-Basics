package com.wimc.assignment6;

import java.sql.Array;
import java.util.ArrayList;

import com.wimc.assignment6.controller.CategoryController;
import com.wimc.assignment6.controller.ItemController;
import com.wimc.assignment6.model.Category;
import com.wimc.assignment6.model.ItemDetails;
import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryActivity extends Activity 
{
	TextView textCategory;
	Button buttonGo;
	ListView list;
	Spinner spnCatHistory;
	ArrayList<Category> listcat=new ArrayList<Category>();
	ArrayList<ItemDetails> listItem=new ArrayList<ItemDetails>();
	ArrayAdapter<Category> adapterCat;
	ArrayAdapter<ItemDetails> adapterItem;
	HistoryAdapter adapterHist;
	ItemController itController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		CategoryController catController=new CategoryController(HistoryActivity.this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		buttonGo = (Button) findViewById(R.id.Go);
		list = (ListView) findViewById(R.id.listView1);
		spnCatHistory = (Spinner) findViewById(R.id.spinner1);
		  
		listcat = catController.getAllCategory();
		adapterCat=new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_item,listcat);
		spnCatHistory.setAdapter(adapterCat);
		itController=new ItemController(HistoryActivity.this);
		
		buttonGo.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				Category cat = (Category) spnCatHistory.getSelectedItem();
				listItem=itController.getItem(cat);
				adapterHist=new HistoryAdapter(HistoryActivity.this,listItem);
				list.setAdapter(adapterHist);
//				adapterItem=new ArrayAdapter<ItemDetails>(HistoryActivity.this,android.R.layout.simple_list_item_1,listItem);
//				list.setAdapter(adapterItem);
				
			}
		});
		
		
		
	}

}


class HistoryAdapter extends BaseAdapter
{
	Context context;
	ArrayList<ItemDetails> listItem;
	
	public HistoryAdapter(Context context, ArrayList<ItemDetails> listItem) 
	{
		super();
		this.context = context;
		this.listItem = listItem;
	}

	@Override
	public int getCount() 
	{
		return listItem.size();
	}

	@Override
	public Object getItem(int position ) 
	{
		return listItem.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		final ItemDetails item = listItem.get(position);
		LayoutInflater inf = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View myview=inf.inflate(R.layout.history_list,null);
		
		TextView textName = (TextView) myview.findViewById(R.id.display);
		Button buttonDetails = (Button) myview.findViewById(R.id.button1);
		
		textName.setText(item.getItemname()+":"+item.getPrice());
		
		buttonDetails.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(context, item.toString(),Toast.LENGTH_LONG).show();
			}
		});
		
		
		return myview;
	}
	
}
