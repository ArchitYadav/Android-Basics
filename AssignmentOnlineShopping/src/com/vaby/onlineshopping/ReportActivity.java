package com.vaby.onlineshopping;

import java.util.ArrayList;

import com.vaby.onlineshopping.controller.ProductController;
import com.vaby.onlineshopping.model.Product;

import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ReportActivity extends Activity
{
	ArrayList<String> listProducts;
	ListView listView;
	ArrayAdapter<String> adapter;
	ProductController productController;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.report_layout);
	
		listView = (ListView)findViewById(R.id.listView1);
		
		productController = new ProductController(this);
		listProducts=new ArrayList<String>();
		listProducts = productController.getExpenditure();		
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		listView.setAdapter(adapter);
	}

	
	

}
