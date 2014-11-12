package com.wimc.assignment6;

import java.util.ArrayList;

import com.wimc.assignment6.controller.CategoryController;
import com.wimc.assignment6.controller.ItemController;
import com.wimc.assignment6.model.Category;
import com.wimc.assignment6.model.ItemDetails;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{	
	EditText editName,editPrice,editQuantity;
	TextView textcategory,textDOP,textDate;
	Spinner spinnerItems;
	Button buttonSelect,buttonAdd;
	
	ArrayList<ItemDetails> listItemDetails = new ArrayList<ItemDetails>();
	ArrayAdapter<ItemDetails> adapterItem;
	
	ArrayList<Category> listCategories = new ArrayList<Category>();
	ArrayAdapter<Category> adapterCat;
	
	CategoryController catController = new CategoryController(this);
	ItemController itemController = new ItemController(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		editName = (EditText) findViewById(R.id.itemname);
		editPrice = (EditText) findViewById(R.id.price);
		editQuantity = (EditText) findViewById(R.id.quantity);
		
		textcategory = (TextView) findViewById(R.id.category);
		textDate = (TextView) findViewById(R.id.datepattern);
		textDOP = (TextView) findViewById(R.id.dop);
		
		spinnerItems = (Spinner) findViewById(R.id.spinner1);
		listCategories = catController.getAllCategory();
		adapterCat=new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_item,listCategories);
		spinnerItems.setAdapter(adapterCat);

		buttonAdd = (Button) findViewById(R.id.addbutton);
		buttonSelect = (Button) findViewById(R.id.selectbutton);
				
		buttonAdd.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				
				String name = editName.getText().toString();
				double price =Double.parseDouble(editPrice.getText().toString());
				int quantity = Integer.parseInt(editQuantity.getText().toString());
				Category cat = (Category) spinnerItems.getSelectedItem();
				int cid=cat.getCatId();
				String date=textDate.getText().toString();
				ItemDetails item= new ItemDetails(name, price, quantity, cid, date);
				
				long result= itemController.insertItem(item);
				if(result!=-1){
					Toast.makeText(MainActivity.this, "Success ", Toast.LENGTH_LONG).show();
				}
				clear();
				
			}
		});
		
		buttonSelect.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Select Date");
				d.setContentView(R.layout.date);
				final DatePicker picker = (DatePicker) d.findViewById(R.id.datePicker1);
				Button buttonOk = (Button)d.findViewById(R.id.ok);
				buttonOk.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						int year = picker.getYear();
						int month = picker.getMonth()+1;
						int day = picker.getDayOfMonth();
						String str = day+"/"+month+"/"+year;
						textDate.setText(str);
						d.dismiss();
					}
				});
				d.show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}
	
	public void clear()
	{
		editName.setText("");
		editPrice.setText("");
		editQuantity.setText("");
		textDate.setText("dd/mm/yyyy");
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		switch (id) {
		case R.id.report:
			Intent intent = new Intent(MainActivity.this,ReportActivity.class);
			startActivity(intent);
			
			break;
		case R.id.history:
			Intent intent1 = new Intent(MainActivity.this,HistoryActivity.class);
			startActivity(intent1);
			
			break;
		case R.id.exit:
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
